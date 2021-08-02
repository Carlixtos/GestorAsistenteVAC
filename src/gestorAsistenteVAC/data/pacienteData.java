package gestorAsistenteVAC.data;

import gestorAsistenteVAC.gest.Paciente;
import gestorAsistenteVAC.util.MapIntU;
import gestorAsistenteVAC.util.Maxheap;


public class pacienteData {
	
	//public AVL<Paciente> pacientes;
	private MapIntU<Paciente> pPerfiles; //Almacena los perfiles en una tabla hash donde la llave es el numero del documento de identidad
	private Maxheap<Integer> pPrioridad; //Ordena los documentos de identidad en orden de prioridad
	
	public pacienteData(){
		this.pPerfiles=new MapIntU<Paciente>(50);
		this.pPrioridad=new Maxheap<Integer>();
	}
	
	private int prioridadAuto() {
		int priority=0;
		
		return priority;
	}
	
	public void agregar(String[] pa) {
		Paciente paciente=new Paciente(pa[0],pa[1], Integer.valueOf(pa[2]),pa[3], pa[4],Integer.valueOf(pa[5]), pa[6],pa[7],pa[8],Integer.valueOf(pa[9]));
		this.pPerfiles.set(paciente.getIntKey(), paciente);
		this.pPrioridad.Insert(prioridadAuto(),paciente.getIntKey());
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
