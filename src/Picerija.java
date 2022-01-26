import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Picerija {
	static Pica[] izveidotPicu(Pica[] masivs) {
		for(int i=0; i<masivs.length; i++) {
			String tips = JOptionPane.showInputDialog("Kādu kontūru picai dosi?");
			String garsa = JOptionPane.showInputDialog("Kādu garša picai būs?");
			String piedeva = JOptionPane.showInputDialog("Kādas piedevas picai būs?");
			double cena = Double.parseDouble(JOptionPane.showInputDialog("Kāda būs šis picas cena"));
			masivs[i] = new Pica(tips,garsa,piedeva,cena);
			}
		return masivs;
	}
	public static void main(String[] args) {
		String izvele;
		JFrame fr= new JFrame();
		Pica[] picasMasivs = null;
		int skaits;
		do {
			izvele = JOptionPane.showInputDialog("1-Pievienot picu | 2-Pievienot Klientu | 3- | 4- | 5-");
			switch(izvele) {
			case "1":
				try {
					skaits = Integer.parseInt(JOptionPane.showInputDialog("Cik picas veidus izveidot?"));
					picasMasivs = new Pica[skaits];
					picasMasivs = izveidotPicu(picasMasivs);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(fr, "Darbība nepastāv!", "Kļūme",JOptionPane.ERROR_MESSAGE); 
				}
				break;
			case "2":
				
				break;
			case "stop": JOptionPane.showMessageDialog(fr, "Programma apturēta!", "Brīdinājums",JOptionPane.WARNING_MESSAGE); break;
			default: JOptionPane.showMessageDialog(fr, "Darbība nepastāv!", "Kļūme",JOptionPane.ERROR_MESSAGE); 
				
			}
		}while(!izvele.equals("stop"));
	}

}
