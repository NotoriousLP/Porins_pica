
public class Klients extends Pica {
	//Atribūti
	public String vards;
	public String uzvards;
	public String telefons;
	public String Adrese;
	public boolean vaiSutaMajas;
	public Klients(String klientaVards, String klientaUzvards, String klientaTelefons, String klientaAdrese, boolean vaiKlientsSutaMajas, String picaTips, String picaPiedeva, double picaCena) {
		super(picaTips,picaPiedeva,picaCena);
		this.vards = klientaVards;
		this.uzvards = klientaUzvards;
		this.telefons = klientaTelefons;
		this.Adrese = klientaAdrese;
		this.vaiSutaMajas = vaiKlientsSutaMajas;
	}
}
