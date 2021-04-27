package gestorAsistenteVAC.data;


import gestorAsistenteVAC.gest.Vacunas;
import gestorAsistenteVAC.util.QueuesU;

public class vacunaData {
	public QueuesU<Vacunas> vacunas;
	
 	public vacunaData() {
 		this.vacunas=new QueuesU<Vacunas>();
 		
 	}

	public void agregar(String[] v) {
		Vacunas vac = new Vacunas(v[0],Integer.valueOf(v[1]));
		this.vacunas.enqueue(vac);
		
	}

	public void eliminar(int t) {
		for (int i=0;i<t;i++) {
			this.vacunas.dequeue();
		}
	}

	public void vertipo() {
		for(int i=0;i<this.vacunas.getlength();i++) {
			System.out.print("\t\t"+vacunas.nodeConsult(i).getTipo()+"\t\t");
		}
		System.out.println(" ");
		
	}
 	 
 	
 	
	
	

}
