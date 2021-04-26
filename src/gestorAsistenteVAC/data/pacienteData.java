package gestorAsistenteVAC.data;

import gestorAsistenteVAC.gest.Paciente;
import gestorAsistenteVAC.util.LinkedListU;

public class pacienteData {
	
	public LinkedListU<Paciente> pacientes;
	
	public pacienteData(){
		this.pacientes=new LinkedListU<Paciente>();
	}
	
	public void asd() {
		
	
	}

	public void agregarp(String[] pa) {
		Paciente paciente=new Paciente(pa[0],pa[1], Integer.valueOf(pa[2]),pa[3], pa[4],Integer.valueOf(pa[5]), pa[6],pa[7],pa[8],Integer.valueOf(pa[9]));
		this.pacientes.addFront(paciente);
	}

	public boolean existe(String nombre) {
		for (int i = 0;i<this.pacientes.getLength();i++) {
			if(this.pacientes.nodeConsult(i).getNombre().equals(nombre)) {;
				return true;
			}
		}
		return false;
	}

	public void eliminarp(String elim) {
		for (int i = 0;i<this.pacientes.getLength();i++) {
			if(this.pacientes.nodeConsult(i).getNombre().equals(elim)) {
				this.pacientes.nodeDrop(this.pacientes.nodeConsult(i));
				break;
			}
		}	
	}

	public void vernombres() {
		for (int i = 0;i<this.pacientes.getLength();i++) {
			System.out.print("\t\t"+pacientes.nodeConsult(i).getNombre()+"\t\t");
		}
	}
	
}
