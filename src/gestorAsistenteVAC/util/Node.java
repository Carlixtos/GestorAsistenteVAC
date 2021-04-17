package gestorAsistenteVAC.util;

/**
 * Clase generica nodo, pensada para ser utilizada en la implementación de listas doblemente enlazadas. 
 * @author Dafty-Punky-Boy
 * @version 1.0, 17/04/2021
 */

public class Node<T> {
	T data;
	Node<T> next;
	Node<T> previous;
	
	Node(T data){
		this.data = data;
		next = null;
		previous = null;
	}
	
	/**
	 * Crea un nodo que almacena un dato de tipo T.
	 * @param next Referencia al siguiente nodo de la lista.
	 * @param previous Referencia al nodo previo de la lista.
	 * @param data El dato de tipo T que almacena el nodo.
	 */
}
