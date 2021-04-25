package gestorAsistenteVAC.interfaz;

import gestorAsistenteVAC.util.*;
import gestorAsistenteVAC.data.Profile;
import java.util.Scanner;

/**
 * Clase que gestiona la interfaz grafica del prototipo
 * @author Dafty-Punky-Boy
 * @version 1.0, 24/04/21
 */
public class InterfazG {
	private StackU<Integer> screenMemory;
	private Profile user;
	
	public InterfazG(){
		screenMemory = new StackU<Integer>();
		screenMemory.push(0);
	}
	
	/**
	 * Indica si ya no quedan mas pantallas por mostrar. 
	 * @return true si ya no hay mas pantallas, false en el caso contrario.
	 */
	public boolean noScreens() {
		return screenMemory.isEmpty();
	}
	
	/**
	 * Indica la pantalla actual.
	 * @return El identificador (numero entero) de la pantalla actual.
	 */
	public int getScreen() {
		return screenMemory.peek();
	}
	
	public void administratorMScreen() {
		;
	}
	
	/**
	 * La pantalla de acceso o pantalla inicial (0)
	 */
	public void accesScreen(){
		Scanner scan = new Scanner(System.in);
		
		String userName;
		String passw;
		
		System.out.println("\t\tBIENVENIDO Al GESTOR ASISTENTE VAC\n\n");
		System.out.println("PARA ACCEDER INTRODUZCA UN NOMBRE DE USUARIO VALIDO:");
		System.out.println("(INTRODUZCA \"0\" PARA SALIR)\n");
		
		userName = scan.nextLine();
		
		if(userName.equals("0")) {
			screenMemory.pop();
		}
		
		else {
			if(userName.isEmpty() || charVerif(userName)) {
				System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
			}
			
			else {
				System.out.println("\nINTRODUZCA LA CONTRASEÑA:\n");
				passw = scan.nextLine();
				
				if(passw.isEmpty() || charVerif(passw)) {
					System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
				}
				
				else {
					Profile profTemp = new Profile(userName, passw, "Temporal");
					profTemp = userVerif(profTemp);
					
					if(profTemp == null) {
						System.out.println("\nEL PERFIL INGRESADO NO EXISTE\n");
					}
					
					else {
						user = profTemp;
						
						if(user.getType().equals("Administrador")) {
							screenMemory.push(10);
						}
						
						else if(user.getType().equals("Aplicador")) {
							screenMemory.push(20);
						}
						
						else {
							screenMemory.push(30);
						}
					}
				}
				
				
			}
		}
		
		scan.close();
	}
	
	/**
	 * Verifica que en un String dado no hayan caracteres invalidos.
	 * @param stringV El String a verificar.
	 * @return true si no contiene caracteres invalidos, false en el caso contrario.
	 */
	public boolean charVerif(String stringV) {
		return (stringV.contains(";") || stringV.contains(",") || stringV.contains(".") || stringV.contains("\\"));
	}
	
	/**
	 * Verifica si un perfil de acceso (Profile) dado corresponde a un perfil existente.
	 * @param accesProf El perfil a verificar.
	 * @return El perfil si este existe, null en el caso contrario. 
	 */
	public Profile userVerif(Profile accesProf) {
		Profile profile1 = new Profile("zambranol32", "nolbra23", "Administrador");
		Profile profile2 = new Profile("crios92", "octavio69", "Administrador");
		Profile profile3 = new Profile("fenel11", "nelfe90", "Administrador");
		
		Profile[] profiles = {profile1, profile2, profile3};
		
		for(int i = 0; i < 3; ++i) {
			if(profiles[i].equals(accesProf)) {
				return profiles[i];
			}
		}
		
		return null;
	}
	
}
