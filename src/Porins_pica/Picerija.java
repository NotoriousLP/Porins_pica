package Porins_pica;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Picerija {
	static Klients[] klientuNaksana(Klients[] masivs) {
		boolean sutitMajas;
		int cm;
		double cena=0;
		String tips;
		for(int i=0; i<masivs.length; i++) {
		String vards =  JOptionPane.showInputDialog("Klienta vārds");
		String uzvards =  JOptionPane.showInputDialog("Klienta uzvārds");
		String telefons =  JOptionPane.showInputDialog("Klienta telefona numurs");
		String Adrese =  JOptionPane.showInputDialog("Klienta adrese");
		String sutaMajas = JOptionPane.showInputDialog("Vai klients sūta mājas | Jā vai nē|");
		sutaMajas = sutaMajas.toLowerCase();
		if(sutaMajas.equals("jā")) {
			 sutitMajas = true;
		}else {
			sutitMajas = false;
		}
		tips = JOptionPane.showInputDialog("Kādu kontūru picai dosi? - Kvadrāts || Apaļš");
		tips = tips.toLowerCase();
		if(tips.equals("kvadrāts")) {
			cena = cena+0.70;
		}else if(tips.equals("apaļš")) {
			cena = cena+0.50;
		}
		String garsa = JOptionPane.showInputDialog("Kādu garša picai būs? - Siers | Gaļa | Sēnes");
		garsa = tips.toLowerCase();
		if(garsa.equals("siers")) {
			cena = cena+0.42;
		}else if(garsa.equals("gaļa")) {
			cena = cena+0.94;
		}else if(garsa.equals("sēnes")) {
			cena = cena+1.42;
		}
		String piedeva = JOptionPane.showInputDialog("Kādas piedevas picai būs? - Kečups | Majonēze | Sīpoli");
		piedeva = tips.toLowerCase();
		if(piedeva.equals("kečups")) {
			cena = cena+0.22;
		}else if(piedeva.equals("majonēze")) {
			cena = cena+0.14;
		}else if(piedeva.equals("sīpoli")) {
			cena = cena+0.52;
		}
		do {
		cm = Integer.parseInt(JOptionPane.showInputDialog("Picas diametrs - 10|20|30|50"));	
		if(cm==10) {
			cena = cena+0.70;
		}else if(cm==20) {
			cena = cena+1.00;
		}else if(cm==30) {
			cena = cena+1.70;
		}else if(cm==50) {
			cena = cena+2.70;
		}
		}while(cm<10 || cm>50);
		
		masivs[i] = new Klients(vards,uzvards,telefons,Adrese,sutitMajas,tips,garsa,piedeva,cm,cena);
		}
		return masivs;
	}
	public static double izrekinasana(double cena, double skaits, double piegade) {
		cena = (cena*skaits);
		cena = cena+piegade;
		System.out.println(cena);
		return cena;
	}
	
	public static void main(String[] args) {
		String izvele;
		JFrame fr= new JFrame();
		Pica[] picasMasivs = null;
		Klients[] klientuMasivs = null;
		double cena=0;
		double istaCena=0;
		double brauksanasCena=0;
		int skaits;
		do {
			izvele = JOptionPane.showInputDialog("1-Klienta pica | 2-Sūtišana | 3-Saglabāt datus failā |stop - Programmas beigas");
			izvele = izvele.toLowerCase();
			switch(izvele) {
			case "1":
				try {
				skaits = Integer.parseInt(JOptionPane.showInputDialog("Klientu skaits, kuri vēlas picu"));
				klientuMasivs = new Klients[skaits];
				klientuMasivs = klientuNaksana(klientuMasivs);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(fr, "Darbība nepastāv!", "Kļūme",JOptionPane.ERROR_MESSAGE); 
				}
				break;
			case "2":
				String klientaVards = JOptionPane.showInputDialog("Ievadi Klienta vārdu: ");
				for(int i=0; i<klientuMasivs.length; i++) {
					if(klientaVards.equals(klientuMasivs[i].nosakaVardu())){
						cena = klientuMasivs[i].noteiktCenu();
						brauksanasCena = klientuMasivs[i].jaSutaMajas();
						double picuSkaits = Integer.parseInt(JOptionPane.showInputDialog("Cik šāda veida picas sūtis?"));
						System.out.println(cena);
						istaCena = izrekinasana(cena, picuSkaits, brauksanasCena);
						System.out.println(istaCena);
					}
				}
				break;
			case "3":
				
				break;
			case "stop": JOptionPane.showMessageDialog(fr, "Programma apturēta!", "Brīdinājums",JOptionPane.WARNING_MESSAGE); break;
			default: JOptionPane.showMessageDialog(fr, "Darbība nepastāv!", "Kļūme",JOptionPane.ERROR_MESSAGE); 
			}
		}while(!izvele.equals("stop"));
	}

}
