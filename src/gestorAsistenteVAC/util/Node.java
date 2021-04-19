package gestorAsistenteVAC.util;

/**
 * Clase generica nodo, pensada para ser utilizada en la implementación de listas. 
 * @author Dafty-Punky-Boy
 * @version 1.0, 17/04/2021
 * 
 * @param next Referencia al siguiente nodo de la lista.
 * @param previous Referencia al nodo previo de la lista.
 * @param data El dato de tipo T que almacena el nodo.
 */
public class Node<T> {
	T data;
	Node<T> next;
	Node<T> prev;
	
	/**
	 * Crea un nodo que almacena un dato de tipo T.
	 * @param data El dato de tipo T.
	 */
	Node(T data) {
		this.data = data;
		next = null;
		prev = null;
	}
	
	/**
	 * Setter de data.
	 * @param data El dato de tipo T que se quiere establecer.
	 */
	public void setData(T data) {
		this.data = data;
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
	 * Getter de data.
	 * @return El dato u objeto de tipo T que almacena el nodo.
	 */
	public T getData() {
		return data;
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
