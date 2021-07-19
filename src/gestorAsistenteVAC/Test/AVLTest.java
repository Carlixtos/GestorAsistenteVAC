package gestorAsistenteVAC.Test;

import java.lang.System;
import gestorAsistenteVAC.util.AVL;

public class AVLTest {
	
	public static void velTest() {
		generadorDatos gen=new generadorDatos();
		AVL<String> tmp=new AVL<String>();
		
		
		long t1;
		long t2;
		
		t1=System.currentTimeMillis();
		
		
		tmp.insert(7, null);
		tmp.insert(6, null);
		tmp.insert(5, null);

		tmp.insert(1, null);
		tmp.insert(2, null);
		
		tmp.insert(3, null);
		tmp.insert(4, null);
		
		System.out.println(tmp.getRoot().getKey());
		System.out.println(tmp.getRoot().getLeft().getKey());
		System.out.println(tmp.getRoot().getLeft().getRight().getKey());
		
		t2=System.currentTimeMillis();
		
		System.out.println(Long.toString(t2-t1));
		tmp.inOrderPrint();
		System.out.println("\n"+tmp.getRoot().getHeight());
		
	} 

}
