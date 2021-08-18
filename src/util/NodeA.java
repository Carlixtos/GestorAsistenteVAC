package util;

public class NodeA<T> {
	private T value;
    private int key;
    private int height;
	private NodeA<T> right;
	private NodeA<T> left;
	private NodeA<T> parent;
	
	/**
	 * Crea un nodo que almacena un dato de tipo T.
	 * @param key El dato de tipo T.
	 */
	NodeA (T value,int key) {
		this.value=value;
        this.key=key;
		right=null;
		left=null;
		parent=null;
		height=0;
	}
	
	/**
	 * Setter de key.
	 * @param key El dato de tipo T que se quiere establecer.
	 */
	public void setKey(int key) {
		this.key = key;
	}
	
	public void setHeight(int height) {
		this.height=height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setRight(NodeA<T> right) {
		this.right = right;
	}
	
	public void setLeft(NodeA<T> left) {
		this.left = left;
	}
	
    public void setValue(T value){
        this.value = value;
    }

	public NodeA<T> getParent() {
		return parent;
	}

	public void setParent(NodeA<T> parent) {
		this.parent = parent;
	}
	
	public int getKey() {
		return key;
	}

    public T getValue(){
        return value;
    }
	
	public NodeA<T> getRight(){
		return right;
	}
	
	public NodeA<T> getLeft(){
		return left;
	}

	
	
	
	
}
