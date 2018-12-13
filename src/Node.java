
public class Node {
	private Process process;
	private Node next;
	private Node previous;
	public Node(Process process){
		this.process = process;
		next = null;
		previous = null;
	}
	public Process getProcess() {
		return process;
	}
	public void setProcess(Process process) {
		this.process = process;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
}
