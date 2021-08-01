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
		HashClassTest tmp1=new HashClassTest(1326142135,"Hector Fernandez");
		HashClassTest tmp3=new HashClassTest(1326122235,"Paula Perez");
		int hash=map.hashCodeU(1326122235);
		System.out.println(hash);
		map.set(tmp1.getIntKey(),tmp1);
		map.set(tmp.getIntKey(),tmp);
		System.out.println((float)map.keysNum/map.table.length);
		System.out.println(map.table.length);
		map.delete(1006797081);
		map.delete(1326142135);
		System.out.println(map.exists(1006797081));
		System.out.println(map.exists(1326142135));
		System.out.println(map.keysNum);
		//map.set(tmp3.getIntKey(),tmp3);
		System.out.println(map.hashCodeU(1326122235));
		
		
		
	}
}
