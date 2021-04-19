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
	*@param tail Referencia al primer nodo de la lista.
	*@param head Referencia al ultimo nodo de la lista.
	*/
	private Node<T> head;
	private Node<T> tail;
	
	/**
	 * 
	 * Creacion de una cola vacia.
	 */
	Queues(){
		
		head = null;
		tail = null;
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
			head.prev=node;
			node.next=head;
			head=node;
			
		}
		
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
			tail=temp.prev;
			temp.prev=null;
			if(tail==null) {
				head=null;
			}
			else {
			tail.next=null;
			}
			return temp;
			
		}
		
	}
	
	
	/**
	 * Revisa si la cola esta vacia 
	 * @return boolean; si esta vacia retorna true; si tiene uno o mas elementos retorna false
	 */
	public boolean empaty() {
		
			return head==null;		
	}
	

}