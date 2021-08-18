package gest;

import util.KeysU;
import util.MapIntU;

public class Funcionario extends Perfiles{
	private int[][] horario;
	private int dias;

	public Funcionario(String nombre, String apellido, int edad, String genero, String tDocumento, int documento,
			String sangre, String perfil) {
		super(nombre, apellido, edad, genero, tDocumento, documento, sangre, perfil);

		this.horario=new int[1000][50];
		this.dias=0;
	}

	public int[][] getHorario() {
		return horario;
	}

	public void setHorario(int[][] horario) {
		this.horario = horario;
	}
	public int getDias() {
		return dias;
	}

	public void setDias(int dia) {
		this.dias = dia;
	}
	
	
	public int diaDisponible() {
		int indice=0;
		int año=(int) (Math.floor(this.dias/365));
		int mes=(int) (Math.floor(this.dias/30));
		dias-=año*365;
		dias-=mes*30;
		indice +=año*10000;
		indice +=mes*100;
		indice +=(this.dias);
		return (indice+20210901);
	}
	public int horaDisponible() {
		
		while(this.dias>=0) {
			for(int i =0;i<50;i++) {
				if(horario[this.dias][i]!=1) {
					horario[this.dias][i]=1;
					return	i;			
				}
			}
			this.dias++;
		}
		return (Integer) null;
	}
	

}
