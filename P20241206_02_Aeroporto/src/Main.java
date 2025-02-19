import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		LinkedList<Volo> voli = new LinkedList<Volo>(); 
		LinkedList<Aereo> aerei = new LinkedList<Aereo>(); 
		
		
		var fileRA = Util.OpenFileForReading("aerei.txt");
		
		try {

			String riga;
			while ((riga = fileRA.readLine()) != null) {
				
				String[] items = riga.split(",");
				
				Aereo aereo = new Aereo(items[0], Integer.parseInt(items[1]), Integer.parseInt(items[2]));
				
				aerei.add(aereo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
			
		try {
			fileRA.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		var fileRV = Util.OpenFileForReading("voli.txt");
		
		Aereo aereo = null;
		
		try {

			String riga;
			while ((riga = fileRV.readLine()) != null) {
				
				String[] items = riga.split(",");
				
				for (Aereo a : aerei) {
					
					if (items[3].equals(a.getNome())) {
						
						aereo = a;
					}
				}
				
				//String nome, String partenza, String arrivo, Aereo aereo, String decollo, String atteraggio
				Volo volo = new Volo(items[0], items[1], items[2], aereo, items[4], items[5], Boolean.valueOf(items[6]));
				
				voli.add(volo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
			
		try {
			fileRV.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner myObj = new Scanner(System.in);
		Boolean ris = true;
		Integer menu = 0;
		CompagniaAerea alitalia = new CompagniaAerea(aerei, voli);
		
		for (Aereo aereoo : alitalia.getAerei()) {
			System.out.println(aereoo);
		}
		
		for (Volo voloo : alitalia.getVoli()) {
			System.out.println(voloo);
		}
		
		do {
			
			System.out.println("\n1) Menu per agenzia;");
			System.out.println("2) Menu per aeroporto;");
			System.out.println("3) Menu per compagnia aerea;");
			System.out.println("4) Termina sessione");
			System.out.print("Quale menu vuoi visualizzare(Digitare il numero associato): ");
			
			menu = myObj.nextInt(); 
			myObj.nextLine();
			
			switch (menu) {
			case 1: {
				
				Agenzia.Menu(alitalia);
				
				break;
			}
			case 2: {
				
				Aeroporto.Menu(alitalia);
				break;
			}
			case 3: {
	
				alitalia.Menu();
				break;
			}
			case 4: {
				
				ris = false;
				myObj.close();
				
				var fileWA = Util.OpenFileForWriting("aerei.txt");
				
				for (var x : alitalia.getAerei()) {
					
					try {
						String a = String.format("%s,%d,%d\n", 
								x.getNome(), x.getPosti(), x.getPostiDis());
						fileWA.write(a);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					fileWA.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				var fileWV = Util.OpenFileForWriting("voli.txt");
				
				for (var x : alitalia.getVoli()) {
					
					try {
						String a = String.format("%s,%s,%s,%s,%s,%s,%s\n", 
								x.getNome(), x.getPartenza(), x.getArrivo(), 
								x.getAereo().getNome(), x.getDecollo(), 
								x.getAtteraggio(), String.valueOf(x.getImbarco()));
						fileWV.write(a);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					fileWV.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			default:
				System.out.println("Il menu " + menu + " non esiste.");;
			}
			
		}while(ris);
	}
}
