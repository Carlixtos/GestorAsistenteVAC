package gestorAsistenteVAC.util;

/**
 * 
 * Clase generica Cola. 
 * @author Edgar Obregon
 * @version 1.0, 18/04/2021
 * 
 */
public class Queues <T>  {
	
	/**
	*@param tail Referencia al primer nodo de la cola.
	*@param head Referencia al ultimo nodo de la cola.
	*@param length Referencia al numero de nodos en la cola.
	*/
	private Node<T> head;
	private Node<T> tail;
	private int length;
	
	
	/**
	 * 
	 * Creacion de una cola vacia.
	 */
	public Queues(){
		
		head = null;
		tail = null;
		length=0;
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
	public void enqueue(Node <T> node) {
		
		if( head ==null) {
			
			head=node;
			tail=node;
		}
		
		else {
			head.setPrev(node);
			node.setNext(head);
			head=node;
			
		}
		length++;
		
	}
	
	
	/**
	 * 
	 * Retira el primer nodo de la cola.
	 * 
	 * @return Un objeto Node del principio de la cola.
	 * @throws No se puede retirar un nodo de una cola vacia
	 *  
	 */
	public Node <T> dequeue() {
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
			return temp;
			
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