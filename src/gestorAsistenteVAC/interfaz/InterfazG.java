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
	Scanner scan;
	
	public InterfazG(){
		screenMemory = new StackU<Integer>();
		screenMemory.push(0);
		this.scan=new Scanner(System.in);
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
	
	/**
	 * Pantalla para el perfil de administrador
	 * 
	 */
	public void administradorScreen() {
		
		String opcion;
		
		System.out.println("\t\tBIENVENIDO ADMIN\n\n");
		System.out.println("�Que desea hacer?: 1. Crear el perfil de un paciente   ");
		System.out.println("\t\t 2. Crear el perfil de un funcionario   ");
		System.out.println("\t\t 3. eliminar el perfil de un paciente   ");
		System.out.println("\t\t 4. eliminar el perfil de un funcionario   ");
		System.out.println("(INTRODUZCA \"0\" PARA SALIR)");
		
		opcion = this.scan.nextLine();
		
		if(opcion.equals("0")) {
			screenMemory.pop();
		}
		else {
			if(opcion.isEmpty() || charVerif(opcion)) {
				System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
			}
			else {
				switch(opcion) {
				  case "1":
					  screenMemory.push(11);
				    break;
				    
				  case "2":
					  screenMemory.push(12);
				    break;
				  case "3":
					  screenMemory.push(13);
				    break;
				  case "4":
					  screenMemory.push(14);
				    break;
				  default:
				System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
				}
				
			}
		}
		
	//	scan.close();
	
	}
	
public String[] creacionpacienteScreen() {
		
		String opcion;
		String[] mensaje= {"nombre","apellido","edad","genero","tipo de Documento", "Documento", "tipo de sangre","perfil","tipo de vacuna", "dosis"};
		String[] paciente=new String[10];
		int i=0;
		while(i<10) {
			while(i<10) {
				System.out.println("\t\t ingrese el "+mensaje[i]+ "\n\n");
				opcion=this.scan.nextLine();
				if(opcion.isEmpty()) {
					System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
				}
				else {
					if(i==2||i==5||i==9) {
							try {
								Integer.valueOf(opcion);
							}
							catch(Exception e) {
								System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
								break;
							}
							paciente[i]=opcion;
							i++;	
							
				
					}
					else {
						if(charVerif(opcion)) {
							System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
							break;
						}
						else {
							paciente[i]=opcion;
							i++;
						}
					}
				}
				}
			}
		System.out.println("\nCreacion de paciente exitosa\n");
		screenMemory.pop();
		return paciente;
		
	//	scan.close();	
	}
	
	
	
	
	/**
	 * La pantalla de acceso o pantalla inicial (0)
	 */
	public void accesScreen(){
		
		String userName;
		String passw;
		
		System.out.println("\t\tBIENVENIDO Al GESTOR ASISTENTE VAC\n\n");
		System.out.println("PARA ACCEDER INTRODUZCA UN NOMBRE DE USUARIO VALIDO:");
		System.out.println("(INTRODUZCA \"0\" PARA SALIR)\n");
		
		userName = this.scan.nextLine();
		
		if(userName.equals("0")) {
			screenMemory.pop();
		}
		
		else {
			if(userName.isEmpty() || charVerif(userName)) {
				System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
			}
			
			else {
				System.out.println("\nINTRODUZCA LA CONTRASE�A:\n");
				passw = this.scan.nextLine();
				
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
		
	//	scan.close();
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

	public String[] creacionfuncionarioScreen() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
