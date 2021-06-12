
public class LinkedList {
	Node first = null;
	Node last = null;

	public void InsertionSorted(frecuans data) {
		Node newNode = new Node(data);
		if (first == null) {
			first = newNode;
		} else if (data.compareTo(first.getData()) < 0) {
			newNode.setNext(first);
			first = newNode;
		} else {
			Node pre = first;
			Node curr = first.getNext();
			while (curr != null && (data.compareTo(curr.getData()) > 0)) {
				pre = curr;
				curr = curr.getNext();
			}
			newNode.setNext(curr);
			pre.setNext(newNode);
		}
	}

	public int Size() {
		Node curr = first;
		int count = 0;
		while (curr != null) { // Find a linked list data Size using counteer
			count++;
			curr = curr.getNext();
		}
		return count;
	}
	
	public int Sum() {
		Node curr = first;
		int sum = 0;
		while (curr != null) { 
			sum+=curr.getData().getFrec();
			curr = curr.getNext();
		}
		return sum;
	}

	void printReverse(Node head) {
		if (head == null)
			return;

		printReverse(head.getNext());
		System.out.print(head.getData() + "\n");
	}

	public void print() { // and in this function we print data
		Node curr = first;
		while (curr != null) {
			System.out.print(curr.getData());
			curr = curr.getNext();
			
		}
	}
	public String print1() { // and in this function we print data
		Node curr = first;
		String S=" ";
		while (curr != null) {
			System.out.print(curr.getData());
			curr = curr.getNext();
			S +=curr.getData()+" , ";
		}
		return S;
	}
	
	public String toString() {
        String result = "";
        Node curr = first;
        while(curr != null){
            result += curr.getData();
            if(curr != null){
                 result += "";
            }
            curr = curr.getNext();
        }
        return  result;
}

}
