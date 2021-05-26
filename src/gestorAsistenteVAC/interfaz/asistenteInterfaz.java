package gestorAsistenteVAC.interfaz;

import gestorAsistenteVAC.data.Profile;
import gestorAsistenteVAC.util.StackU;

public class asistenteInterfaz {
	
	private StackU<Integer> screenMemory;
	private interfazGrafica acceso;
	private admin admin;
	
	public asistenteInterfaz(){
		this.screenMemory = new StackU<Integer>();
		this.screenMemory.push(0);
	}
	public void init() {
		acceso=new interfazGrafica(this);
		admin=new admin(this);
		
	}
	
	
	
	public void run() {
			this.off();
			switch(this.getScreenMemory().peek()) {
				case 0:{
					acceso.setVisible(true);
					break;
				}case 1:{
					admin.setVisible(true);
					break;
				}		
			}
	}
	
	public void off() {
		acceso.setVisible(false);
		admin.setVisible(false);
		
		
	}
	
	
	public boolean ingresoUsuario(String usuario, String contraseña) {
		if(usuario.isEmpty() || contraseña.isEmpty()||charVerif(usuario)||charVerif(contraseña)) {
			return false;
		}else {
			Profile profTemp = new Profile(usuario, contraseña, "Temporal");
			profTemp = userVerif(profTemp);
			
			if(profTemp == null) {
				System.out.println("\nEL PERFIL INGRESADO NO EXISTE\n");
				return false;
			}
			
			else {
				Profile user = profTemp;
				
				if(user.getType().equals("Administrador")) {
					System.out.print("Eres admin");
					this.screenMemory.push(1);
					this.run();
					return true;
				}
				
				else if(user.getType().equals("Aplicador")) {
					return true;
				}
				
				else {
					return true;
				}
			}
		}
	}
	
	public Profile userVerif(Profile accesProf) {
		Profile profile1 = new Profile("zambranol32", "nolbra23", "Administrador");
		Profile profile2 = new Profile("crios92", "octavio69", "Administrador");
		Profile profile3 = new Profile("f", "f1", "Administrador");
		
		Profile[] profiles = {profile1, profile2, profile3};
		
		for(int i = 0; i < 3; ++i) {
			if(profiles[i].equals(accesProf)) {
				return profiles[i];
			}
		}
		
		return null;
	}

	private boolean charVerif(String stringV) {
		return (stringV.contains(";") || stringV.contains(",") || stringV.contains(".") || stringV.contains("\\"));

	}

	public StackU<Integer> getScreenMemory() {
		return screenMemory;
	}

	public void setScreenMemory(StackU<Integer> screenMemory) {
		this.screenMemory = screenMemory;
	}

	
	
	
	
	
}
