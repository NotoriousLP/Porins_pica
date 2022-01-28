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
	double majasPiegadesCena;
	//Konstruktors
	public Klients(String klientaVards, String klientaUzvards, String klientaTelefons, String klientaAdrese, String picaTips, String picasGarsa, String picaPiedeva, int picascm, double picasCena) {
		super(picaTips, picasGarsa, picaPiedeva, picascm, picasCena);
		this.vards = klientaVards;
		this.uzvards = klientaUzvards;
		this.telefons = klientaTelefons;
		this.Adrese = klientaAdrese;
	}
	//Metodes
	public String nosakaVardu() {
		return vards;
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
				+ "Picas cena ir "+cena+" eur");
	}

	public void saglabatFaila() {
		try{
			FileWriter fw = new FileWriter("pica.txt", true);
			PrintWriter raksta = new PrintWriter(fw);
			raksta.print("\nKlienta vārds "+vards+" \n"
					+ "Klienta uzvārds "+uzvards+" \n"
					+ "Klienta telefona numurs "+telefons+" \n"
					+ "Klienta adrese "+Adrese+" \n"
					+ "Klienta picas tips "+tips+" \n"
					+ "Picas garša "+garsa+" \n"
					+ "Picas piedeva "+piedeva+" \n"
					+ "Picas diametrs "+cm+" \n"
					+ "Picas cena "+cena+" euro\n");
			raksta.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Kļūda  ierakstot faila, ","Kļūda ",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void izvaditCenu() {
		JOptionPane.showMessageDialog(null, "Rēķins gatavs, klientam "+vards+" būs jāmaksā "+cena);
	}
}
