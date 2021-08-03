package gest;

public class Paciente extends Perfiles{

	private String tipoVacuna;
	
	private int dosis;

	public Paciente(String nombre, String apellido, int edad, String genero, String tDocumento, int documento, String sangre,
			String perfil,String tipVacuna,int dosis) {
		super(nombre, apellido, edad, genero, tDocumento, documento, sangre, perfil);
		// TODO Auto-generated constructor stub
		this.tipoVacuna=tipVacuna;
		this.dosis=dosis;
	}

	public String getTipoVacuna() {
		return tipoVacuna;
	}

	public void setTipoVacuna(String tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}

	public int getDosis() {
		return dosis;
	}

	public void setDosis(int dosis) {
		this.dosis = dosis;
	}

}