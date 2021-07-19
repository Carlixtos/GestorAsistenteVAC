package gestorAsistenteVAC.Test;

import java.lang.System;
import gestorAsistenteVAC.util.AVL;

public class AVLTest {
	
	public static void velTest() {
		generadorDatos gen=new generadorDatos();
		AVL<String> tmp=new AVL<String>(13,"A");
		
		
		long t1;
		long t2;
		
		t1=System.currentTimeMillis();
		
		for(int i=0;i<10000;++i) {
			tmp.insert(gen.numeroAleatorioEnRango(0,20000), "GON");
		}
		
		t2=System.currentTimeMillis();
		
		System.out.println(Long.toString(t2-t1));
		
	} 

}
