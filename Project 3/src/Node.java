
public class Node {
	private Node next;
	private frecuans Data;

	public Node(frecuans data) {

		this.Data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public frecuans getData() {
		return Data;
	}

	public void setData(frecuans data) {
		Data = data;
	}

	@Override
	public String toString() {
		return "Frecuans [next=" + next + ", Data=" + Data + "]";
	}
	
	
	
}

