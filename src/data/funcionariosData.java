package data;
import gest.*;
import util.*;



public class funcionariosData {
	
	public AVL<Funcionario> funcionarios;
	private Minheap<Integer> fPrioridad;
	
	public funcionariosData(){
		this.funcionarios =new AVL<Funcionario>();
		this.fPrioridad=new Minheap<Integer>();
	}

		
		
	public void agregar(String[] f) {
		Funcionario funcionario=new Funcionario(f[0],f[1], Integer.valueOf(f[2]),f[3], f[4],Integer.valueOf(f[5]), f[6],f[7]);
		this.funcionarios.insert(funcionario.getIntKey(),funcionario);
		this.fPrioridad.Insert(funcionario.getDias(), funcionario.getIntKey());
	}


	public boolean existe(String key) {		
		try {
		this.funcionarios.find(Integer.valueOf(key));
		return true;
		}catch(NullPointerException e) {
		return false;
		}
	}
	
	
	public void eliminar(String key) {
		this.funcionarios.delete(Integer.valueOf(key));
		this.fPrioridad.Remove(Integer.valueOf(key));
	}
	
	
	
	public void vernombres() {
		this.funcionarios.printTree(this.funcionarios.getRoot(), "  ", false);
	}



	public void remplazar(String ced, String[] f) {
		this.eliminar(ced);
		this.agregar(f);
		
	}
	public Funcionario extractMin() {
		Funcionario funcionario=this.funcionarios.find(this.fPrioridad.ExtractMin()).getValue();
		this.funcionarios.delete(funcionario.getIntKey());
		
		return funcionario;
	}


	public String[] funcionarioDisponible() {
		String fun[] = new String[3];
		try {
		Funcionario funcionario = this.getMin();
		fun[0]=String.valueOf(funcionario.horaDisponible());
		fun[1]=String.valueOf(funcionario.diaDisponible());
		fun[2]=String.valueOf(funcionario.getIntKey());
		}catch(NullPointerException e) {
		fun[0]="-1";
		fun[1]="-1";
		fun[2]=" No hay Funcionarios disponibles ";
		}
		return fun;
	}



	public Funcionario getMin() {
		return this.funcionarios.find(this.fPrioridad.getMin()).getValue();
	}
	public int getCantidad() {
		return this.fPrioridad.getSize();
	}

}
