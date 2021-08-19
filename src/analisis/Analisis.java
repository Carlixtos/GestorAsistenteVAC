package analisis;

import gest.Paciente;
import util.MapIntU;
import util.LinkedListU;
import util.NodeU;

public class Analisis {
	
	public static  int[] pacSexo(MapIntU<Paciente> vPerfiles, LinkedListU<Integer> vIds) {
		int[] vacSexo = {0,0}; // vacSexo[0]--> mujer, vacSexo[1]--> hombre
		NodeU currId = vIds.getHead();
		
		while(currId != null) {
			if(vPerfiles.get((int)currId.getKey()).getGenero().equals("mujer")) {
				vacSexo[0] += 1;
			}
			
			else {
				vacSexo[1] += 1;
			}
			
			currId = currId.getNext();
		}
		
		return vacSexo;	
	}
	
	/* Ambos metodos los puede usar para contar ya sea los pacientes vacunados
	 *  o no vacunados, estos metodos estaticos requieren el mapa hash y la
	 *  lista enlazada de numeros de identificación.
	 */
	
	public static int[] pacEdades(MapIntU<Paciente> vPerfiles, LinkedListU<Integer> vIds) {
		int[] vacEdades = {0,0,0,0,0,0}; // [0]-->12-30, [1]-->30-45, [2]-->45-55
										 // [3]-->55-65, [4]-->65-75, [5]--> edad>75
		NodeU currId = vIds.getHead();
		Paciente currP;
		
		while(currId != null) {
			currP = vPerfiles.get((int)currId.getKey());
			
			if(75<currP.getEdad()) {
				vacEdades[5]+=1;
			}
			
			else if(currP.getEdad()<=75 && 65<currP.getEdad()) {
				vacEdades[4]+=1;
			}
			
			else if(currP.getEdad()<=65 && 55<currP.getEdad()) {
				vacEdades[3]+=1;
			}
			
			else if(currP.getEdad()<=55 && 45<currP.getEdad()) {
				vacEdades[2]+=1;
			}
			
			else if(currP.getEdad()<=45 && 30<currP.getEdad()) {
				vacEdades[1]+=1;
			}
			
			else if(currP.getEdad()<=30 && 12<=currP.getEdad()) {
				vacEdades[0]+=1;
			}
			
			currId = currId.getNext();
		}
		
		return vacEdades;
		
	}
}
