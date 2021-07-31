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
		
		
		
		
		//AVLTest.velTest();
//<<<<<<< HEAD
	/*	ComparacionRendimientoE2 comparador=new ComparacionRendimientoE2();
		comparador.agregarTest(datos, 1000000);
		comparador.existeTest(datos);*/
//=======
		//ComparacionRendimientoE2 comparador=new ComparacionRendimientoE2();
		//comparador.agregarTest(datos, 10000);
		//comparador.existeTest(datos);
//>>>>>>> 4fc05465610949d0abdc532bb68d11e7ecfb9b7d
		
		
		
		
/*
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
				case 17:{
					datos.vacunas.agregar(gestorIntf.agregarVacunas());
					break;
				}
				case 18:{
					datos.vacunas.eliminar(gestorIntf.testnumero());	
					break;
				}
				case 19:{
					datos.vacunas.vertipo();	
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
					tiempoinicio=System.currentTimeMillis();
					test.agregarPacientes(l, datos);
					tiempofinal=System.currentTimeMillis();
					System.out.println(tiempofinal-tiempoinicio);
					break;
				}
				case 92:{
					generadorDatos test=new generadorDatos();
					int l=gestorIntf.testnumero();
					tiempoinicio=System.currentTimeMillis();
					test.agregarFuncionarios(l, datos);
					tiempofinal=System.currentTimeMillis();
					System.out.println(tiempofinal-tiempoinicio);
					break;
				}
				case 93:{
					generadorDatos test=new generadorDatos();
					int l=gestorIntf.testnumero();
					tiempoinicio=System.currentTimeMillis();
					test.eliminarPacientes(l, datos);
					tiempofinal=System.currentTimeMillis();
					System.out.println(tiempofinal-tiempoinicio);
					break;
				}
				case 94:{
					generadorDatos test=new generadorDatos();
					int l=gestorIntf.testnumero();
					tiempoinicio=System.currentTimeMillis();
					test.eliminarFuncionarios(l, datos);
					tiempofinal=System.currentTimeMillis();
					System.out.println(tiempofinal-tiempoinicio);
					break;
				}
				case 95:{
					generadorDatos test=new generadorDatos();
					int l=gestorIntf.testnumero();
					tiempoinicio=System.currentTimeMillis();
					test.remplazarPacientes(l, datos);
					tiempofinal=System.currentTimeMillis();
					System.out.println(tiempofinal-tiempoinicio);
					break;
				}
				case 96:{
					generadorDatos test=new generadorDatos();
					int l=gestorIntf.testnumero();
					tiempoinicio=System.currentTimeMillis();
					test.remplazarFuncionarios(l, datos);
					tiempofinal=System.currentTimeMillis();
					System.out.println(tiempofinal-tiempoinicio);
					break;
				}
				case 97:{
					generadorDatos test=new generadorDatos();
					int l=gestorIntf.testnumero();
					tiempoinicio=System.currentTimeMillis();
					test.agregarVacunas(l,datos);
					tiempofinal=System.currentTimeMillis();
					System.out.println(tiempofinal-tiempoinicio);
					break;
				}
				case 98:{
					generadorDatos test=new generadorDatos();
					int l=gestorIntf.testnumero();
					tiempoinicio=System.currentTimeMillis();
					test.eliminarVacunas(l, datos);
					tiempofinal=System.currentTimeMillis();
					System.out.println(tiempofinal-tiempoinicio);
					break;
				}
				
				
				
		}
		
		}*/
		
	}

}
