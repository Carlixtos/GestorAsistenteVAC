package gestorAsistenteVAC.data;


import gestorAsistenteVAC.gest.Vacunas;
import gestorAsistenteVAC.util.NodeU;
import gestorAsistenteVAC.util.QueuesU;

public class vacunaData {
	public QueuesU<Vacunas> vacunas;
	
 	public vacunaData() {
 		this.vacunas=new QueuesU<Vacunas>();
 		Vacunas pfizer  = new Vacunas("pfizer"  ,2);
 		Vacunas moderna = new Vacunas("moderna" ,2);
 		Vacunas janssen = new Vacunas("janssen" ,1);
 		this.vacunas.enqueue(pfizer);
 		this.vacunas.enqueue(moderna);
 		this.vacunas.enqueue(janssen);
 	}

	public void agregar(String tipo,int num) {
		NodeU<Vacunas> aux = this.vacunas.getHead();
		for (int i =0;i<3;i++) {
			if(aux.getKey().getTipo().equals(tipo)) {
				aux.getKey().agregar(num);
			}
			aux=aux.getNext();
		}
		
	}

	public String eliminar(int t) {
		Vacunas aux = this.vacunas.dequeue();

		for (int i =0;i<3;i++) {
			if(aux.getCantidad()<=0) {
				this.vacunas.enqueue(aux);
				aux=this.vacunas.dequeue();
				}
			else {
				break;
				}
			}
		
		aux.eliminar(t);
		return aux.getTipo();

	}

	public int getCantidad(String tipo) {
		NodeU<Vacunas> aux = this.vacunas.getHead();
		for (int i =0;i<3;i++) {
			if(aux.getKey().getTipo().equals(tipo)) {
				return aux.getKey().getCantidad();
			}
			aux=aux.getNext();
		}
		return 0;
		
	}	

}
