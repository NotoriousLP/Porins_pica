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
		String tips = JOptionPane.showInputDialog("Kādu kontūru picai dosi? - Kvadrāts || Apaļš");
		tips = tips.toLowerCase();
		if(tips.equals("kvadrāts")) {
			cena = cena+0.70;
		}else if(tips.equals("apaļš")) {
			cena = cena+0.50;
		}
		String garsa = JOptionPane.showInputDialog("Kādu garša picai būs? - Siers | Gaļa | Sēnes");
		garsa = garsa.toLowerCase();
		if(garsa.equals("siers")) {
			cena = cena+0.42;
		}else if(garsa.equals("gaļa")) {
			cena = cena+0.94;
		}else if(garsa.equals("sēnes")) {
			cena = cena+1.42;
		}
		String piedeva = JOptionPane.showInputDialog("Kādas piedevas picai būs? - Kečups | Majonēze | Sīpoli");
		piedeva = piedeva.toLowerCase();
		if(piedeva.equals("kečups")) {
			cena = cena+0.22;
		}else if(piedeva.equals("majonēze")) {
			cena = cena+0.14;
		}else if(piedeva.equals("sīpoli")) {
			cena = cena+0.52;
		}
		do {
		cm = Integer.parseInt(JOptionPane.showInputDialog("Picas diametrs - 10|20|30|40|50"));	
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
		masivs[i] = new Klients(vards,uzvards,telefons,Adrese,tips,garsa,piedeva,cm,cena);
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
		double cena=0;
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
					if(klientaVards.equals(klientuMasivs[i].nosakaVardu())){
						atrasts = true;
						String sutaMajas = JOptionPane.showInputDialog("Vai klients sūta mājas | Jā vai nē|");
						double piegadesCena;
						sutaMajas = sutaMajas.toLowerCase();
						if(sutaMajas.equals("jā")) {
							piegadesCena = 5.76;
						}else {
							piegadesCena = 0;
						}
						cena=0;
						klientuMasivs[i].nomainitTipu(JOptionPane.showInputDialog("Kādu kontūru picai dosi? - Kvadrāts || Apaļš"));
						klientuMasivs[i].nomainitGarsu(JOptionPane.showInputDialog("Kādu garša picai būs? - Siers | Gaļa | Sēnes"));
						klientuMasivs[i].nomainitPiedevu(JOptionPane.showInputDialog("Kādas piedevas picai būs? - Kečups | Majonēze | Sīpoli"));
						klientuMasivs[i].nomainitcm(Integer.parseInt(JOptionPane.showInputDialog("Picas diametrs - 10|20|30|40|50")));	
						skaits = Integer.parseInt(JOptionPane.showInputDialog("Cik picas klients tādas pašas sūtīs?"));	
						cena = izrekinasana(cena,skaits,piegadesCena);
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
					if(klientaVards.equals(klientuMasivs[i].nosakaVardu())){
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
					if(klientaVards.equals(klientuMasivs[i].nosakaVardu())){
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
