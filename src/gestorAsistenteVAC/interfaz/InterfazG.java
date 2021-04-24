package gestorAsistenteVAC.interfaz;

import gestorAsistenteVAC.util.*;
import java.util.*;

public class InterfazG {
	private StackU<Integer> screenMemory;
	private Scanner scanner;
	
	public InterfazG(){
		screenMemory = new StackU<Integer>();
		screenMemory.push(0);
	}
	
	public void accesScreen(){
		System.out.println("\t\tBIENVENIDO Al GESTOR ASISTENTE VAC\n\n");
		System.out.println("\tPARA ACCEDER INTRODUZCA UN NOMBRE DE PERFIL VALIDO:\n");
	}
	
}
