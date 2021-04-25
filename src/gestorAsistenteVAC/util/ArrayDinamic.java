package gestorAsistenteVAC.util;


/**
 * 
 * Clase Generica Arreglo dinamico
 * @author Edgar Obregon
 * @version 1.0, 18/04/2021
 */
public class ArrayDinamic<T>{
	
	private T[] Array;
	private int disponible;
	
	/**
	 * 
	 * Creacion de una array vacio.
	 */
	public ArrayDinamic(){
		this.Array=(T[]) new Object[1];
		this.disponible=0;
	}
	
	/**
	 * 
	 * Devuelve la cantidad de elementos en el arreglo dinamico.
	 * @return Entero que representa la cantidad de elementos en el arreglo dinamico.
	 */
	public int size() {
		return this.disponible ;
	}
	/**
	 * suma uno a la cantidad de elemntos del arreglo
	 * 
	 */
	private void addsize() {
		this.disponible++;	
	}/**
	 * quita uno a la cantidad de elemntos del arreglo
	 * 
	 */
	private void lesssize() {
		this.disponible--;	
		
	}
	/**
	 * Retorna la capacidad del arreglo
	 * @return La capacidad del arreglo
	 */
	public int capacity() {
		return this.Array.length;	
	}
	
	/**
	 * 
	 * Retorna el elemento en la posicion i 
	 * @param i
	 * @return elemento en la posicion i
	 * @throws No se puede retirar un elemento fuera de indice
	 *  
	 */
	
	public T get(int i) {
		if(i<0|| i>this.size()) {
			throw new RuntimeException(" Fuera de indice ");
		}
		return this.Array[i];
		
	}
	/**
	 * 
	 * cambia el elemento en la posicion i 
	 * @param i
	 * @throws No se puede cambiar un elemento fuera de indice
	 *  
	 */
	
	public void set(int i,T val) {
		if(i<0|| i>this.size()) {
			throw new RuntimeException(" Fuera de indice ");
		}
		this.Array[i]=val;
		
	}
	/**
	 * 
	 * Agrega un elemento al arreglo dinamico.
	 * @param dato
	 */
	public void pushback(T key) {
		if(this.capacity()==this.size()) {
			T[]	nArray=(T[]) new Object[this.capacity()*2];
			for (int i =0;i<this.size()-1;i++) {
				nArray[i]=this.Array[i];
			}
			this.Array=nArray;
		}
		this.Array[this.size()]=key;
		this.addsize();
	}
	
	/**
	 * 
	 * Retira un dato en la posicion i.
	 * 
	 * @return Un dato en la posicion i.
	 * @throws No se puede cambiar un dato de fuera de rango
	 *  
	 */
	public T remove(int i) {
		if(i<0|| i>this.size()) {
			throw new RuntimeException(" Fuera de indice ");
		}
		T t = this.Array[i];
		for(int j =i;j<this.size()-2;j++) {
			this.Array[j]=this.Array[j+1];
		}
		this.lesssize();
		return t;
	}
	


	/**
	 * Revisa si el arreglo esta vacio 
	 * @return boolean; si esta vacio retorna true; si tiene uno o mas elementos retorna false
	 */
	public boolean isEmpty() {
		
			return this.Array.length==0;
	}
	

}

