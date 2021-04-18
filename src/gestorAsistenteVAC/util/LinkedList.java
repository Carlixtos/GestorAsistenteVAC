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
	public Node<T> head;
	public Node<T> tail;
	
	/**
	 * Crea una lista vacía.
	 */
	public LinkedList(){
		head = null;
		tail = null;
	}
	
	/**
	 * Agrega un nodo almacenando un dato de tipo T al frente de la lista.
	 * @param node El nodo de tipo T que se desea agregar.  
	 */
	public void addFront(T data) {
		Node<T> node = new Node<T>(data);
		
		if(tail == null) {
			head = node;
			tail = head;
		}
		
		else {
			node.next = head;
			head.previous = node;
			head = node;
		}
	}
	
	/**
	 * Agrega un nodo almacenando un dato de tipo T al final de la lista.
	 * @param node El nodo de tipo T que se desea agregar.
	 */
	public void addBack(T data) {
		Node<T> node = new Node<T>(data);
		
		if(tail == null) {
			head = node;
			tail = head;
		}
		
		else {
			node.previous = tail;
			tail.next = node;
			tail = node;
		}
	}
}
