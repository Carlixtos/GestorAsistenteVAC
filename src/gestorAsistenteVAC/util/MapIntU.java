package gestorAsistenteVAC.util;

public class MapIntU<V extends KeysU> {
	public Object[] table;
	public int keysNum;
	
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
	
	public int hashCodeU(int key) {
		return ((66666*key+1026798)%10000019)%table.length; 
	}
	
	private void rehash() {
		Object oldTable[]=this.table;
		LinkedListU<V> tmpL;
		NodeU<V> tmpN;
		int oldLength=this.table.length;
		
		this.table=new Object[oldLength*2];
		
		for(int i=0;i<oldLength;++i) {
			tmpL=(LinkedListU<V>)oldTable[i];
			tmpN=tmpL.getHead();
			
			while(tmpN!=null) {
				set(tmpN.getKey().getIntKey(),tmpN.getKey());
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
		}
		
		return false;
	}
	
}
