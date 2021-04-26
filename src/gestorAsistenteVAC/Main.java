package gestorAsistenteVAC;

import gestorAsistenteVAC.util.*;
import gestorAsistenteVAC.interfaz.*;
import gestorAsistenteVAC.Test.LinkedListTest;
import gestorAsistenteVAC.Test.StackTest;
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
					datos.paciente.agregarp(gestorIntf.creacionpacienteScreen());
					break;
				}
				case 12:{
					datos.funcionario.agregarf(gestorIntf.creacionfuncionarioScreen());
					break;
				}
				case 13:{
					String elim = gestorIntf.nombre();
					if(datos.paciente.existe(elim)) {
					datos.paciente.eliminarp(elim);
					}
					break;
				}
				case 14:{
					String elim = gestorIntf.nombre();
					if(datos.funcionario.existe(elim)) {
					datos.funcionario.eliminarf(elim);
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
		}
		
		}
		
		
		
		
	}

}
