package main;

import util.*;
import interfaz.*;
import Test.*;
import data.*;
import gest.Paciente;



public class Main {

	public static void main(String[] args) { // Codigo de prueba
		InterfazG gestorIntf = new InterfazG();
		Data datos= new Data();
		long tiempoinicio,tiempofinal;
		asistenteInterfaz grafica=new asistenteInterfaz();
		grafica.init(datos);
		grafica.run();
		
		/* PRUEBA QUE PACIENTES FUNCIONA CON HASH Y MAX HEAP *//*
		Data dataGest=new Data();
		generadorDatos dataGen=new generadorDatos();
		Paciente paciente;
		
		dataGen.agregarPacientes(1, dataGest);
		
		paciente=dataGest.paciente.extractMax();
		
		System.out.println(paciente.getNombre()+" "+paciente.getApellido());
		System.out.println(paciente.getEdad());
		System.out.println(paciente.getTipoDocumento()+" "+paciente.getDocumento());
		System.out.println(paciente.getSangre());
		System.out.println(paciente.getTipoVacuna()+" "+paciente.getDosis());
		
		/*CORRECCIONES NECESARIAS PARA LA CLASE MAX HEAP*/
		
	}
}
