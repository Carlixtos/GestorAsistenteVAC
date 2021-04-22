package gestorAsistenteVAC.util;

/**
 * Clase generica Pila.
 * @author Dafty-Punky-Boy
 * @version 1.0, 22/04/21
 * 
 */
public class Stack<T>{
	private Node<T> head;
	private Node<T> tail;
	private int length;
	
	public Stack(){
		head = null;
		tail = null;
		length = 0;
	}
	
	public int getLength(){
		return length;
	}
	
	public void push(T key) {
		if(isEmpty()) {
			////
		}
	}
	
	public boolean isEmpty() {
		return tail == null;
	}
	
}
