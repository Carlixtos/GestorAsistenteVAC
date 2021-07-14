package gestorAsistenteVAC.util;

public class AVL<T> extends BST<T>{
    
    public AVL(){
        super();
    }

    AVL(int key,T value){
        super(key,value);
    }

    //Calcula la altura del arbol
    public int height(){
        return heightAux(this.root);
    }
    
    //Calcula la altura de un nodo
    protected int heightAux(NodeA<T> node){
        if(node==null)return -1;
        else{return Math.max(heightAux(node.getLeft()),heightAux(node.getRight()))+1;}
    }

    protected void leftRotate(NodeA<T> node){
        NodeA<T> nodeRight=node.getRight();
        nodeRight.setParent(node.getParent());

        if(node.getParent()==null)this.root=nodeRight;
        else{
            if(node.getParent().getRight()==node){
                node.getParent().setRight(nodeRight);
            }
            else{node.getParent().setLeft(nodeRight);}
        }

        node.setRight(nodeRight.getLeft());
        if(node.getRight()!=null)node.getRight().setParent(node);

        nodeRight.setLeft(node);
        node.setParent(nodeRight);  
    }

    protected void rightRotate(NodeA<T> node){
        NodeA<T> nodeLeft=node.getLeft();
        nodeLeft.setParent(node.getParent());

        if(node.getParent()==null)this.root=nodeLeft;
        else{
            if(node.getParent().getRight()==node){
                node.getParent().setRight(nodeLeft);
            }
            else{node.getParent().setLeft(nodeLeft);}
        }

        node.setLeft(nodeLeft.getRight());
        if(node.getLeft()!=null)node.getLeft().setParent(node);

        nodeLeft.setRight(node);
        node.setParent(nodeLeft);
    }

    protected NodeA<T> rebalance(NodeA<T> node){
        int hLeft=heightAux(node.getLeft());
        int hRight=heightAux(node.getRight());

        if(hLeft>=2+hRight){
            if(heightAux(node.getLeft().getLeft())>=heightAux(node.getLeft().getRight())){
                rightRotate(node);
            }
            else{
                leftRotate(node.getLeft());
                rightRotate(node);
            }
            return node.getParent();
        }
        else if(hRight>=2+hLeft){
            if(heightAux(node.getRight().getRight())>=heightAux(node.getRight().getLeft())){
                leftRotate(node);
            }
            else{
                rightRotate(node.getRight());
                leftRotate(node);
            }
            return node.getParent();
        }

        return node;
    }


    //Metodos insertAux y deleAux modificados con el rebalanceo 
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

        root=rebalance(root);
        return root;
	}
      
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

        root=rebalance(root);
		return root;	
    }
}