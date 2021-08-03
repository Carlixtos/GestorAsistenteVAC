package data;
import gest.Funcionario;
import gest.Paciente;
import util.AVL;
import util.LinkedListU;
import util.NodeU;


public class funcionariosData {
	
	public AVL<Funcionario> funcionarios;
	
	public funcionariosData(){
		this.funcionarios =new AVL<Funcionario>();
	}

		
		
	public void agregar(String[] f) {
		int[][] a = new int[1][1];
		a[0][0]=Integer.valueOf(f[8]);
		Funcionario funcionario=new Funcionario(f[0],f[1], Integer.valueOf(f[2]),f[3], f[4],Integer.valueOf(f[5]), f[6],f[7],a);
		this.funcionarios.insert(Integer.valueOf(f[5]),funcionario);
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
	}
	
	
	
	public void vernombres() {
		this.funcionarios.printTree(this.funcionarios.getRoot(), "  ", false);
	}



	public void remplazar(String nom, String[] f) {
		this.funcionarios.delete(Integer.valueOf(nom));
		this.agregar(f);
		
	}

}
