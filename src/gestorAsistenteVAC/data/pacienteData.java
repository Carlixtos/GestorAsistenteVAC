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
	
}
