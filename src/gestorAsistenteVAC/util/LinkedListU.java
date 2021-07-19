package gestorAsistenteVAC.util;

/**
 * Clase generica lista enlazada, una implementación de una lista doblemente enlazada. 
 * @author Dafty-Punky-Boy
 * @version 1.1, 19/04/2021
 * 
 * @param tail Referencia al primer nodo de la lista.
 * @param head Referencia al ultimo nodo de la lista.
 * @param length El tamaño de la lista (cantidad de nodos que posee).
 */
public class LinkedListU<T> {
	protected NodeU<T> head;
	protected NodeU<T> tail;
	protected int length;
	
	/**
	 * Crea una lista vacía.
	 */
	public LinkedListU(){
		head = null;
		tail = null;
		length = 0;
	}
	
	/**
	 * Setter de head.
	 * @param head Nodo que se quiere asignar a la cabeza de la lista.
	 */
	public void setHead(NodeU<T> head) {
		this.head = head;
	}
	
	/**
	 * Setter de tail.
	 * @param tail Nodo que se quiere asignar a la cola de la lista.
	 */
	public void setTail(NodeU<T> tail) {
		this.tail = tail;
	}
	
	/**
	 * Getter de head.
	 * @return El nodo correspondiente a la cabeza de la lista.
	 */
	public NodeU<T> getHead() {
		return head;
	}
	
	/**
	 * Getter de tail.
	 * @return El nodo correspondiente a la cola de la lista.
	 */
	public NodeU<T> getTail(){
		return tail;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Indica si la lista está vacia.
	 * @return true si la lista está vacia y false si no.
	 */
	public boolean isEmpty() {
		return tail == null;
	}
	
	/**
	 * Agrega un nodo almacenando un dato de tipo T al frente de la lista.
	 * @param key El dato de tipo T a agregar.  
	 */
	public void addFront(T key) {
		NodeU<T> node = new NodeU<T>(key);
		NodeU<T> nodetp;
		
		if(isEmpty()) {
			head = node;
			tail = head;
		}
		else {
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
		
		++length;
	}
	
	/**
	 * Agrega un nodo almacenando un dato de tipo T al final de la lista.
	 * @param key El dato de tipo T a agregar.
	 */
	public void addBack(T key) {
		NodeU<T> node = new NodeU<T>(key);
		
		if(isEmpty()) {
			head = node;
			tail = head;
		}
		
		else {
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		}
		
		++length;
	}
	
	/**
	 * Busca un dato de tipo T en la lista.
	 * @param key El dato que se desea buscar.
	 * @return Una referencia al nodo que lo contiene o null si no existe. Si es un dato repetido retornará el nodo con la menor distancia a uno de los extremos.
	 */
	public NodeU<T> search(T key) {
		if(isEmpty()){
			return null;
		}
		
		if(head.getNext() == null && head.getKey() == key) {
			return head;
		}
		
		NodeU<T> nodeTemp1 = head;
		NodeU<T> nodeTemp2 = tail;
		
		while(nodeTemp1 != tail && nodeTemp2 != head) {
			if(nodeTemp1.getKey() == key) {
				return nodeTemp1;
			}
			
			if(nodeTemp2.getKey() == key) {
				return nodeTemp2;
			}
			
			nodeTemp1 = nodeTemp1.getNext();
			nodeTemp2 = nodeTemp2.getPrev();
		}
		
		return null;
	}
	
	
	/**
	 * Remplaza un dato tipo T en la lista si este existe. En el caso de un dato repetido, remplazará el nodo más cercano a uno de los extremos de la lista.
	 * @param prevkey El dato que se pretende remplazar.  
	 * @param newkey El nuevo dato.
	 */
	public void keyReplace(T prevkey, T newkey) {
		if(isEmpty()) {
			;
		}
		
		else {
			NodeU<T> nodeTemp = search(prevkey);
			
			if(nodeTemp != null) {
				nodeTemp.setKey(newkey);
			}
		}
	}
	
	/**
	 * Elimina el nodo que contiene un dato tipo T de la lista. En el caso de un dato repetido, eliminará el node más cercano a uno de los extremos de la lista.
	 * @param key El dato que se pretende eliminar de la lista.
	 */
	public void nodeDrop(T key) {
		if(isEmpty()) {
			;
		}
		
		else {
			NodeU<T> nodeTemp = search(key);
		
			if(nodeTemp != null) {
				if(nodeTemp == head) {
					head = nodeTemp.getNext();
					if (nodeTemp.getNext()!=null) {
						nodeTemp.getNext().setPrev(null);
					}
					else {
						head = nodeTemp.getNext();
					}
				}
				
				else if(nodeTemp == tail) {
					tail = nodeTemp.getPrev();
					nodeTemp.getPrev().setNext(null);
				}
				
				else {
					nodeTemp.getNext().setPrev(nodeTemp.getPrev());
					nodeTemp.getPrev().setNext(nodeTemp.getNext());
				}
				
				--length;
			}
		}
	}
	
	/**
	 * Consulta el dato de tipo T del nodo en una posición determinada.
	 * @param pos La posición del nodo, comenzando desde la posición 0.
	 * @return El dato de tipo T que almacena el nodo que corresponda a esa posición en la lista. Si la posición dada no corresponde al numero de nodos en la lista.
	 */
	public T nodeConsult(int pos) {
		if(pos + 1 > length) {
			return null;
		}
		
		NodeU<T> nodeTemp = head;
		if(pos==0) {
			return nodeTemp.getKey();
		}
		
		for(int i = 0; i < pos; ++i) {
			nodeTemp = nodeTemp.getNext();
		}
		
		return nodeTemp.getKey();
	}
	
	
}
