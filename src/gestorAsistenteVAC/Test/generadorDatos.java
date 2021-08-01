package gestorAsistenteVAC.Test;

import java.util.concurrent.ThreadLocalRandom;

import gestorAsistenteVAC.data.Data;
import gestorAsistenteVAC.gest.Funcionario;
import gestorAsistenteVAC.gest.Paciente;
import gestorAsistenteVAC.gest.Vacunas;
import gestorAsistenteVAC.util.ArrayDinamic;


public class generadorDatos {
	
	public generadorDatos(){
		
	}
	public void agregarPacientes(int n,Data d){
		for (int i=0;i<n;i++) {
		
			int l=this.numeroAleatorioEnRango(0,130);
			String vacuna=this.vacunaAleatoreo();
			String[] a= {	this.nombreAleatoreo(),									//nombre
							this.nombreAleatoreo(),									//apellido
							String.valueOf(l),										//edad
							this.generoAleatoreo(),									//genero
							this.documento(l),										//tipo documento
							String.valueOf(this.numeroAleatorioEnRango(1000,9990)),	//documento
							this.sangreAleatoreo(),									//tipo de sangre
							this.perfilAleatoreo(),									//perfil     								
							vacuna,													//tipo de vacuna
							this.dosis(vacuna)										//dosis	                     
		            
			};
			d.paciente.agregar(a);
			
		}
		
	}
	public void agregarFuncionarios(int n,Data d){
		for (int i=0;i<n;i++) {
		
			int l=this.numeroAleatorioEnRango(0,130);
			String[] a= {	this.nombreAleatoreo(),									//nombre
							this.nombreAleatoreo(),									//apellido
							String.valueOf(l),										//edad
							this.generoAleatoreo(),									//genero
							this.documento(l),										//tipo documento
							String.valueOf(this.numeroAleatorioEnRango(1000,9990)),	//documento
							this.sangreAleatoreo(),									//tipo de sangre
							this.perfilAleatoreo(),									//perfil     								
							this.hoararioAleatoreo()        						//horario
		            
			};
			d.funcionario.agregar(a);
			
		}
		
	}
	
	public void eliminarPacientes(int l, Data datos) {
		for (int i = l-1;i>0;i--) {
			datos.paciente.pacientes.delete(datos.paciente.pacientes.getRoot().getKey());
		}
	}
	public void eliminarFuncionarios(int l, Data datos) {
		for (int i = l-1;i>=0;i--) {	
			datos.funcionario.funcionarios.delete(datos.funcionario.funcionarios.getRoot().getKey());
		}
	}
	public void remplazarPacientes(int l, Data datos) {
		for (int i = l-1;i>=0;i--) {	
			Paciente p= new Paciente("cronos", "jupiter", i, "Dios", "inmortal", i, "celestial", "Creador", "todas", i);
		//	datos.paciente.pacientes.keyReplace(datos.paciente.pacientes.nodeConsult(i), p);
		}
		
	}
	public void remplazarFuncionarios(int l, Data datos) {
		for (int i = l-1;i>=0;i--) {	
			int[][] a = new int[1][1];
			a[0][0]=i;
			Funcionario p= new Funcionario("cronos", "jupiter", i, "Dios", "inmortal", i, "celestial", "Creador", a);
			//datos.funcionario.funcionarios.keyReplace(datos.funcionario.funcionarios.nodeConsult(i), p);
		}
		
	}
	public void agregarVacunas(int l, Data datos) {
		for (int i =0;i<l;i++) {
			String a = this.vacunaAleatoreo();
			datos.vacunas.agregar(a,1);
		}
	}
	public void eliminarVacunas(int l, Data datos) {
		for (int i =0;i<l;i++) {
			datos.vacunas.eliminar(1);
		}
	}
	public void buscarFuncionarios(int num, Data datos) {
		for (int i=0;i<num;i++) {
			datos.funcionario.funcionarios.find(num);
		}
		
	}
	public void buscarPacientes(int num, Data datos) {
		for (int i=0;i<num;i++) {
			datos.paciente.pacientes.find(i);
		}
		
	}
	
	
	
	
	//datos aleatoreos
	private String documento(int l) {
		String documento;
		if(l<18) {
			documento="Tarjeta de identidad";
		}
		else {
			documento="Cedula";
		}
		
		return documento;
	}
	public String nombreAleatoreo() {
        
		
        String[] banco = {"Zeus", "Hera", "Poseidón", "Ares", "Hermes", "Hefesto", "Afrodita", "Atenea", "Apolo" , "Artemisa"," Hestia"," Deméter", "Dioniso", "Hades", "Perséfone", "Hebe"," Asclepio", "Eros"," Pan ", "Heracles"};
      
        return banco[this.numeroAleatorioEnRango(0, banco.length)];
    }
	public String generoAleatoreo() {
		ArrayDinamic<String> banco =new ArrayDinamic();
        banco.pushback("hombre");
        banco.pushback("mujer");
      
        return banco.remove(this.numeroAleatorioEnRango(0,1));
    }
	public String sangreAleatoreo() {
        
        String[] banco = {"A+" ,"A-","B+" ,"B-","O+" ,"O-","AB+" ,"AB-"};
      
        return banco[this.numeroAleatorioEnRango(0, banco.length)];
    }
	public String perfilAleatoreo() {
        
        String[] banco = {"Administrador" ,"Funcionario","Paciente"};
      
        return banco[this.numeroAleatorioEnRango(0, banco.length)];
    }
	public String vacunaAleatoreo() {
        
        String[] banco = {"Pzifer" ,"Moderna","Janssen"};
      
        return banco[this.numeroAleatorioEnRango(0, banco.length)];
    }
    private String dosis(String l) {
		String dosis;
		if(l.equals("Pzifer")|| l.equals("Moderna")) {
			dosis="2";
		}
		else {
			dosis="1";
		}
		
		return dosis;
	}
    public String hoararioAleatoreo() {
        
        String[] banco = {"1" ,"2","3","4","5","6"};
      
        return banco[this.numeroAleatorioEnRango(0, banco.length)];
    }
    
    public int numeroAleatorioEnRango(int minimo, int maximo) {
  
        return ThreadLocalRandom.current().nextInt(minimo, maximo);
    }
	
	
	
	
}
	

