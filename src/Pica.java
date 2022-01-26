
public class Pica{
	//Atribūti
	public String tips;
	public String piedeva;
	public double cena;
	double skaits;
	public Pica(String picaTips, String picaPiedeva, double picaCena) {
		this.tips = picaTips;
		this.piedeva = picaPiedeva;
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