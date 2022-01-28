package Porins_pica;

import javax.swing.JOptionPane;

public class Pica{
	//Atribūti
	public String tips;
	public String garsa;
	public String piedeva;
	public int cm;
	public double cena;
	double skaits;
	public Pica(String picaTips, String picasGarsa, String picaPiedeva, int picascm, double picasCena) {
		this.tips = picaTips;
		this.garsa = picasGarsa;
		this.piedeva = picaPiedeva;
		this.cm = picascm;
		this.cena = picasCena;
	}
	//Metodes

	public String nomainitTipu(String jaunsTips) {
		if(tips.equals("kvadrāts")) {
			cena = cena+0.70;
		}else if(tips.equals("apaļš")) {
			cena = cena+0.50;
		}
		tips = jaunsTips;
		return tips;
	}
	public String nomainitPiedevu(String jaunaPiedeva) {
		if(garsa.equals("siers")) {
			cena = cena+0.42;
		}else if(garsa.equals("gaļa")) {
			cena = cena+0.94;
		}else if(garsa.equals("sēnes")) {
			cena = cena+1.42;
		}
		piedeva = jaunaPiedeva;
		return piedeva;
	}
	public String nomainitGarsu(String jaunaGarsa) {
		if(piedeva.equals("kečups")) {
			cena = cena+0.22;
		}else if(piedeva.equals("majonēze")) {
			cena = cena+0.14;
		}else if(piedeva.equals("sīpoli")) {
			cena = cena+0.52;
		}
		garsa = jaunaGarsa;
		return garsa;
	}
	public int nomainitcm(int jaunsCm) {
		if(cm==10) {
			cena = cena+0.70;
		}else if(cm==20) {
			cena = cena+1.00;
		}else if(cm==30) {
			cena = cena+1.70;
		}else if(cm==40) {
			cena = cena+2.00;
		}else if(cm==50) {
			cena = cena+2.70;
		}
		cm = jaunsCm;
		return cm;
	}
	public double jaunaCena(double jaunaCena) {
		cena = jaunaCena;
		return cena;
	}
	public double noteiktCenu() {
		return cena;
	}
	public void izvadit() {
		JOptionPane.showMessageDialog(null,"Klienta picas tips "+tips+"\n"
				+ "Picas garša "+garsa+"\n"
				+ "Picas piedeva "+piedeva+"\n"
				+ "Picas diametrs "+cm);
	}
}