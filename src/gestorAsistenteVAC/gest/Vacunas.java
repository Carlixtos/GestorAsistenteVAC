package gestorAsistenteVAC.gest;

public class Vacunas {

	private String tipo;
	private int dosis;
	private int cantidad;
	
	public Vacunas(String t,int d){
	this.setTipo(t);
	this.setDosis(d);
	this.setCantidad(0);
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void agregar(int cantidad) {
		this.cantidad += cantidad;
	}
	public void eliminar(int cantidad) {
		if(this.cantidad<0) {
		this.cantidad -= cantidad;
		}
	}
	
	
}
