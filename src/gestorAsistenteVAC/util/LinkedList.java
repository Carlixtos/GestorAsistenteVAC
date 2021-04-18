package gestorAsistenteVAC.util;

/**
 * Clase generica lista enlazada, una implementación de una lista doblemente enlazada. 
 * @author Dafty-Punky-Boy
 * @version 1.0, 17/04/2021
 * 
 * @param tail Referencia al primer nodo de la lista.
 * @param head Referencia al ultimo nodo de la lista. 
 */
public class LinkedList<T> {
	Node<T> head;
	Node<T> tail;
	
	/**
	 * Crea una lista vacía.
	 */
	public LinkedList(){
		head = null;
		tail = null;
	}
	
	/**
	 * Setter de head.
	 * @param head Nodo que se quiere asignar a la cabeza de la lista.
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}
	
	/**
	 * Setter de tail.
	 * @param tail Nodo que se quiere asignar a la cola de la lista.
	 */
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	
	/**
	 * Getter de head.
	 * @return El nodo correspondiente a la cabeza de la lista.
	 */
	public Node<T> getHead() {
		return head;
	}
	
	/**
	 * Getter de tail.
	 * @return El nodo correspondiente a la cola de la lista.
	 */
	public Node<T> getTail(){
		return tail;
	}
	
	public boolean isEmpty() {
		if(tail == null) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Agrega un nodo almacenando un dato de tipo T al frente de la lista.
	 * @param data El dato de tipo T a agregar.  
	 */
	public void addFront(T data) {
		Node<T> node = new Node<T>(data);
		
		if(isEmpty()) {
			head = node;
			tail = head;
		}
		
		else {
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
	}
	
	/**
	 * Agrega un nodo almacenando un dato de tipo T al final de la lista.
	 * @param data El dato de tipo T a agregar.
	 */
	public void addBack(T data) {
		Node<T> node = new Node<T>(data);
		
		if(isEmpty()) {
			head = node;
			tail = head;
		}
		
		else {
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		}
	}
	
	
	public Node<T> search(T data) {
		if(isEmpty()){
		}
	}
	
}
