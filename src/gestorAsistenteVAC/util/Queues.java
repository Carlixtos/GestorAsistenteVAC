package gestorAsistenteVAC.util;

/**
 * 
 * Clase generica Cola. 
 * @author Edgar Obregon
 * @version 1.0, 18/04/2021
 * 
 */
public class Queues<T> extends LinkedList <T>  {
	
	/**
	 * 
	 * Creacion de una cola vacia.
	 */
	public Queues(){
		
		super();
	}
	
	/**
	 * 
	 * Devuelve la cantidad de nodos en la cola.
	 * @return Entero que representa la cantidad de nodos en la cola.
	 */
	public int getlength() {
		return length;
	}
	
	/**
	 * 
	 * Agrega un objeto Node a la cola.
	 * @param node
	 */
	public void enqueue(T key) {
		
	super.addFront(key);
		
	}
	
	
	/**
	 * 
	 * Retira el primer dato de la cola.
	 * 
	 * @return Un objeto dato del principio de la cola.
	 * @throws No se puede retirar un dato de una cola vacia
	 *  
	 */
	public T dequeue() {
		if (tail==null) {
			throw new RuntimeException(" La cola esta vacia. ");
		}
		else {
			Node<T> temp = tail;
			tail=temp.getPrev();
			temp.setPrev(null);
			if(tail==null) {
				head=null;
			}
			else {
			tail.setNext(null);
			}
			length--;

			return temp.getKey() ;
			
		}
		
	}
	

	/**
	 * Revisa si la cola esta vacia 
	 * @return boolean; si esta vacia retorna true; si tiene uno o mas elementos retorna false
	 */
	public boolean isEmpty() {
		
			return head==null;		
	}
	

}