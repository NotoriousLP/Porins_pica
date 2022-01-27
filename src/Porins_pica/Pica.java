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
	public String noteiktTipu() {
		return tips;
	}
	public String noteiktPiedevu() {
		return piedeva;
	}
	public String noteiktGarsu() {
		return garsa;
	}
	public int noteiktcm() {
		return cm;
	}
	public double noteiktCenu() {
		return cena;
	}
	public void izvaditCenu() {
		JOptionPane.showMessageDialog(null, "Picas cena, 1 gab ir "+cena);
	}
	public void izvadit() {
		JOptionPane.showMessageDialog(null,"Klienta picas tips "+tips+"\n"
				+ "Picas garša "+garsa+"\n"
				+ "Picas piedeva "+piedeva+"\n"
				+ "Picas diametrs "+cm);
	}
}