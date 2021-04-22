package gestorAsistenteVAC.util;

/**
 * Clase generica nodo, pensada para ser utilizada en la implementación de listas. 
 * @author Dafty-Punky-Boy
 * @version 1.0, 17/04/2021
 * 
 * @param next Referencia al siguiente nodo de la lista.
 * @param previous Referencia al nodo previo de la lista.
 * @param key El dato de tipo T que almacena el nodo.
 */
public class Node<T> {
	private T key;
	private Node<T> next;
	private Node<T> prev;
	
	/**
	 * Crea un nodo que almacena un dato de tipo T.
	 * @param key El dato de tipo T.
	 */
	Node(T key) {
		this.key = key;
		next = null;
		prev = null;
	}
	
	/**
	 * Setter de key.
	 * @param key El dato de tipo T que se quiere establecer.
	 */
	public void setKey(T key) {
		this.key = key;
	}
	
	/**
	 * Setter de next.
	 * @param next El nodo al que se quiere referenciar como siguiente.
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	/**
	 * Setter de prev.
	 * @param prev El nodo al que se quiere referenciar como previo.
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	/**
	 * Getter de key.
	 * @return El dato u objeto de tipo T que almacena el nodo.
	 */
	public T getKey() {
		return key;
	}
	
	/**
	 * Getter de next.
	 * @return El siguiente nodo.
	 */
	public Node<T> getNext(){
		return next;
	}
	
	/**
	 * Getter de prev.
	 * @return El nodo anterior. 
	 */
	public Node<T> getPrev(){
		return prev;
	}
	
	
	
}
