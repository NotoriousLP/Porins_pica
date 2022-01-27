

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
		super(picaTips, picasGarsa, picaPiedeva, picascm,picasCena);
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

	
	
}
