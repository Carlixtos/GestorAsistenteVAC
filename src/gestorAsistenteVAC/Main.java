package gestorAsistenteVAC;

import gestorAsistenteVAC.util.*;
import gestorAsistenteVAC.interfaz.*;
import gestorAsistenteVAC.Test.LinkedListTest;
import gestorAsistenteVAC.Test.StackTest;

public class Main {

	public static void main(String[] args) { // Codigo de prueba
		InterfazG gestorIntf = new InterfazG();
		
		while(!gestorIntf.noScreens()) {
			switch(gestorIntf.getScreen()) {
				case 0:{
					gestorIntf.accesScreen();
					break;
				}
			}
		}
		
		
		
		
		//LinkedListTest.nodeDropTest();
		//LinkedListTest.nodeConsultTest();
		//StackTest.generalTest();
		
		/*LinkedList<Integer> intList = new LinkedList<Integer>();
		LinkedList<Integer> intList2 = new LinkedList<Integer>();
		Node<Integer> nodeTemp;
		Node<Integer> nodeTemp2;
		
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
		
		
		intList.dataReplace(4, 36);
		intList.dataReplace(0, -1);
		intList.dataReplace(5, 81);
		
		nodeTemp = intList.getHead();
		
		while(nodeTemp != intList.getTail()) {
			System.out.print(nodeTemp.getData() + " ");
			
			nodeTemp = nodeTemp.getNext();
		}
		
		System.out.println(nodeTemp.getData());
		
		//nodeTemp = intList.search(0);
		
		System.out.println("\nData: " + nodeTemp.getData());
		System.out.println("Previous: " + nodeTemp.getPrev().getData());
		System.out.println("Next: " + nodeTemp.getNext().getData());
		
		nodeTemp.setData(-1);
		
		nodeTemp = intList.getHead();
		
		while(nodeTemp != intList.getTail()) {
			System.out.print(nodeTemp.getData() + " ");
			
			nodeTemp = nodeTemp.getNext();
		}
		
		System.out.println(nodeTemp.getData());*/
		
		
	}

}
