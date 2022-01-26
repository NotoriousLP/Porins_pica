
public class Pica{
	//Atribūti
	public String tips;
	public String garsa;
	public String piedeva;
	public double cena;
	public int cm;
	double skaits;
	public Pica(String picaTips, String picasGarsa, String picaPiedeva, int picascm, double picaCena) {
		this.tips = picaTips;
		this.garsa = picasGarsa;
		this.piedeva = picaPiedeva;
		this.cm = picascm;
		this.cena = picaCena;
	}
	//Metodes
	public String noteiktTipu(String tips) {
		return tips;
	}
	public String noteiktPiedevu(String piedeva) {
		return piedeva;
	}
	public double noteiktCenu(double cena) {
		return cena;
	}
	public double vairakasPicas(double cena) {
		skaits = skaits * cena;
		return skaits;
	}
}