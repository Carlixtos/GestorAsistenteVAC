package gestorAsistenteVAC;

import gestorAsistenteVAC.util.*; 

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> intList = new LinkedList<Integer>();
		
		for(int i = 0; i < 10; ++i) {
			intList.addFront(i);
		}
		
		Node<Integer> nodeTemp = intList.head;
		
		while(nodeTemp != intList.tail) {
			System.out.print(nodeTemp.data + " ");
			
			nodeTemp = nodeTemp.next;
		}
		System.out.println(nodeTemp.data);
			
	}

}
