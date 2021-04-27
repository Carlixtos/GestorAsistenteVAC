package gestorAsistenteVAC.gest;

public class Vacunas {

	private String tipo;
	private int dosis;
	
	
	public Vacunas(String t,int d){
	this.setTipo(t);
	this.setDosis(d);
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getDosis() {
		return dosis;
	}
	public void setDosis(int dosis) {
		this.dosis = dosis;
	}
	
	
}
