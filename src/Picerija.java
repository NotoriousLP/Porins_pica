import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Picerija {
	/*static Pica[] izveidotPicu(Pica[] masivs) {
		int cm;
		for(int i=0; i<masivs.length; i++) {
			String tips = JOptionPane.showInputDialog("Kādu kontūru picai dosi?");
			String garsa = JOptionPane.showInputDialog("Kādu garša picai būs?");
			String piedeva = JOptionPane.showInputDialog("Kādas piedevas picai būs?");
			do {
			cm = Integer.parseInt(JOptionPane.showInputDialog("Picas diametrs"));	
			}while(cm<10 || cm>50);
			double cena = Double.parseDouble(JOptionPane.showInputDialog("Kāda būs šis picas cena"));
			masivs[i] = new Pica(tips,garsa,piedeva,cm,cena);
			}
		return masivs;
	}*/
	static Klients[] klientuNaksana(Klients[] masivs) {
		boolean sutitMajas;
		int cm;
		double cena;
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
		String tips = JOptionPane.showInputDialog("Kādu kontūru picai dosi?");
		String garsa = JOptionPane.showInputDialog("Kādu garša picai būs?");
		String piedeva = JOptionPane.showInputDialog("Kādas piedevas picai būs?");
		do {
		cm = Integer.parseInt(JOptionPane.showInputDialog("Picas diametrs"));	
		}while(cm<10 || cm>50);
		do {
		cena = Double.parseDouble(JOptionPane.showInputDialog("Kāda būs šis picas cena"));
		}while(cena<0 || cena>20);
		}
		return masivs;
	}
	
	public static void main(String[] args) {
		String izvele;
		JFrame fr= new JFrame();
		Pica[] picasMasivs = null;
		Klients[] klientuMasivs = null;
		int skaits;
		do {
			izvele = JOptionPane.showInputDialog("1-Pievienot picu | 2-Pievienot Klientu | 3- | 4- | 5-");
			switch(izvele) {
			/*case "1":
				try {
					skaits = Integer.parseInt(JOptionPane.showInputDialog("Cik picas veidus izveidot?"));
					picasMasivs = new Pica[skaits];
					picasMasivs = izveidotPicu(picasMasivs);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(fr, "Darbība nepastāv!", "Kļūme",JOptionPane.ERROR_MESSAGE); 
				}
				break;*/
			case "2":
				skaits = Integer.parseInt(JOptionPane.showInputDialog("Cik Klientu būs?"));
				klientuMasivs = new Klients[skaits];
				klientuMasivs = klientuNaksana(klientuMasivs);
				break;
			case "stop": JOptionPane.showMessageDialog(fr, "Programma apturēta!", "Brīdinājums",JOptionPane.WARNING_MESSAGE); break;
			default: JOptionPane.showMessageDialog(fr, "Darbība nepastāv!", "Kļūme",JOptionPane.ERROR_MESSAGE); 
				
			}
		}while(!izvele.equals("stop"));
	}

}
