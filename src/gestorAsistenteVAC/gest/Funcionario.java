package gestorAsistenteVAC.gest;

public class Funcionario extends Perfiles{
	private int[][] horario;

	public Funcionario(String nombre, String apellido, int edad, String genero, String tDocumento, int documento,
			String sangre, String perfil,int[][] horario) {
		super(nombre, apellido, edad, genero, tDocumento, documento, sangre, perfil);
		// TODO Auto-generated constructor stub
		this.horario=horario;
	}

	public int[][] getHorario() {
		return horario;
	}

	public void setHorario(int[][] horario) {
		this.horario = horario;
	}
	

}
