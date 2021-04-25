package gestorAsistenteVAC.data;
/**
 * Clase Perfil de acceso para el software.
 * @author Dafty-Punky-Boy
 * @version 1.0, 24/04/21
 */
public class Profile {
	private String userName;
	private String passw;
	private String profileType;
	
	/**
	 * Crea un nuevo perfil de acceso.
	 * @param userName String del nombre de usuario. No debe contener "\", ".", ";", ",". 
	 * @param passw String de la contraseña de usuario. No debe contener "\", ".", ";", ",". 
	 * @param profileType String del tipo de usuario. Obligatoriamente uno de los siguientes: "Administrador", "Aplicador", "Analista", "Temporal".
	 */
	public Profile(String userName, String passw, String profileType) {
		this.userName = userName;
		this.passw = passw;
		this.profileType = profileType;
	}
	
	public String getUserN() {
		return userName;
	}
	
	public String getPassw() {
		return passw;
	}
	
	public String getType() {
		return profileType;
	}
	
	public boolean equals(Profile otherProf) {
		return userName.equals(otherProf.getUserN()) && passw.equals(otherProf.getPassw());
	}
	
}
