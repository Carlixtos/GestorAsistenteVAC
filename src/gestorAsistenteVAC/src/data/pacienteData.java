package data;

import gest.Paciente;
import util.MapIntU;
import util.Maxheap;
import java.util.Scanner; // Borrar despues de implementar con interfaz


public class pacienteData {
	
	//public AVL<Paciente> pacientes;
	private MapIntU<Paciente> pPerfiles; //Almacena los perfiles en una tabla hash donde la llave es el numero del documento de identidad
	private Maxheap<Integer> pPrioridad; //Ordena los documentos de identidad en orden de prioridad
	
	public pacienteData(){
		this.pPerfiles=new MapIntU<Paciente>(50);
		this.pPrioridad=new Maxheap<Integer>();
	}
	
	private int prioridadAuto(Paciente paciente) {
		int priori=0;
		
		if(75<paciente.getEdad()) {
			return 7;
		}
		
		else if(paciente.getEdad()<=75 && 65<paciente.getEdad()) {
			priori+=6;
		}
		
		else if(paciente.getEdad()<=65 && 55<paciente.getEdad()) {
			priori+=5;
		}
		
		else if(paciente.getEdad()<=55 && 45<paciente.getEdad()) {
			priori+=4;
		}
		
		else if(paciente.getEdad()<=45 && 30<paciente.getEdad()) {
			priori+=3;
		}
		
		else if(paciente.getEdad()<=30 && 12<=paciente.getEdad()) {
			priori+=1;
		}
	
		/* IMPLEMENTAR INTERFAZ GRAFICA
		   CODIGO TEMPORAL PARA PRUEBAS*/
		Scanner sc=new Scanner(System.in);
		
		System.out.println("¿El paciente sufre de alguna enfermedad cardio-respiratoria?");
		System.out.println("(SI/NO)\n");
		
		if(sc.next().equals("SI")) {
			System.out.println("\n¿La afección que sufre es grave o cronica?");
			System.out.println("(SI/NO)\n");
			
			if(sc.next().equals("SI") && paciente.getEdad()<=65) priori+=2;
			else priori+=1;
			
			System.out.println();
		}
		
		sc.close();
		return priori;
	}
	
	public void agregar(String[] pa) {
		Paciente paciente=new Paciente(pa[0],pa[1], Integer.valueOf(pa[2]),pa[3], pa[4],Integer.valueOf(pa[5]), pa[6],pa[7],pa[8],Integer.valueOf(pa[9]));
		this.pPerfiles.set(paciente.getIntKey(), paciente);
		this.pPrioridad.Insert(prioridadAuto(paciente),paciente.getIntKey());
	}

	public boolean existe(String key) {		
		return this.pPerfiles.exists(Integer.valueOf(key));
	}

	public void eliminar(String key) {
		this.pPerfiles.delete(Integer.valueOf(key));
		//this.pPrioridad.Remove() ELIMINAR NUMERO DE IDENTIFICACIÓN DE LA MAX HEAP??
	}
	
	public Paciente getPerfil(String key) {
		return this.pPerfiles.get(Integer.valueOf(key));
	}
	
	public Paciente extractMax() {
		Paciente paciente=this.pPerfiles.get(this.pPrioridad.ExtractMax());
		this.pPerfiles.delete(paciente.getIntKey());
		
		return paciente;
	}

	/*public void vernombres() { CREO QUE NO ES APLICABLE CON LA NUEVA IMPLEMENTACIÓN
		//this.pacientes.inOrderPrint();
		this.pacientes.printTree(this.pacientes.getRoot(), "  ", false);
	}*/

	public void remplazar(String key, String[] pa) { // Se espera que la key de parametro sea igual a la key del perfil a remplazar
		Paciente paciente=new Paciente(pa[0],pa[1], Integer.valueOf(pa[2]),pa[3], pa[4],Integer.valueOf(pa[5]), pa[6],pa[7],pa[8],Integer.valueOf(pa[9]));
		this.pPerfiles.set(Integer.valueOf(key),paciente);
	}
}
