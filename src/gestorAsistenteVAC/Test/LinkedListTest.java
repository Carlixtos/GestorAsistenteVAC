package gestorAsistenteVAC.Test;

import gestorAsistenteVAC.util.LinkedList;
import gestorAsistenteVAC.util.Node;

/**
 * Clase que contiene los metodos estaticos para realizar pruebas sobre la clase LinkedList.
 * @author Dafty-Punky-Boy
 *
 * @version 1.0, 19/04/2021
 */
public class LinkedListTest {
	
	/**
	 * Prueba el metodo nodeDrop.
	 */
	public static void nodeDropTest() {
		LinkedList<Integer> testList1 = new LinkedList<Integer>();
		
		for(int i = 1; i < 4;  ++i) {
			testList1.addFront(i);
		}
		
		System.out.println("INICIO LinkedList.nodeDrop() Test\n");
		
		System.out.print("Lista inicial: ");
		printList(testList1);
		System.out.println("Tamaño: " + testList1.getLength() + "\n");
		
		testList1.nodeDrop(2);
		
		System.out.print("Lista final: ");
		printList(testList1);
		System.out.println("Tamaño: " + testList1.getLength() + "\n");
		
		System.out.println("FIN LinkedList.nodeDrop() Test\n");
	}
	
	
	public static void nodeConsultTest() {
		LinkedList<Integer> testList1 = new LinkedList<Integer>();
		int n1;
		int pos = 2;
		
		for(int i = 1; i < 4;  ++i) {
			testList1.addFront(i);
		}
		
		System.out.println("INICIO LinkedList.nodeConsult() Test\n");
		
		System.out.print("Lista inicial: ");
		printList(testList1);
		System.out.println("Tamaño: " + testList1.getLength() + "\n");
		
		n1 = testList1.nodeConsult(pos);
		
		System.out.println("El numero en la posición " + pos + " es: " + n1 + "\n");
		
		System.out.println("FIN LinkedList.nodeConsult() Test\n");
	}
	
	/**
	 * Imprime la lista enlazada. Configurada inicialmente para datos enteros.
	 * @param testList Lista enlazada que se quiere imprimir
	 */
	public static void printList(LinkedList<Integer> testList) {
		Node<Integer> nodeTemp = testList.getHead();
		
		if(nodeTemp == null) {
			System.out.println("Lista vacia\n");
		}
		
		else {
			while(nodeTemp != null) {
				System.out.print(nodeTemp.getKey() + " ");
				
				nodeTemp = nodeTemp.getNext();
			}
			
			System.out.println("\n");
		}
	}
}
