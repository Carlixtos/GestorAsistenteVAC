package gestorAsistenteVAC;

import gestorAsistenteVAC.util.*; 

public class Main {

	public static void main(String[] args) { // Codigo de prueba
		LinkedList<Integer> intList = new LinkedList<Integer>();
		LinkedList<Integer> intList2 = new LinkedList<Integer>();
		Node<Integer> nodeTemp;
		
		for(int i = 0; i < 5; i += 2) {
			intList.addFront(i);
			intList.addBack(i + 1);
			
			nodeTemp = intList.getHead();
			
			while(nodeTemp != intList.getTail()) {
				System.out.print(nodeTemp.getData() + " ");
				
				nodeTemp = nodeTemp.getNext();
			}
			
			System.out.println(nodeTemp.getData());
		}
		
		nodeTemp = intList.search(5);
		
		System.out.println("\nData: " + nodeTemp.getData());
		System.out.println("Previous: " + nodeTemp.getPrev().getData());
		System.out.println("Next: " + nodeTemp.getNext().getData());
		
		
	}

}
