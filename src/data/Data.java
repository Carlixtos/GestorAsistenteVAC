package data;

public class Data {
	public pacienteData paciente;
	public funcionariosData funcionario;
	public vacunaData vacunas;
	

	public Data(){
		this.paciente=new pacienteData();
		this.funcionario=new funcionariosData();
		this.vacunas=new vacunaData();
		
	}
	
}
