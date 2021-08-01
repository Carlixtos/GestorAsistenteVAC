package gestorAsistenteVAC;

import gestorAsistenteVAC.util.*;
import gestorAsistenteVAC.interfaz.*;
import gestorAsistenteVAC.Test.*;
import gestorAsistenteVAC.data.*;



public class Main {

	public static void main(String[] args) { // Codigo de prueba
		/*InterfazG gestorIntf = new InterfazG();
		Data datos= new Data();
		long tiempoinicio,tiempofinal;
		asistenteInterfaz grafica=new asistenteInterfaz();
		grafica.init(datos);
		grafica.run();*/
		
		MapIntU<HashClassTest> map=new MapIntU<HashClassTest>(2);
		HashClassTest tmp= new HashClassTest(1006797081,"Carlos Rios");
		HashClassTest tmp1=new HashClassTest(1006797082,"Hector Fernandez");
		int hash=map.hashCodeU(1006797081);
		map.set(tmp1.getIntKey(),tmp1);
		map.set(tmp.getIntKey(),tmp);
		System.out.println((float)map.keysNum/map.table.length);
		
		
	}
}
