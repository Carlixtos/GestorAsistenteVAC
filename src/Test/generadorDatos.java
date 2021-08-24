package Test;

import java.util.concurrent.ThreadLocalRandom;

import data.Data;
import gest.Funcionario;
import gest.Paciente;
import gest.Vacunas;
import util.ArrayDinamic;


public class generadorDatos {
	
	public generadorDatos(){
		
	}
	public void agregarPacientes(int n,Data d){
		for (int i=0;i<n;i++) {
		
			int l=this.numeroAleatorioEnRango(12,122);
			String[] a= {	this.nombreAleatoreo(),										//nombre
							this.nombreAleatoreo(),										//apellido
							String.valueOf(l),											//edad
							this.generoAleatoreo(),										//genero
							this.documento(l),											//tipo documento
							String.valueOf(this.numeroAleatorioEnRango(100000,999000)),	//documento
							this.sangreAleatoreo(),										//tipo de sangre
							this.perfilAleatoreo(),										//perfil
							this.enfeAleatoreo()										//tiene alguna enfermedad
			};
			
			d.paciente.agregar(a,d.funcionario.funcionarioDisponible(),d.vacunas.eliminar(1));
			
		}
		
	}

	public void agregarFuncionarios(int n,Data d){
		for (int i=0;i<n;i++) {
		
			int l=this.numeroAleatorioEnRango(12,122);
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
		Paciente paci ;
		for (int i = l-1;i>=0;i--) {
			paci= datos.paciente.getMax();
			if(paci!=null && datos.paciente.getCantidad()>0) {
			datos.paciente.eliminar(String.valueOf(paci.getDocumento()));
			}
			
		}
	}
	public void eliminarFuncionarios(int l, Data datos) {
		for (int i = l-1;i>=0;i--) {	
			if(datos.funcionario.getCantidad()>0) {
			datos.funcionario.eliminar(String.valueOf(datos.funcionario.getMin().getDocumento()));
			}
		}
	}
	public void remplazarPacientes(int l, Data datos) {
		for (int i = l-1;i>=0;i--) {	
			String[] f = datos.funcionario.funcionarioDisponible();
			Paciente p= new Paciente("cronos", "jupiter", i, "Dios", "inmortal", i, "celestial", "Paciente",(i%2==0), "todas", i,Integer.valueOf(f[0]),Integer.valueOf(f[1]),f[2]);
		//	datos.paciente.pacientes.keyReplace(datos.paciente.pacientes.nodeConsult(i), p);
		}
		
	}
	public void remplazarFuncionarios(int l, Data datos) {
		for (int i = l-1;i>=0;i--) {	
			Funcionario p= new Funcionario("cronos", "jupiter", i, "Dios", "inmortal", i, "celestial", "Creador");
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
			datos.paciente.pPerfiles.get(i);
		}
		
	}
	
	
	
	
	//datos aleatoreos
	
	private String enfeAleatoreo() {
		String[] banco = {"true", "false"};
	      
        return banco[this.numeroAleatorioEnRango(0, banco.length)];
	}
	
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
      
        return banco.remove(this.numeroAleatorioEnRango(0,2));
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
        
        String[] banco = {"pfizer" ,"moderna","janssen",};
        
      
       
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
	

