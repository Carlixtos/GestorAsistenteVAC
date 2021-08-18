package util;

public class BST<T> {
	
	protected NodeA<T> root;
	
	BST(){	
		root=null;
	}

    BST(int key, T value){
        root=new NodeA<T>(value,key);
    }

	public NodeA<T> getRoot(){
		return this.root;
	}
	
	public NodeA<T> find(int key){
		return findAux(key,this.root);
	}
	
	protected NodeA<T> findAux(int key,NodeA<T> root){
		if(root==null){return null;}

		if(key<root.getKey()){
			return findAux(key,root.getLeft());
		}
		else if(key>root.getKey()){
			return findAux(key,root.getRight());
		}
		else{
			return root;
		}
	}
	
	//Encuentra el nodo con la menor llave en el arbol
	public NodeA<T> findMin(){
		return findMinAux(this.root);
	}

	//Elimina el nodo con la menor llave en el arbol con raiz root
	protected NodeA<T> deleteMinAux(NodeA<T> root){
		if(root==null){return null;}
		else if(root.getLeft()==null){
            if(root.getRight()!=null)root.getRight().setParent(root.getParent());
            return root.getRight();
        }

		root.setLeft(deleteMinAux(root.getLeft()));

		return root;
	}
	
	//Encuentra el nodo con la menor llave en el arbol con raiz root
	protected NodeA<T> findMinAux(NodeA<T> root){
		if(root==null){return null;}
		if(root.getLeft()==null){return root;}

		return(findMinAux(root.getLeft()));
	}
	
	//inserta un nuevo nodo al arbol
	public void insert(int key,T value){
		NodeA<T> node=new NodeA<T>(value,key);
		this.root=insertAux(this.root,node);
	}
	
	//Retorna el arbol/subarbol modificado con la inserción de un nuevo nodo
	protected NodeA<T> insertAux(NodeA<T> root,NodeA<T> node){
		if(root==null){return node;}

		if(node.getKey()<root.getKey()){
			if(root.getLeft()==null){
				node.setParent(root);
			}
			root.setLeft(insertAux(root.getLeft(),node));
		}
		else{
			if(root.getRight()==null){
				node.setParent(root);
			}
			root.setRight(insertAux(root.getRight(),node));
		}

		return root;
	}

	//Elimina un nodo de llave key del arbol
	public void delete(int key){
		this.root=deleteAux(key,this.root);
	}

	//Retorna el arbol/subarbol modificado con el nodo de llave key eliminado
	protected NodeA<T> deleteAux(int key,NodeA<T> root){
		if(root==null){return null;}

		if(key<root.getKey()){
			root.setLeft(deleteAux(key,root.getLeft()));
		}
		else if(key>root.getKey()){
			root.setRight(deleteAux(key,root.getRight()));
		}
		else{
			if(root.getLeft()==null){
                if(root.getRight()!=null)root.getRight().setParent(root.getParent());
				return root.getRight();
			}
			else if(root.getRight()==null){
				if(root.getLeft()!=null)root.getLeft().setParent(root.getParent());
				return root.getLeft();
			}
			else{
				NodeA<T> tmp=findMinAux(root.getRight());

				root.setValue(tmp.getValue());
				root.setKey(tmp.getKey());

				root.setRight(deleteMinAux(root.getRight()));
			}
		}

		return root;	
	}

	//Imprime las llaves in order
	public void inOrderPrint(){
		inOrderPrintAux(this.root);
	}

	protected void inOrderPrintAux(NodeA<T> root){
		if(root==null){return;}

		inOrderPrintAux(root.getLeft());
		System.out.print(root.getKey()+" ");
		inOrderPrintAux(root.getRight());
	}
	// Print the tree
    public void printTree(NodeA<T> currPtr, String indent, boolean last) {
      if (currPtr != null) {
        System.out.print(indent);
        if (last) {
          System.out.print("R----");
          indent += "   ";
        } else {
          System.out.print("L----");
          indent += "|  ";
        }
        System.out.println(currPtr.getKey());
        printTree(currPtr.getLeft(), indent, false);
        printTree(currPtr.getRight(), indent, true);
      }
    }
    public int aproxLength(NodeA<T> root) {
    	int cont=1;
    	if(root.getLeft()!=null){
    		cont +=aproxLength(root.getLeft());
    		}
    	if(root.getRight()!=null){
    		cont +=aproxLength(root.getRight());
    		}
    	return cont;
	}
	
	

}
