package gestorAsistenteVAC;

import gestorAsistenteVAC.util.*;
import gestorAsistenteVAC.interfaz.*;
import gestorAsistenteVAC.Test.LinkedListTest;
import gestorAsistenteVAC.Test.StackTest;
import gestorAsistenteVAC.Test.generadorDatos;
import gestorAsistenteVAC.data.*;


public class Main {

	public static void main(String[] args) { // Codigo de prueba
		InterfazG gestorIntf = new InterfazG();
		Data datos= new Data();
		

		while(!gestorIntf.noScreens()) {
			switch(gestorIntf.getScreen()) {
				case 0:{
					gestorIntf.accesScreen();
					break;
				}
				case 10:{
					gestorIntf.administradorScreen();

					break;
				}
				case 11:{
					datos.paciente.agregar(gestorIntf.creacionpacienteScreen());
					break;
				}
				case 12:{
					datos.funcionario.agregar(gestorIntf.creacionfuncionarioScreen());
					break;
				}
				case 13:{
					String elim = gestorIntf.nombre();
					if(datos.paciente.existe(elim)) {
					datos.paciente.eliminar(elim);
					}
					break;
				}
				case 14:{
					String elim = gestorIntf.nombre();
					if(datos.funcionario.existe(elim)) {
					datos.funcionario.eliminar(elim);
					}					
					break;
				}
				case 15:{
					datos.paciente.vernombres();
					gestorIntf.popscreen();
					break;
				}
				case 16:{
					datos.funcionario.vernombres();
					gestorIntf.popscreen();
					break;
				}
				case 90:{
					gestorIntf.test();
					break;
				}
				case 91:{
					generadorDatos test=new generadorDatos();
					int l=gestorIntf.testnumero();
					test.agregarPacientes(l, datos);
					break;
				}
				case 92:{
					generadorDatos test=new generadorDatos();
					int l=gestorIntf.testnumero();
					test.agregarFuncionarios(l, datos);
					break;
				}
				case 93:{
					generadorDatos test=new generadorDatos();
					int l=gestorIntf.testnumero();
					test.eliminarPacientes(l, datos);
					break;
				}
				case 94:{
					generadorDatos test=new generadorDatos();
					int l=gestorIntf.testnumero();
					test.eliminarFuncionarios(l, datos);
					break;
				}
				
				
		}
		
		}
		
		
		
		
	}

}
