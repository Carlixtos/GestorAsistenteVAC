package gestorAsistenteVAC.data;

import gestorAsistenteVAC.gest.Paciente;
import gestorAsistenteVAC.util.AVL;
import gestorAsistenteVAC.util.NodeA;


public class pacienteData {
	
	public AVL<Paciente> pacientes;
	
	public pacienteData(){
		this.pacientes=new AVL<Paciente>();
	}
	
	public void agregar(String[] pa) {
		Paciente paciente=new Paciente(pa[0],pa[1], Integer.valueOf(pa[2]),pa[3], pa[4],Integer.valueOf(pa[5]), pa[6],pa[7],pa[8],Integer.valueOf(pa[9]));
		this.pacientes.insert(Integer.valueOf(pa[5]),paciente);
	}

	public boolean existe(String key) {		
		try {
		this.pacientes.find(Integer.valueOf(key));
		return true;
		}catch(NullPointerException e) {
		return false;
		}
	}

	public void eliminar(String key) {
		this.pacientes.delete(Integer.valueOf(key));
	}

	public void vernombres() {
		//this.pacientes.inOrderPrint();
		this.pacientes.printTree(this.pacientes.getRoot(), "  ", false);
	}

	public void remplazar(String key, String[] pa) {
		this.pacientes.delete(Integer.valueOf(key));
		this.agregar(pa);
	}
	
}
