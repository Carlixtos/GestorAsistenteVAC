package gestorAsistenteVAC.interfaz;

import gestorAsistenteVAC.Test.generadorDatos;
import gestorAsistenteVAC.data.Data;
import gestorAsistenteVAC.data.Profile;
import gestorAsistenteVAC.gest.Funcionario;
import gestorAsistenteVAC.gest.Paciente;
import gestorAsistenteVAC.gest.Vacunas;
import gestorAsistenteVAC.util.ArrayDinamic;
import gestorAsistenteVAC.util.NodeA;
import gestorAsistenteVAC.util.NodeU;
import gestorAsistenteVAC.util.StackU;

public class asistenteInterfaz {
	
	private StackU<Integer> screenMemory;
	private interfazGrafica acceso;
	private admin admin;
	private adminPacientes aPaci;
	private adminFuncionarios aFun;
	private adminVacunas aVac;
	private Pruebasmenu tMenu;
	private Pruebasiteradas tIterado;
	private PruebasDatos tDatos;
	private Data datos;
	private generadorDatos gen;
	
	
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
		tIterado= new Pruebasiteradas(this);
		tDatos=new PruebasDatos(this);
		tMenu= new Pruebasmenu(this);
		gen= new generadorDatos();
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
					aPaci.actualizar();
					break;
				}
				case 12:{
					aFun.setVisible(true);
					aFun.actualizar();
					break;
				}
				case 13:{
					aVac.setVisible(true);
					break;
				}
				case 4:{
					tMenu.setVisible(true);
					break;
				}
				case 41:{
					tIterado.setVisible(true);
					break;
				}
				case 42:{
					tDatos.setVisible(true);
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
		tIterado.setVisible(false);
		tMenu.setVisible(false);
		tDatos.setVisible(false);
		
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
		
		/*inOrderPrintAux(root.getLeft());
		System.out.print(root.getKey()+" ");
		inOrderPrintAux(root.getRight());*/
		String[][] tabla = new String[datos.paciente.pacientes.aproxLength(datos.paciente.pacientes.getRoot())][10];
		int n=0;
		auxGetdatosPacientes(datos.paciente.pacientes.getRoot(),tabla,n);
		return tabla;	
	}
	private int auxGetdatosPacientes(NodeA<Paciente> root, String[][] tabla,int n) {
		
    	if(root.getLeft()!=null){
    		//n++;
    		n=auxGetdatosPacientes(root.getLeft(),tabla,n);
    		}
    	if(root.getRight()!=null){
    		//n++;
    		n=auxGetdatosPacientes(root.getRight(),tabla,n);
    		}
    	n=guardarDatosPacientes(root.getValue(),tabla,n);
    	return n;
		
	}	
	private int guardarDatosPacientes(Paciente paciente, String[][] tabla,int n) {
		tabla[n][0]=paciente.getNombre();
		tabla[n][1]=paciente.getApellido();
		tabla[n][2]=String.valueOf(paciente.getEdad());
		tabla[n][3]=paciente.getGenero();
		tabla[n][4]=paciente.getTipoDocumento();
		tabla[n][5]=String.valueOf(paciente.getDocumento());
		tabla[n][6]=paciente.getSangre();
		tabla[n][7]=paciente.getPerfil();
		tabla[n][8]=paciente.getTipoVacuna();
		tabla[n][9]=String.valueOf(paciente.getDosis());
		n++;
		return n;
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
	public void modificarPacientes(String nom, String[] nDatos) {
		if(datos.paciente.existe(nom)) {
			datos.paciente.remplazar(nom,nDatos);
		}
	}
	public void eliminarPacientes(String elim) {
		if(datos.paciente.existe(elim)) {
			datos.paciente.eliminar(elim);
			}
		
	}
	public Vacunas getVacuanas() {
		
		return datos.vacunas.vacunas.getHead().getKey();
	}
	public int TfuncionariosAgregar(int num) {

		long tiempoinicio = System.currentTimeMillis();
		this.gen.agregarFuncionarios(num, this.datos);
		long tiempofinal = System.currentTimeMillis();
		int tiempoTotal=(int) (tiempofinal-tiempoinicio);
		System.out.println(tiempoTotal);
		return tiempoTotal;
	}
	public int TpacientesAgregar(int num) {
		long tiempoinicio = System.currentTimeMillis();
		this.gen.agregarPacientes(num, this.datos);
		long tiempofinal = System.currentTimeMillis();
		int tiempoTotal=(int) (tiempofinal-tiempoinicio);
		System.out.println(tiempoTotal);
		return tiempoTotal;
		
	}
	public int TpacientesEliminar(int num) {
		long tiempoinicio = System.currentTimeMillis();
		this.gen.eliminarPacientes(num, this.datos);
		long tiempofinal = System.currentTimeMillis();
		int tiempoTotal=(int) (tiempofinal-tiempoinicio);
		System.out.println(tiempoTotal);
		return tiempoTotal;
	}
	public int TfuncionariosEliminar(int num) {
		long tiempoinicio = System.currentTimeMillis();
		this.gen.eliminarFuncionarios(num, this.datos);
		long tiempofinal = System.currentTimeMillis();
		int tiempoTotal=(int) (tiempofinal-tiempoinicio);
		System.out.println(tiempoTotal);
		return tiempoTotal;
	}
	public Paciente buscarPaciente(int num) {
		try {
		return datos.paciente.pacientes.find(num).getValue();
		}
		catch(NullPointerException e){
			return null;
		}
		
		
	}
	public Funcionario buscarFuncionario(int num) {
		return datos.funcionario.searchCedula(num);
	}
	public int TpacientesBuscar(int num) {
		long tiempoinicio = System.currentTimeMillis();
		this.buscarPaciente(num);
		long tiempofinal = System.currentTimeMillis();
		int tiempoTotal=(int) (tiempofinal-tiempoinicio);
		System.out.println(tiempoTotal);
		return tiempoTotal;
	}
	public int TfuncionariosBuscar(int num) {
		long tiempoinicio = System.currentTimeMillis();
		this.buscarFuncionario(num);
		long tiempofinal = System.currentTimeMillis();
		int tiempoTotal=(int) (tiempofinal-tiempoinicio);
		System.out.println(tiempoTotal);
		return tiempoTotal;
	}
	public int TestpacientesBuscar(int num) {
		long tiempoinicio = System.currentTimeMillis();
		this.gen.buscarPacientes(num,this.datos);
		long tiempofinal = System.currentTimeMillis();
		int tiempoTotal=(int) (tiempofinal-tiempoinicio);
		System.out.println(tiempoTotal);
		return tiempoTotal;
	}
	public int TestfuncionariosBuscar(int num) {
		long tiempoinicio = System.currentTimeMillis();
		this.gen.buscarFuncionarios(num,this.datos);
		long tiempofinal = System.currentTimeMillis();
		int tiempoTotal=(int) (tiempofinal-tiempoinicio);
		System.out.println(tiempoTotal);
		return tiempoTotal;
	}
	
	

	
	
}