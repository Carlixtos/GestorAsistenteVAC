package data;

import gest.Paciente;
import util.MapIntU;
import util.Maxheap;
import java.util.Scanner; // Borrar despues de implementar con interfaz


public class pacienteData {
	
	//public AVL<Paciente> pacientes;
	public MapIntU<Paciente> pPerfiles; //Almacena los perfiles en una tabla hash donde la llave es el numero del documento de identidad
	public Maxheap<Integer> pPrioridad; //Ordena los documentos de identidad en orden de prioridad
	
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
		if(paciente.isEnfermedad()) {
			if(paciente.isEnfermedad() && paciente.getEdad()<=65) { 
				priori+=2;
			}
			else priori+=1;
		}
		/* IMPLEMENTAR INTERFAZ GRAFICA
		   CODIGO TEMPORAL PARA PRUEBAS
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
		
		sc.close();*/
		return priori;
	}
	
	public void agregar(String[] pa,String[] fu,String[] va) {
		int hora=Integer.valueOf(fu[0]);
		int fecha =Integer.valueOf(fu[1]);
		String aplic=fu[2];
		
		Paciente paciente=new Paciente(pa[0],pa[1], Integer.valueOf(pa[2]),pa[3], pa[4],Integer.valueOf(pa[5]), pa[6],pa[7], Boolean.parseBoolean(pa[8]),va[0],Integer.valueOf(va[1]),hora,fecha,aplic);          
		this.pPerfiles.set(paciente.getIntKey(), paciente);
		this.pPrioridad.Insert(prioridadAuto(paciente),paciente.getIntKey());
	}

	public boolean existe(String key) {		
		return this.pPerfiles.exists(Integer.valueOf(key));
	}

	public void eliminar(String key) {
		this.pPerfiles.delete(Integer.valueOf(key));
		this.pPrioridad.Remove(Integer.valueOf(key));
	}
	
	public Paciente getPerfil(String key) {
		return this.pPerfiles.get(Integer.valueOf(key));
	}
	
	public Paciente extractMax() {
		Paciente paciente=this.pPerfiles.get(this.pPrioridad.ExtractMax());
		this.pPerfiles.delete(paciente.getIntKey());
		
		return paciente;
	}

	public void remplazar(String key, String[] pa,String[] fu) { // Se espera que la key de parametro sea igual a la key del perfil a remplazar
		int hora=Integer.valueOf(fu[0]);
		int fecha =Integer.valueOf(fu[1]);
		String aplic=fu[1];
		Paciente paciente=new Paciente(pa[0],pa[1], Integer.valueOf(pa[2]),pa[3], pa[4],Integer.valueOf(pa[5]), pa[6],pa[7],Boolean.parseBoolean(pa[8]),pa[9],Integer.valueOf(pa[10]),hora,fecha,aplic);          
		this.pPerfiles.set(Integer.valueOf(key),paciente);
	}
	public int getCantidad(){
		return this.pPrioridad.getSize();
	}

	public Paciente getMax() {
		return this.pPerfiles.get(this.pPrioridad.getMax());
	}
	
}
