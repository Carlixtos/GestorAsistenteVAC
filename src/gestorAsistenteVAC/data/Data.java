package gestorAsistenteVAC.data;

public class Data {
	public pacienteData paciente;
	public funcionariosData funcionario;

	public Data(){
		this.paciente=new pacienteData();
		this.funcionario=new funcionariosData();
		
	}
	
}
