
public class ListaMemoria {
	private Bloco first;
	private int size;
	private int tamanhoTotal;
	private int tamanhoUsado;
	private int tamanhoQuick = 0;
	
	public int getTamanhoQuick() {
		return tamanhoQuick;
	}

	public void setTamanhoQuick(int tamanhoQuick) {
		this.tamanhoQuick = tamanhoQuick;
	}

	public int getTamanhoUsado() {
		return tamanhoUsado;
	}

	public void setTamanhoUsado(int tamanhoUsado) {
		this.tamanhoUsado = tamanhoUsado;
	}

	public ListaMemoria(int tamanhoTotal){
		this.tamanhoTotal = tamanhoTotal;
		tamanhoUsado = 0;
	}
	
	public Bloco getFirst() {
		return first;
	}

	public void setFirst(Bloco first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTamanhoTotal() {
		return tamanhoTotal;
	}

	public void setTamanhoTotal(int tamanhoTotal) {
		this.tamanhoTotal = tamanhoTotal;
	}

	public void adicionar(Bloco b){
		Bloco aux = first;
		if(first == null){
			first = b;
			size++;
		} else {
			while(aux.getNext() != null){
				aux = aux.getNext();
			}
			Bloco aux2 = b;
			aux.setNext(aux2);
			size++;
		}
	}
	
	public void show(){
		Bloco aux = first;
		while(aux != null){
			System.out.println(aux.getId() + " " + aux.getTamanho() + " " + aux.isUsado());
			aux = aux.getNext();
		}
		
		System.out.println();
	}
	
	public Bloco search(int pos){
		Bloco aux = first;
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
	
	public boolean cheio(int tamanho){
		if(tamanhoUsado + tamanho > tamanhoTotal){
			return true;
		} else {
			return false;
		}
	}
	
	public int fitPos(Process p){
		int pos = 0;
		int menor = 200000;
		
		for(int i = 0; i < size; i ++){
			if ((search(i).getTamanho() < menor) && (p.getpTamanho() <= search(i).getTamanho()) && !search(i).isUsado()){
				menor = search(i).getTamanho();
				System.out.println(p.getpTamanho()  + "Entrou " + search(i).getId());
				pos = i;
			}
		}
		
		if(menor == 200000){
			pos = 1234;
			return pos;
		}
		return pos;
		
	}
	
	public int firstFit(Process p){
		int pos = 1234;
		
		for(int i = 0; i < size; i ++){
			if ((p.getpTamanho() <= search(i).getTamanho()) && !search(i).isUsado()){
				System.out.println(p.getpTamanho()  + "Entrou " + search(i).getId());
				pos = i;
				return pos;
			}
		}
		return pos;
	}
	
	public void split(int pos, int tamanhoDesejado, Memoria m, Process p){
		Bloco aux = first;
		while(aux != null){
			if(aux.getId() == pos){
				break;
			}
			aux = aux.getNext();
		}
		
		if(aux.getNext() == null){
			Bloco b = new Bloco(aux.getTamanho() - tamanhoDesejado, 0, aux.getId()+ 1, false);
			aux.setNext(b);
			aux.setTamanho(tamanhoDesejado);
			aux.setTamanhoUsado(tamanhoDesejado);
			aux.setProcesso(p);
			p.setBloco(aux.getId());
			size++;
			m.novo(b);
			tamanhoUsado = aux.getTamanho() + tamanhoUsado;
		} else {
			Bloco aux2 = aux.getNext();
			Bloco b = new Bloco(aux.getTamanho() - tamanhoDesejado, 0, aux.getId()+ 1, false);
			b.setNext(aux2);
			aux.setNext(b);
			aux.setTamanho(tamanhoDesejado);
			aux.setTamanhoUsado(tamanhoDesejado);
			aux.setProcesso(p);
			p.setBloco(aux.getId());
			size++;
			m.novo(b);
			tamanhoUsado = aux.getTamanho() + tamanhoUsado;
		}
		
		for(int i = 0; i < size; i ++){
			search(i).setId(i);
		}
	}
	
	public void remover(int pos){
		Bloco aux = first;
		
		if(pos == 0){
			first = aux.getNext();
			size--;
			tamanhoUsado = tamanhoUsado - aux.getTamanho();
		} else {
			if(pos == size - 1){
				while(aux.getNext().getNext() != null){
					aux = aux.getNext();
				}
				tamanhoUsado = tamanhoUsado - aux.getNext().getTamanho();
				aux.setNext(null);
				size--;

			} else {
				for(int i = 0; i < pos - 1; i ++){
					aux = aux.getNext();
				}
				System.out.println("teste: " + aux.getNext().getNext().getId() + " " + aux.getNext().getNext().isUsado());
				if(aux.getNext().getNext()!= null) {
					aux.setNext(aux.getNext().getNext());
				}
				size--;
				tamanhoUsado = tamanhoUsado - aux.getNext().getTamanho();
			}
		}
		
	}
	
	public boolean juntar(){
		Bloco aux = first;
		while(aux.getNext() != null){
			System.out.println(aux.isUsado());
			if(!aux.isUsado() && !aux.getNext().isUsado()){
				System.out.println("Juntar " + aux.getId() + " com " + aux.getNext().getId());
				aux.setTamanho(aux.getTamanho() + aux.getNext().getTamanho());
				aux.setTamanhoUsado(0);
				remover(aux.getId() + 1);
				return true;
			}
			
			if(aux.getNext() != null){
				aux = aux.getNext();
			}
		}
		for(int i = 0; i < size; i ++){
			search(i).setId(i);
			if(search(i).getProcesso() != null){
				search(i).getProcesso().setBloco(search(i).getId());
			}
		}
		return false;
	}
	
	public boolean juntavel(){
		Bloco aux = first;
		while(aux.getNext() != null){
			System.out.println(aux.isUsado());
			if(!aux.isUsado() && !aux.getNext().isUsado()){
				return true;
			}
			
			if(aux.getNext() != null){
				aux = aux.getNext();
			}
		}
		return false;
	}
	
	public void refazerId(){
		for(int i = 0; i < size; i ++){
			search(i).setId(i);
			if(search(i).getProcesso() != null){
				search(i).getProcesso().setBloco(search(i).getId());
			}
		}
	}
	
}
