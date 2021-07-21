package gestorAsistenteVAC.data;
import gestorAsistenteVAC.gest.Funcionario;
import gestorAsistenteVAC.util.LinkedListU;
import gestorAsistenteVAC.util.NodeU;


public class funcionariosData {
	
	public LinkedListU<Funcionario> funcionarios;
	
	public funcionariosData(){
		this.funcionarios =new LinkedListU<Funcionario>();
	}

		
		
	public void agregar(String[] f) {
		int[][] a = new int[1][1];
		a[0][0]=Integer.valueOf(f[8]);
		Funcionario funcionario=new Funcionario(f[0],f[1], Integer.valueOf(f[2]),f[3], f[4],Integer.valueOf(f[5]), f[6],f[7],a);
		this.funcionarios.addFront(funcionario);
	}



	public boolean existe(String nombre) {
		NodeU<Funcionario> aux = this.funcionarios.getHead();
		for (int i = 0;i<this.funcionarios.getLength();i++) {
			if(aux.getKey().getNombre().equals(nombre)) {
				return true;
			}
			aux=aux.getNext();
		}
		return false;
	}
	
	
	
	public void eliminar(String elim) {
		NodeU<Funcionario> aux = this.funcionarios.getHead();
		for (int i = 0;i<this.funcionarios.getLength();i++) {
			if(aux.getKey().getNombre().equals(elim))  {
				this.funcionarios.nodeDrop(aux.getKey());
				break;
			}
			aux=aux.getNext();
		}	
	}
	
	
	
	public void vernombres() {
		NodeU<Funcionario> aux = this.funcionarios.getHead();
		for (int i = 0;i<this.funcionarios.getLength();i++) {
			System.out.print("\t\t"+aux.getKey().getNombre()+"\t\t");
			aux=aux.getNext();
		}
		System.out.println(" ");
	}



	public void remplazar(String nom, String[] f) {
		int[][] a = new int[1][1];
		a[0][0]=Integer.valueOf(f[8]);
		Funcionario funcionario=new Funcionario(f[0],f[1], Integer.valueOf(f[2]),f[3], f[4],Integer.valueOf(f[5]), f[6],f[7],a);
		NodeU<Funcionario> aux = this.funcionarios.getHead();
		for (int i = 0;i<this.funcionarios.getLength();i++) {
			if(aux.getKey().getNombre().equals(nom))  {
				this.funcionarios.keyReplace(aux.getKey(), funcionario);
				break;
			}
			aux=aux.getNext();
		}	
		
		
	}



	public Funcionario searchCedula(int num) {
		NodeU<Funcionario> aux = this.funcionarios.getHead();
		for (int i = 0;i<this.funcionarios.getLength();i++) {
			if(aux.getKey().getDocumento()==(num)) {
				return aux.getKey();
			}
			aux=aux.getNext();
		}
		return null;
	}

		
}
