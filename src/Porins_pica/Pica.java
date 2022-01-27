package Porins_pica;
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

	public double vairakasPicas(double cena) {
		skaits = skaits * cena;
		return skaits;
	}
	public double noteiktCenu() {
		return cena;
	}
}