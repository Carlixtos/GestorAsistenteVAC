package gest;

public class Paciente extends Perfiles{

	private String tipoVacuna;
	
	private int dosis;
	
	private int FechaCita;
	
	private boolean enfermedad;
	
	private String aplicador;

	private int hora;

	public Paciente(String nombre, String apellido, int edad, String genero, String tDocumento, int documento, String sangre,
			String perfil,boolean enfermedades,String tipVacuna,int dosis,int hora,int FechaCita,String Aplicador ) {
		super(nombre, apellido, edad, genero, tDocumento, documento, sangre, perfil);

		this.tipoVacuna=tipVacuna;
		this.dosis=dosis;
		this.aplicador=Aplicador;
		this.setHora(hora);
		this.FechaCita=FechaCita;
		this.setEnfermedad(enfermedades);
		
		
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

	public int getFechaCita() {
		return FechaCita;
	}

	public void setFechaCita(int fechaCita) {
		FechaCita = fechaCita;
	}

	public String getAplicador() {
		return this.aplicador;
	}

	public void setAplicador(String aplicador) {
		this.aplicador = aplicador;
	}

	public boolean isEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(boolean enfermedad) {
		this.enfermedad = enfermedad;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

}