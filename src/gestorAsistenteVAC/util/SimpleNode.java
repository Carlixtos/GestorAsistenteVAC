package gestorAsistenteVAC.util;

/**
 * Clase generica nodo simple, pensada para ser utilizada en la implementación de listas enlazadas. 
 * @author Dafty-Punky-Boy
 * @version 1.0, 17/04/2021
 */

public class SimpleNode<T> {
	T data;
	SimpleNode<T> next;
	
	SimpleNode(T data){
		this.data = data;
		next = null;
	}
	
	/**
	 * Crea un nodo simple que almacena un dato de tipo T.
	 * @param next Referencia al siguiente nodo simple de la lista.
	 * @param data El dato de tipo T que almacena el nodo.
	 */
}
