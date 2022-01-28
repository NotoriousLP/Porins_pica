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
		tips = jaunsTips;
		return tips;
	}
	public String nomainitPiedevu(String jaunaPiedeva) {
		piedeva = jaunaPiedeva;
		return piedeva;
	}
	public String nomainitGarsu(String jaunaGarsa) {
		garsa = jaunaGarsa;
		return garsa;
	}
	public int nomainitcm(int jaunsCm) {
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