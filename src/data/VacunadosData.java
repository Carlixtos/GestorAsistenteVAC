package data;

import gest.Paciente;
import util.LinkedListU;
import util.MapIntU;
import util.Maxheap;

public class VacunadosData {
	private MapIntU<Paciente> vPerfiles;
	private LinkedListU<Integer> vIds;
	
	public VacunadosData() {
		this.vPerfiles = new MapIntU<Paciente>(50);
		this.vIds= new LinkedListU<Integer>();
	}
	
	public MapIntU<Paciente> getHashMap() {
		return vPerfiles;
	}
	
	public LinkedListU<Integer> getIds(){
		return vIds;
	}
	
	public void agregar(Paciente vacunado) {
		vPerfiles.set(vacunado.getIntKey(), vacunado);
		vIds.addBack(vacunado.getIntKey());
	}
	
	public int getVacunados() {
		return vPerfiles.GetKeysNum();
	}
}

