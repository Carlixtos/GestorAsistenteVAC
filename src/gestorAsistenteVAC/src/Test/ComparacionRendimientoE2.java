package Test;

import java.lang.System;
import data.Data; 

public class ComparacionRendimientoE2 {
	long timeI;
	long timeF;
	
	generadorDatos tester;
	
	public ComparacionRendimientoE2() {
		tester=new generadorDatos();
	}
	
	
	public void agregarTest(Data datos,int caseNum){
		timeI=System.currentTimeMillis();
		tester.agregarFuncionarios(caseNum, datos);
		timeF=System.currentTimeMillis();
		System.out.println("Metodo agregar con implementación sin arboles se ejecuta en: "+Long.toString(timeF-timeI)+" para "+caseNum+" datos.");
		
		timeI=0;
		timeF=0;
		
		timeI=System.currentTimeMillis();
		tester.agregarPacientes(caseNum, datos);
		timeF=System.currentTimeMillis();
		System.out.println("Metodo agregar con implementación con arboles se ejecuta en: "+Long.toString(timeF-timeI)+" para "+caseNum+" datos.\n");
	}
	
	public void existeTest(Data datos) {
		timeI=System.currentTimeMillis();
		datos.funcionario.existe("1");
		timeF=System.currentTimeMillis();
		System.out.println("Metodo existe con implementación sin arboles se ejecuta en: "+Long.toString(timeF-timeI)+" para el peor caso");
		
		timeI=0;
		timeF=0;
		
		timeI=System.currentTimeMillis();
		datos.paciente.existe("1");
		timeF=System.currentTimeMillis();
		System.out.println("Metodo existe con implementación con arboles se ejecuta en: "+Long.toString(timeF-timeI)+" para el peor caso.\n");
	}
	
	//public void eliminar
}
