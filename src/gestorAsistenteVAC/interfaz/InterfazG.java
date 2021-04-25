package gestorAsistenteVAC.interfaz;

import gestorAsistenteVAC.util.*;
import java.util.Scanner;

public class InterfazG {
	private StackU<Integer> screenMemory;
	
	public InterfazG(){
		screenMemory = new StackU<Integer>();
		screenMemory.push(0);
	}
	
	public boolean noScreens() {
		return screenMemory.isEmpty();
	}
	
	public int getScreen() {
		return screenMemory.peek();
	}
	
	public void accesScreen(){
		Scanner scan = new Scanner(System.in);
		
		String profile;
		String passw;
		
		System.out.println("\t\tBIENVENIDO Al GESTOR ASISTENTE VAC\n\n");
		System.out.println("PARA ACCEDER INTRODUZCA UN NOMBRE DE USUARIO VALIDO:");
		System.out.println("(INTRODUZCA \"0\" PARA SALIR)\n");
		
		profile = scan.nextLine();
		
		if(profile.equals("0")) {
			screenMemory.pop();
		}
		
		else {
			if(profile.isEmpty() || charVerif(profile)) {
				System.out.println("\nUSUARIO INVALIDO, VUELVA A INTENTARLO\n");
			}
			
			else {
				System.out.println("\nINTRODUZCA LA CONTRASEÑA\n:");
				
				
			}
		}
	}
	
	public boolean charVerif(String stringV) {
		return (stringV.contains(";") || stringV.contains(",") || stringV.contains(".") || stringV.contains("\\"));
	}
	
	public String profileVerif() {
		
	}
	
}
