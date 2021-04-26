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
	public void popscreen() {
		this.screenMemory.pop();
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
				System.out.println("\nINTRODUZCA LA CONTRASEÑA:\n");
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
	 * Pantalla para el perfil de administrador
	 * 
	 */
	public void administradorScreen() {
		
		String opcion;
		
		System.out.println("\t\tBIENVENIDO ADMIN\n\n");
		System.out.println("¿Que desea hacer?: 1. Crear el perfil de un paciente   ");
		System.out.println("\t\t   2. Crear el perfil de un funcionario   ");
		System.out.println("\t\t   3. eliminar el perfil de un paciente   ");
		System.out.println("\t\t   4. eliminar el perfil de un funcionario   ");
		System.out.println("\t\t   5. ver los pacientes creados   ");
		System.out.println("\t\t   6. ver los funcionarios creados    ");
		System.out.println("\t\t   9. para ingresar al modo de prueba (generacion de datos aleatoreos)    ");
		System.out.println("(INTRODUZCA \"0\" PARA SALIR)");
		boolean l = false;
		while(l!=true) {
		opcion = this.scan.nextLine();
		
		if(opcion.equals("0")) {
			screenMemory.pop();
			l=true;
		}
		else {
			if(opcion.isEmpty() || charVerif(opcion)) {
				System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
			}
			else {
				switch(opcion) {
				  case "1":
					  screenMemory.push(11);
					  l=true;
				    break;
				    
				  case "2":
					  screenMemory.push(12);
					  l=true;
				    break;
				  case "3":
					  screenMemory.push(13);
					  l=true;
				    break;
				  case "4":
					  screenMemory.push(14);
					  l=true;
				    break;
				  case "5":
					  screenMemory.push(15);
					  l=true;
					 break;
				  case "6":
					  screenMemory.push(16);
					  l=true;
					 break;
				  case "9":
					  screenMemory.push(90);
					  l=true;
					 break; 
				  default:
				System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
				}
				
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
		
	
	public String[] creacionfuncionarioScreen() {
		
			String opcion;
			String[] mensaje= {"nombre","apellido","edad","genero","tipo de Documento", "Documento", "tipo de sangre","perfil","horario"};
			String[] funcionario=new String[9];
			int i=0;
			while(i<9) {
				while(i<9) {
					System.out.println("\t\t ingrese el "+mensaje[i]+ "\n\n");
					opcion=this.scan.nextLine();
					if(opcion.isEmpty()) {
						System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
					}
					else {
						if(i==2||i==5||i==8) {
								try {
									Integer.valueOf(opcion);
								}
								catch(Exception e) {
									System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
									break;
								}
								funcionario[i]=opcion;
								i++;	
								
					
						}
						else {
							if(charVerif(opcion)) {
								System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
								break;
							}
							else {
								funcionario[i]=opcion;
								i++;
							}
						}
					}
					}
				}
			System.out.println("\nCreacion de paciente exitosa\n");
			screenMemory.pop();
			return funcionario;
			
		//	scan.close();	
		}
	
	
	
	public void test() {
			
			String opcion;
			
			System.out.println("\t\tBIENVENIDO A LA SESION DE PRUEBAS\n\n");
			System.out.println("¿Que desea hacer?: 1. Crear los perfiles de pacientes aleatoreos   ");
			System.out.println("\t\t   2. Crear los perfiles de funcionarios aleatoreos  ");
			System.out.println("\t\t   3. ver los pacientes creados   ");
			System.out.println("\t\t   4. ver los funcionarios creados    ");
			System.out.println("\t\t   5. Eliminar los perfiles de Pacientes   ");
			System.out.println("\t\t   6. Eliminar los perfiles de funcionarios    ");
			System.out.println("(INTRODUZCA \"0\" PARA SALIR)");
			boolean l = false;
			while(l!=true) {
			opcion = this.scan.nextLine();
			
			if(opcion.equals("0")) {
				screenMemory.pop();
				l=true;
			}
			else {
				if(opcion.isEmpty() || charVerif(opcion)) {
					System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
				}
				else {
					switch(opcion) {
					  case "1":
						  screenMemory.push(91);
						  l=true;
					    break;
					    
					  case "2":
						  screenMemory.push(92);
						  l=true;
					    break;
					  case "3":
						  screenMemory.push(15);
						  l=true;
					    break;
					  case "4":
						  screenMemory.push(16);
						  l=true;
					    break;
					  case "5":
						  screenMemory.push(93);
						  l=true;
					    break;
					  case "6":
						  screenMemory.push(94);
						  l=true;
					    break;
					  default:
					System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
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
		Profile profile3 = new Profile("f", "f1", "Administrador");
		
		Profile[] profiles = {profile1, profile2, profile3};
		
		for(int i = 0; i < 3; ++i) {
			if(profiles[i].equals(accesProf)) {
				return profiles[i];
			}
		}
		
		return null;
	}

	public String nombre() {
		String opcion = null;
		
		System.out.println("\t\t Ingres el nombre de quien busca \n\n");

		boolean l = false;
		while(l!=true) {
			opcion = this.scan.nextLine();
			if(opcion.isEmpty()||charVerif(opcion)) {
				System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
			}
			else {
			l=true;				
			}
		}
		this.screenMemory.pop();
		return opcion;
	}

	public int testnumero() {
		String opcion = null;
		
		System.out.println("\t\t Ingrese el numero de datos que desea \n\n");

		boolean l = false;
		while(l!=true) {
			opcion = this.scan.nextLine();
			try {
				Integer.valueOf(opcion);
				l=true;
			}
			catch(Exception e) {
				System.out.println("\nSE HA INGRESADO CARACTERES INVALIDOS, VUELVA A INTENTARLO\n");
			}
		}
		this.screenMemory.pop();
		return Integer.valueOf(opcion);
	}

	
}
