package gestorAsistenteVAC.gest;

import gestorAsistenteVAC.util.KeysU;

public class Perfiles implements KeysU{
	
	private String genero,nombre,apellido,sangre,tipoDocumento,perfil;
	
	private int edad,documento;
	
	Perfiles(String nombre,String apellido,int edad,String genero,String tDocumento,int documento,String sangre,String perfil){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.genero=genero;
		this.tipoDocumento=tDocumento;
		this.documento=documento;
		this.sangre=sangre;
		this.perfil=perfil;
	}
	
	
	public int getIntKey() {
		return documento;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getSangre() {
		return sangre;
	}
	public void setSangre(String sangre) {
		this.sangre = sangre;
	}
	public String getNombre() {
		return nombre;
	}	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}		
	
}
