package Porins_pica;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Klients extends Pica {
	//Atribūti
	public String vards;
	public String uzvards;
	public String telefons;
	public String Adrese;
	public boolean vaiSutaMajas;
	double majasPiegadesCena;
	//Konstruktors
	public Klients(String klientaVards, String klientaUzvards, String klientaTelefons, String klientaAdrese, boolean vaiKlientsSutaMajas, String picaTips, String picasGarsa, String picaPiedeva, int picascm, double picasCena) {
		super(picaTips, picasGarsa, picaPiedeva, picascm, picasCena);
		this.vards = klientaVards;
		this.uzvards = klientaUzvards;
		this.telefons = klientaTelefons;
		this.Adrese = klientaAdrese;
		this.vaiSutaMajas = vaiKlientsSutaMajas;
	}
	//Metodes
	public boolean vaiSutaMajas() {
		return vaiSutaMajas;
	}
	public String nosakaVardu() {
		return vards;
	}
	public double jaSutaMajas() {
		if(vaiSutaMajas == true) {
			 majasPiegadesCena = 5.73;
		}
		return majasPiegadesCena;
	}
	public void izvadit() {
		JOptionPane.showMessageDialog(null, "Klienta vārds "+vards+"\n"
				+ "Klienta uzvārds "+uzvards+"\n"
				+ "Klienta telefona numurs "+telefons+"\n"
				+ "Klienta adrese "+Adrese+"\n"
				+ "Klienta picas tips "+tips+"\n"
				+ "Picas garša "+garsa+"\n"
				+ "Picas piedeva "+piedeva+"\n"
				+ "Picas diametrs "+cm
				+ "Picas cena pa 1 gabalu ir "+cena+" eur");
	}

	public void saglabatFaila() {
		try{
			FileWriter fw = new FileWriter("pica.txt", true);
			PrintWriter raksta = new PrintWriter(fw);
			raksta.print("Klienta vārds "+vards+"\n"
					+ "Klienta uzvārds "+uzvards+"\n"
					+ "Klienta telefona numurs "+telefons+"\n"
					+ "Klienta adrese "+Adrese+"\n"
					+ "Klienta picas tips "+tips+"\n"
					+ "Picas garša "+garsa+"\n"
					+ "Picas piedeva "+piedeva+"\n"
					+ "Picas diametrs "+cm+"\n");
			raksta.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Kļūda  ierakstot faila, ","Kļūda ",JOptionPane.ERROR_MESSAGE);
		}
	
	}
}
