package gestorAsistenteVAC.interfaz;

import gestorAsistenteVAC.data.Data;
import gestorAsistenteVAC.data.Profile;
import gestorAsistenteVAC.gest.Funcionario;
import gestorAsistenteVAC.gest.Paciente;
import gestorAsistenteVAC.util.NodeU;
import gestorAsistenteVAC.util.StackU;

public class asistenteInterfaz {
	
	private StackU<Integer> screenMemory;
	private interfazGrafica acceso;
	private admin admin;
	private adminPacientes aPaci;
	private adminFuncionarios aFun;
	private adminVacunas aVac;
	private Data datos;
	
	public asistenteInterfaz(){
		this.screenMemory = new StackU<Integer>();
		this.screenMemory.push(0);
	}
	public void init(Data datos) {
		this.datos=datos;
		acceso=new interfazGrafica(this);
		admin=new admin(this);
		aPaci=new adminPacientes(this);
		aFun=new adminFuncionarios(this);
		aVac=new adminVacunas(this);
		
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
				case 11:{
					aPaci.setVisible(true);
					break;
				}
				case 12:{
					aFun.setVisible(true);
					break;
				}
				case 13:{
					aVac.setVisible(true);
					break;
				}
			}
	}
	
	public void off() {
		acceso.setVisible(false);
		admin.setVisible(false);
		aPaci.setVisible(false);
		aFun.setVisible(false);
		aVac.setVisible(false);
		
		
	}
	
	
	public void setScreen(int num) {
		this.screenMemory.push(num);
		this.run();
		
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
	public void returnScreen() {
		this.screenMemory.pop();
		this.run();
		
	}
	public void agregarPaciente(String[] paciente) {
		datos.paciente.agregar(paciente);
		
	}
	public String[][] getDatosPacientes() {
		NodeU<Paciente> n = datos.paciente.pacientes.getHead();
		String[][] tabla = new String[datos.paciente.pacientes.getLength()][10];
		int i=0;
		while(i<datos.paciente.pacientes.getLength()) {
		tabla[i][0]=n.getKey().getNombre();
		tabla[i][1]=n.getKey().getApellido();
		tabla[i][2]=String.valueOf(n.getKey().getEdad());
		tabla[i][3]=n.getKey().getGenero();
		tabla[i][4]=n.getKey().getTipoDocumento();
		tabla[i][5]=String.valueOf(n.getKey().getDocumento());
		tabla[i][6]=n.getKey().getSangre();
		tabla[i][7]=n.getKey().getPerfil();
		tabla[i][8]=n.getKey().getTipoVacuna();
		tabla[i][9]=String.valueOf(n.getKey().getDosis());
		
		n=n.getNext();
		i++;
		};
		return tabla;	
	}
	public String[][] getDatosFuncionario() {
		NodeU<Funcionario> n = datos.funcionario.funcionarios.getHead();
		String[][] tabla = new String[datos.funcionario.funcionarios.getLength()][9];
		int i=0;
		while(i<datos.funcionario.funcionarios.getLength()) {
		tabla[i][0]=n.getKey().getNombre();
		tabla[i][1]=n.getKey().getApellido();
		tabla[i][2]=String.valueOf(n.getKey().getEdad());
		tabla[i][3]=n.getKey().getGenero();
		tabla[i][4]=n.getKey().getTipoDocumento();
		tabla[i][5]=String.valueOf(n.getKey().getDocumento());
		tabla[i][6]=n.getKey().getSangre();
		tabla[i][7]=n.getKey().getPerfil();
		tabla[i][8]=String.valueOf(n.getKey().getHorario()[0][0]);
		
		n=n.getNext();
		i++;
		};
		return tabla;	
	}
	
	
	public void agregarFuncionario(String[] funcionario) {
		datos.funcionario.agregar(funcionario);
		
	}
	public void eliminarFuncionarios(String elim) {
		if(datos.funcionario.existe(elim)) {
			datos.funcionario.eliminar(elim);
			}
		
	}
	public void modificarFuncionarios(String nom, String[] nDatos) {
		if(datos.funcionario.existe(nom)) {
			datos.funcionario.remplazar(nom,nDatos);
		}
		
	}
	
	
	
	
}