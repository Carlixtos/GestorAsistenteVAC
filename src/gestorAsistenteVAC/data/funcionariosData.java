package gestorAsistenteVAC.data;
import gestorAsistenteVAC.gest.Paciente;
import gestorAsistenteVAC.util.LinkedListU;


public class funcionariosData {
	
	public LinkedListU<Paciente> funcionarios;
	
		public funcionariosData(){
			this.funcionarios =new LinkedListU<Paciente>();
		}
}
