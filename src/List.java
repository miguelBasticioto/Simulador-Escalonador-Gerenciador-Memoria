public class List {
	private Node first;
	private Node last;
	private int size;
	
	public List(){
		first = null;
		last = null;
	}

	public int getSize(){
		return size;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}
	
	public void insertionSort(Process p) {
		Node aux = first;
		if(first == null){
			first = new Node(p);
			last = new Node(p);
			size++;
		} else {
			if(p.getDeadLine() < first.getProcess().getDeadLine()){
				Node aux2 = new Node(p);
				aux2.setNext(aux);
				first = aux2;
				size++;
			} else {
				if(p.getDeadLine() > last.getProcess().getDeadLine()){
					while(aux.getNext() != null){
						aux = aux.getNext();
					}
					Node aux2 = new Node(p);
					aux.setNext(aux2);
					last = aux2;
					size++;
				} else {
					while(aux.getNext() != null){
						if(p.getDeadLine() > aux.getNext().getProcess().getDeadLine()){
							aux = aux.getNext();
						} else {
							Node aux2 = new Node(p);
							aux.getNext().setPrevious(aux2);
							aux2.setNext(aux.getNext());
							aux.setNext(aux2);
							aux2.setPrevious(aux);
							size++;
							break;
						}
					}
				}
			}
		}
	}
	
	public void enqueue(Process p){
		Node aux = first;
		if(first == null){
			first = new Node(p);
			last = new Node(p);
			size++;
		} else {
			while(aux.getNext() != null){
				aux = aux.getNext();
			}
			Node aux2 = new Node(p);
			aux.setNext(aux2);
			last = aux2;
			size++;
		}
	}
	
	public void removeFirst(){
		if(size == 1){
			first = null;
			last = null;
			size--;
		} else {
			if (first != null){
				first = first.getNext();
				first.setPrevious(null);
				size--;
			}
		}
	}
	
	public void removePos(int pos){
		if(pos == 0){
			Node aux = first;
			first = aux.getNext();
			size--;
		} else {
			if(pos == size - 1){
				Node aux = first;
				while(aux.getNext() != last){
					aux = aux.getNext();
				}
				aux.setNext(null);
				last = aux;
				size--;
			} else {
				//meio da lista
				Node aux = first;
				int cont = 0;
				while(cont + 1 != pos){
					aux = aux.getNext();
					cont++;
				}
				aux.setNext(aux.getNext().getNext());
				aux.getNext().setPrevious(aux);
			}
		}
	}
	
	public void show(){
		Node aux = first;
		while(aux != null){
			System.out.println(aux.getProcess().getDeadLine());
			aux = aux.getNext();
		}
	}
	
	public Node search(int pos){
		Node aux = first;
		int cont = 0;
		while(aux != null){
			if(cont == pos){
				return aux;
			}
			cont ++;
			aux = aux.getNext();
		}
		return null;
	}
	
	public boolean isEmpty(){
		if(first == null) {
			return true;
		} else {
			return false;
		}
	}
}
