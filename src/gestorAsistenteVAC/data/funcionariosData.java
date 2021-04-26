package gestorAsistenteVAC.data;
import gestorAsistenteVAC.gest.Funcionario;
import gestorAsistenteVAC.util.LinkedListU;


public class funcionariosData {
	
	public LinkedListU<Funcionario> funcionarios;
	
		public funcionariosData(){
			this.funcionarios =new LinkedListU<Funcionario>();
		}

		public void agregarf(String[] f) {
			int[][] a = new int[1][1];
			a[0][0]=Integer.valueOf(f[8]);
			Funcionario funcionario=new Funcionario(f[0],f[1], Integer.valueOf(f[2]),f[3], f[4],Integer.valueOf(f[5]), f[6],f[7],a);
			this.funcionarios.addFront(funcionario);
		}

		public boolean existe(String nombre) {
			for (int i = 0;i<this.funcionarios.getLength();i++) {
				if(this.funcionarios.nodeConsult(i).getNombre().equals(nombre)) {;
					return true;
				}
			}
			return false;
		}

		public void eliminarf(String elim) {
			for (int i = 0;i<this.funcionarios.getLength();i++) {
				if(this.funcionarios.nodeConsult(i).getNombre().equals(elim)) {;
					this.funcionarios.nodeDrop(this.funcionarios.nodeConsult(i));
					break;
				}
			}	
		}
		public void vernombres() {
			for (int i = 0;i<this.funcionarios.getLength();i++) {
				System.out.print("\t\t"+funcionarios.nodeConsult(i).getNombre()+"\t\t");
			}
		}

		
}
