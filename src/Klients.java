
public class Klients {
	//Atribūti
	public String vards;
	public String uzvards;
	public String telefons;
	public String Adrese;
	public boolean vaiSutaMajas;
	double majasPiegadesCena;
	//Konstruktors
	public Klients(String klientaVards, String klientaUzvards, String klientaTelefons, String klientaAdrese, boolean vaiKlientsSutaMajas) {
		this.vards = klientaVards;
		this.uzvards = klientaUzvards;
		this.telefons = klientaTelefons;
		this.Adrese = klientaAdrese;
		this.vaiSutaMajas = vaiKlientsSutaMajas;
	}
	//Metodes
	public boolean vaiSutaMajas(boolean vaiSutaMajas) {
		return vaiSutaMajas;
	}
	public String nosakaVardu(String vards) {
		return vards;
	}
	public void jaSutaMajas(boolean vaiSutaMajas) {
		if(vaiSutaMajas == true) {
			 majasPiegadesCena = 5.73;
		}
	}
	
	
}
