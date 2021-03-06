package Porins_pica;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Picerija {
	static Klients[] klientuNaksana(Klients[] masivs) {
		int cm;
		double cena=0;
		double piegadesCena;
		for(int i=0; i<masivs.length; i++) {
		String vards =  JOptionPane.showInputDialog("Klienta vārds");
		String uzvards =  JOptionPane.showInputDialog("Klienta uzvārds");
		String telefons =  JOptionPane.showInputDialog("Klienta telefona numurs");
		String Adrese =  JOptionPane.showInputDialog("Klienta adrese");
		String sutaMajas = JOptionPane.showInputDialog("Vai klients sūta mājas | Jā vai nē|");
		int skaits;
		sutaMajas = sutaMajas.toLowerCase();
		if(sutaMajas.equals("jā")) {
			piegadesCena = 5.76;
		}else {
			piegadesCena = 0;
		}
		String tips = JOptionPane.showInputDialog("Kādu kontūru picai dosi? - Kvadrāts - 0.70 Eur | Apaļš- 0.50 Eur | Ovāls- 0.80 Eur");
		tips = tips.toLowerCase();
		if(tips.equals("kvadrāts")) {
			cena = cena+0.70;
		}else if(tips.equals("apaļš")) {
			cena = cena+0.50;
		}else if(tips.equals("ovāls")){
			cena  = cena + 0.80;
		}
		String garsa = JOptionPane.showInputDialog("Kādu garša picai būs? - Siers - 0.42 Eur  | Gaļa- 0.94 Eur | Sēnes- 1.42 Eur | Salāti- 0.50 Eur");
		garsa = garsa.toLowerCase();
		if(garsa.equals("siers")) {
			cena = cena+0.42;
		}else if(garsa.equals("gaļa")) {
			cena = cena+0.94;
		}else if(garsa.equals("sēnes")) {
			cena = cena+1.42;
		}else if(garsa.equals("salāti")){
			cena = cena+0.50;
		}
		String piedeva = JOptionPane.showInputDialog("Kādas piedevas picai būs? - Kečups  - 0.22 Eur | Majonēze- 0.14 Eur  | Sīpoli- 0.52 Eur  | Loki- 0.15 Eur");
		piedeva = piedeva.toLowerCase();
		if(piedeva.equals("kečups")) {
			cena = cena+0.22;
		}else if(piedeva.equals("majonēze")) {
			cena = cena+0.14;
		}else if(piedeva.equals("sīpoli")) {
			cena = cena+0.52;
		}else if(piedeva.equals("loki")){
			cena = cena+0.15;
		}
		String dzeramais = JOptionPane.showInputDialog("Kāds dzeramais būs - Kola - 1.22 Euro | Fanta - 1.14 Euro | Sula - 0.52 Euro");
		dzeramais = dzeramais.toLowerCase();
		if(dzeramais.equals("Kola")) {
			cena = cena+1.22;
		}else if(dzeramais.equals("Fanta")) {
			cena = cena+1.14;
		}else if(dzeramais.equals("Sula")) {
			cena = cena+0.52;
		}
		do {
		cm = Integer.parseInt(JOptionPane.showInputDialog("Picas diametrs - 10 cm - 0.70 Eur|20cm - 1.00 Eur|30cm - 1.70 Eur|40cm - 2.00 Eur|50cm - 2.70 Eur"));	
		if(cm==10) {
			cena = cena+0.70;
		}else if(cm==20) {
			cena = cena+1.00;
		}else if(cm==30) {
			cena = cena+1.70;
		}else if(cm==40) {
			cena = cena+2.00;
		}else if(cm==50) {
			cena = cena+2.70;
		}
		skaits = Integer.parseInt(JOptionPane.showInputDialog("Cik picas klients tādas pašas sūtīs?"));	
		}while(cm<10 || cm>50);
		cena = izrekinasana(cena,skaits,piegadesCena);
		masivs[i] = new Klients(vards,uzvards,telefons,Adrese,tips,garsa,piedeva,cm,dzeramais,cena);
		masivs[i].izvaditCenu();
		cena = 0;
		JOptionPane.showMessageDialog(null, "Klients saglabāts", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
		return masivs;
	}
	public static double izrekinasana(double cena, int skaits, double piegade) {
		cena = (cena*skaits);
		cena = cena+piegade;
		cena = Math.round(cena*100.0)/100.0;
		return cena;
	}
	public static void nolasit() {
		String teksts, virkne="";
		try{
			FileReader fr = new FileReader("pica.txt");
			BufferedReader lasa = new BufferedReader(fr);
			while((teksts = lasa.readLine()) !=null){
				virkne += teksts+"\n";
			}
			lasa.close();
			JOptionPane.showMessageDialog(null, virkne, "Informācija",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Kļūda nolasot faila, ","Kļūda",JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void saglabat(Klients[] masivs) {
		try{
			FileWriter fw = new FileWriter("pica.txt", true);
			PrintWriter raksta = new PrintWriter(fw);
			
			for(int i=0; i<masivs.length; i++){
				masivs[i].saglabatFaila();
			}
			raksta.println("_________________________________");
			raksta.close();
			JOptionPane.showMessageDialog(null, "Informācija par klientas picu un cenu saglabāts failā", "Info", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Kļūda  ierakstot faila, ","Kļūda ",JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void main(String[] args) {
		String izvele;
		JFrame fr= new JFrame();
		Klients[] klientuMasivs = null;
		int skaits;
		do {
			izvele = JOptionPane.showInputDialog("1-Klienta pica | 2-Klientu citu veidu picas sūtīšana | 3-Izvadīt |4-Saglabāt datus failā |5-Nolasīt datus no faila |stop - Programmas beigas");
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
				boolean atrasts = false;
				String klientaVards = JOptionPane.showInputDialog("Ievadi Klienta vārdu, kurš vēlas savādāku picu pasūtīt: ");
				for(int i=0; i<klientuMasivs.length; i++) {
					if(klientaVards.equalsIgnoreCase(klientuMasivs[i].nosakaVardu())){
						atrasts = true;
						double cena=0;
						int cm;
						String sutaMajas = JOptionPane.showInputDialog("Vai klients sūta mājas | Jā vai nē|");
						double piegadesCena;
						sutaMajas = sutaMajas.toLowerCase();
						if(sutaMajas.equals("jā")) {
							piegadesCena = 5.76;
						}else {
							piegadesCena = 0;
						}
						String tips = JOptionPane.showInputDialog("Kādu kontūru picai dosi? - Kvadrāts - 0.70 Eur | Apaļš- 0.50 Eur | Ovāls- 0.80 Eur");
						tips = tips.toLowerCase();
						if(tips.equals("kvadrāts")) {
							cena = cena+0.70;
						}else if(tips.equals("apaļš")) {
							cena = cena+0.50;
						}else if(tips.equals("ovāls")){
							cena  = cena + 0.80;
						}
						klientuMasivs[i].nomainitTipu(tips);
						String garsa = JOptionPane.showInputDialog("Kādu garša picai būs? - Siers - 0.42 Eur  | Gaļa- 0.94 Eur | Sēnes- 1.42 Eur | Salāti- 0.50 Eur");
						garsa = garsa.toLowerCase();
						if(garsa.equals("siers")) {
							cena = cena+0.42;
						}else if(garsa.equals("gaļa")) {
							cena = cena+0.94;
						}else if(garsa.equals("sēnes")) {
							cena = cena+1.42;
						}else if(garsa.equals("salāti")){
							cena = cena+0.50;
						}
						klientuMasivs[i].nomainitGarsu(garsa);
						String piedeva = JOptionPane.showInputDialog("Kādas piedevas picai būs? - Kečups  - 0.22 Eur | Majonēze- 0.14 Eur  | Sīpoli- 0.52 Eur  | Loki- 0.15 Eur");
						piedeva = piedeva.toLowerCase();
						if(piedeva.equals("kečups")) {
							cena = cena+0.22;
						}else if(piedeva.equals("majonēze")) {
							cena = cena+0.14;
						}else if(piedeva.equals("sīpoli")) {
							cena = cena+0.52;
						}else if(piedeva.equals("loki")){
							cena = cena+0.15;
						}
						klientuMasivs[i].nomainitPiedevu(piedeva);
						String dzeramais = JOptionPane.showInputDialog("Kāds dzeramais būs - Kola - 1.22 Euro | Fanta - 1.14 Euro | Sula - 0.52 Euro");
						dzeramais = dzeramais.toLowerCase();
						if(dzeramais.equals("Kola")) {
							cena = cena+1.22;
						}else if(dzeramais.equals("Fanta")) {
							cena = cena+1.14;
						}else if(dzeramais.equals("Sula")) {
							cena = cena+0.52;
						}
						klientuMasivs[i].jaunsDzeramais(dzeramais);
						do {
							do {
								cm = Integer.parseInt(JOptionPane.showInputDialog("Picas diametrs - 10 cm - 0.70 Eur|20cm - 1.00 Eur|30cm - 1.70 Eur|40cm - 2.00 Eur|50cm - 2.70 Eur"));	
								if(cm==10) {
									cena = cena+0.70;
								}else if(cm==20) {
									cena = cena+1.00;
								}else if(cm==30) {
									cena = cena+1.70;
								}else if(cm==40) {
									cena = cena+2.00;
								}else if(cm==50) {
									cena = cena+2.70;
								}
								}while(cm<10 || cm>50);
						klientuMasivs[i].nomainitcm(cm);
						skaits = Integer.parseInt(JOptionPane.showInputDialog("Cik picas klients tādas pašas sūtīs?"));	
						}while(cm<10 || cm>50);
							
						cena = izrekinasana(cena,skaits,piegadesCena);
						klientuMasivs[i].jaunaCena(cena);
						klientuMasivs[i].izvaditCenu();
						}
					}
				if(atrasts == false) {
					JOptionPane.showMessageDialog(fr, "Tādu klientu nevar atrast", "Brīdinājums",JOptionPane.WARNING_MESSAGE);
				}
				break;
			case "3":
				 atrasts = false;
				klientaVards = JOptionPane.showInputDialog("Ievadi Klienta vārdu: ");
				for(int i=0; i<klientuMasivs.length; i++) {
					if(klientaVards.equalsIgnoreCase(klientuMasivs[i].nosakaVardu())){
						atrasts = true;
						klientuMasivs[i].izvadit();
						}
					}
				if(atrasts == false) {
					JOptionPane.showMessageDialog(fr, "Tādu klientu nevar atrast", "Brīdinājums",JOptionPane.WARNING_MESSAGE);
				}
				break;
			case "4":
				 atrasts = false;
				klientaVards = JOptionPane.showInputDialog("Ievadi Klienta vārdu: ");
				for(int i=0; i<klientuMasivs.length; i++) {
					if(klientaVards.equalsIgnoreCase(klientuMasivs[i].nosakaVardu())){
						atrasts = true;
						klientuMasivs[i].saglabatFaila();
					}
				}
				if(atrasts == false) {
					JOptionPane.showMessageDialog(fr, "Tādu klientu nevar atrast", "Brīdinājums",JOptionPane.WARNING_MESSAGE);
				}
				break;
			case "5":
				nolasit();
				break;	
			case "stop": JOptionPane.showMessageDialog(fr, "Programma apturēta!", "Brīdinājums",JOptionPane.WARNING_MESSAGE); break;
			default: JOptionPane.showMessageDialog(fr, "Darbība nepastāv!", "Kļūme",JOptionPane.ERROR_MESSAGE); 
			}
		}while(!izvele.equals("stop"));
	}

}
