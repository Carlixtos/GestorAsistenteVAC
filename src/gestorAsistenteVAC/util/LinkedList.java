package gestorAsistenteVAC.util;

/**
 * Clase generica lista enlazada, una implementaci�n de una lista doblemente enlazada. 
 * @author Dafty-Punky-Boy
 * @version 1.0, 17/04/2021
 * 
 * @param tail Referencia al primer nodo de la lista.
 * @param head Referencia al ultimo nodo de la lista. 
 */
public class LinkedList<T> {
	Node<T> head;
	Node<T> tail;
	
	/**
	 * Crea una lista vac�a.
	 */
	public LinkedList(){
		head = null;
		tail = null;
	}
	
	/**
	 * Setter de head.
	 * @param head Nodo que se quiere asignar a la cabeza de la lista.
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}
	
	/**
	 * Setter de tail.
	 * @param tail Nodo que se quiere asignar a la cola de la lista.
	 */
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	
	/**
	 * Getter de head.
	 * @return El nodo correspondiente a la cabeza de la lista.
	 */
	public Node<T> getHead() {
		return head;
	}
	
	/**
	 * Getter de tail.
	 * @return El nodo correspondiente a la cola de la lista.
	 */
	public Node<T> getTail(){
		return tail;
	}
	
	/**
	 * Indica si la lista est� vacia.
	 * @return true si la lista est� vacia y false si no.
	 */
	public boolean isEmpty() {
		if(tail == null) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Agrega un nodo almacenando un dato de tipo T al frente de la lista.
	 * @param data El dato de tipo T a agregar.  
	 */
	public void addFront(T data) {
		Node<T> node = new Node<T>(data);
		
		if(isEmpty()) {
			head = node;
			tail = head;
		}
		
		else {
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
	}
	
	/**
	 * Agrega un nodo almacenando un dato de tipo T al final de la lista.
	 * @param data El dato de tipo T a agregar.
	 */
	public void addBack(T data) {
		Node<T> node = new Node<T>(data);
		
		if(isEmpty()) {
			head = node;
			tail = head;
		}
		
		else {
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		}
	}
	
	/**
	 * Busca un dato de tipo T en la lista.
	 * @param data El dato que se desea buscar.
	 * @return Una referencia al nodo que lo contiene o null si no existe.
	 */
	public Node<T> search(T data) {
		if(isEmpty()){
			return null;
		}
		
		if(head == tail && head.getData() == data) {
			return head;
		}
		
		Node<T> nodeTemp1 = head;
		Node<T> nodeTemp2 = tail;
		
		while(nodeTemp1 != tail && nodeTemp2 != head) {
			if(nodeTemp1.getData() == data) {
				return nodeTemp1;
			}
			
			if(nodeTemp2.getData() == data) {
				return nodeTemp2;
			}
			
			nodeTemp1 = nodeTemp1.getNext();
			nodeTemp2 = nodeTemp2.getPrev();
		}
		
		return null;
	}
	
	
	/**
	 * Remplaza un dato tipo T en la lista si este existe.
	 * @param prevData El dato que se pretende remplazar.  
	 * @param newData El nuevo dato.
	 */
	public void dataReplace(T prevData, T newData) {
		if(isEmpty()) {
			;
		}
		
		else {
			Node<T> nodeTemp = search(prevData);
			
			if(nodeTemp != null) {
				nodeTemp.setData(newData);
			}
		}
	}
	
	/**
	 * Elimina el node que contiene un dato tipo T de la lista.
	 * @param data El dato que se pretende eliminar de la lista.
	 */
	public void nodeDrop(T data) {
		if(isEmpty()) {
			;
		}
		
		else {
			Node<T> nodeTemp = search(data);
		
			if(nodeTemp != null) {
				nodeTemp.getNext().setPrev(nodeTemp.getPrev());
				nodeTemp.getPrev().setNext(nodeTemp.getNext());
			}
		}
	}
	
}
