package gestorAsistenteVAC.util;

/**
 * Clase generica Pila. Deinida como una Subclase de LinkedList.
 * @author Dafty-Punky-Boy
 * @version 1.0, 22/04/21
 * 
 */
public class Stack<T> extends LinkedList<T>{
	
	/**
	 * Crea una pila vacía.
	 */
	public Stack(){
		super();
	}
	
	/**
	 * Agrega un nodo almacenando un dato de tipo T en la pila.
	 * @param key EL dato de tipo T que se quiere almacenar.
	 */
	public void push(T key) {
		addBack(key);
	}
	
	/**
	 * Extrae el dato de tipo T del utlimo nodo de la pila.
	 * @return El ultimo dato de tipo T añadido.
	 */
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		
		T key = tail.getKey();
		tail = tail.getPrev();
		tail.setNext(null);
		
		return key;		
	}
	
	/**
	 * Consulta el dato de tipo T del utlimo nodo de la pila. 
	 * @return El ultimo dato de tipo T añadido.
	 */
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		
		return tail.getKey();
	}	
	
	
}
