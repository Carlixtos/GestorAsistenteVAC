package util;

/**
 * Clase generica que implementa una tabla hash que permite el mapeo entre una llave entera y cualquier objeto
 * si y solo si el objeto implementa la interfaz KeysU y retorna con el metodo de la interfaz la misma llave entera
 * con la que se realiza el mapeo. Pensada para almacenar los pacientes donde la llave es el numero de identificación.
 * @author Dafty-Punky-boy
 *
 * @param <V> Cualquier objeto (o tipo) con el que se desee hacer el mapeo. Debe implementar si o si la interfaz KeysU.
 */
public class MapIntU<V extends KeysU> {
	private Object[] table;
	private int keysNum;
	
	public MapIntU(int tSize){
		this.table=new Object[tSize];
		this.keysNum=0;
	}
	
	public int GetKeysNum(){
		return keysNum;
	}
	
	public int GetTableSize() {
		return table.length;
	}
	
	private int hashCodeU(int key) {
		return ((344*30082349+66)%10000019)%table.length; 
	}
	
	private void rehash() {
		Object oldTable[]=this.table;
		LinkedListU<V> tmpL;
		NodeU<V> tmpN;
		int oldLength=this.table.length;
		
		this.table=new Object[oldLength*2];
		
		for(int i=0;i<oldLength;++i) {
			tmpL=(LinkedListU<V>)oldTable[i];
			if(tmpL==null)continue;
			tmpN=tmpL.getHead();
			
			while(tmpN!=null) {
				set(tmpN.getKey().getIntKey(),tmpN.getKey());
				--this.keysNum;
				tmpN=tmpN.getNext();
			}
			
		}
		
	}
	
	public V get(int key) {
		@SuppressWarnings("unchecked")
		final LinkedListU<V> list=(LinkedListU<V>) table[hashCodeU(key)];
		NodeU<V> head=list.getHead();
		while(head!=null) {
			if(head.getKey().getIntKey()==key) {
				return head.getKey();
			}
			head=head.getNext();
		}
		
		return null;
	}
	
	public void set(int key,V value) {
		@SuppressWarnings("unchecked")
		LinkedListU<V> list=(LinkedListU<V>) table[hashCodeU(key)];
		if(list==null) {
			table[hashCodeU(key)]=new LinkedListU<V>();
			list=(LinkedListU<V>) table[hashCodeU(key)];
			list.addFront(value);
			++this.keysNum;
			return;
		}
		NodeU<V> head=list.getHead();
		while(head!=null) {
			if(head.getKey().getIntKey()==key) {
				head.setKey(value);
				return;
			}
			head=head.getNext();
		}
		list.addFront(value);
		++this.keysNum;
		
		if((float)keysNum/table.length>0.9) {
			rehash();
		}
	}
	
	public void delete(int key) {
		@SuppressWarnings("unchecked")
		final LinkedListU<V> list=(LinkedListU<V>) table[hashCodeU(key)];
		if(list==null)return;
		NodeU<V> head=list.getHead();
		while(head!=null) {
			if(head.getKey().getIntKey()==key) {
				list.nodeDrop(head.getKey());
				--this.keysNum;
				return;
			}
			head=head.getNext();
		}
	}
	
	public boolean exists(int key) {
		@SuppressWarnings("unchecked")
		final LinkedListU<V> list=(LinkedListU<V>) table[hashCodeU(key)];
		if(list==null)return false;
		NodeU<V> head=list.getHead();
		while(head!=null) {
			if(head.getKey().getIntKey()==key) {
				return true;
			}
			head=head.getNext();
		}
		
		return false;
	}
	
}
