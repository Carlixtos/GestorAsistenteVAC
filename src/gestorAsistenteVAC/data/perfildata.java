package gestorAsistenteVAC.data;

import gestorAsistenteVAC.gest.*;
import gestorAsistenteVAC.util.LinkedListU;

public abstract class perfildata {
	
	LinkedListU<Perfiles> perfiles;
	
	
	public perfildata() {

	}
	abstract public void agregar(String[] perfil);
	//abstract public void cperfiles();
	
	
	public boolean existe(String nombre) {
		for (int i = 0;i<this.perfiles.getLength();i++) {
			if(this.perfiles.nodeConsult(i).getNombre().equals(nombre)) {;
				return true;
			}
		}
		return false;
	}
	
	
	
	public void eliminar(String elim) {
		for (int i = 0;i<this.perfiles.getLength();i++) {
			if(this.perfiles.nodeConsult(i).getNombre().equals(elim)) {;
				this.perfiles.nodeDrop(this.perfiles.nodeConsult(i));
				break;
			}
		}	
	}
	
	
	
	public void vernombres() {
		for (int i = 0;i<this.perfiles.getLength();i++) {
			System.out.print("\t\t"+perfiles.nodeConsult(i).getNombre()+"\t\t");
		}
		System.out.println(" ");
	}
	
	
	
	
}
