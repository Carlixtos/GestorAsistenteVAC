package gestorAsistenteVAC;

import gestorAsistenteVAC.util.*;
import gestorAsistenteVAC.interfaz.*;
import gestorAsistenteVAC.Test.*;
import gestorAsistenteVAC.data.*;



public class Main {

	public static void main(String[] args) { // Codigo de prueba
		InterfazG gestorIntf = new InterfazG();
		Data datos= new Data();
		long tiempoinicio,tiempofinal;
		asistenteInterfaz grafica=new asistenteInterfaz();
		grafica.init(datos);
		grafica.run();
	}
}
