package gestorAsistenteVAC.util;

public class LinkedList<T> {
	Node<T> head;
	Node<T> tail;
	
	LinkedList(){
		head = null;
		tail = null;
	}
	
	public void addFront(T data) {
		Node<T> nodeTemp = new Node<T>(data);
		
		if(tail == null) {
			head = nodeTemp;
			tail = head;
		}
		
		else {
			nodeTemp.next = head;
			head.previous = nodeTemp;
			head = nodeTemp;
		}
	} 
}
