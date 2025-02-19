import java.util.Scanner;

public class Aeroporto {

	public static void Menu(CompagniaAerea alitalia) {
		//Menu per aeroporto
			//imbarco
			//decollo
	    	//atterraggio
		@SuppressWarnings("resource")//viene chiuso nel main.
		Scanner input = new Scanner(System.in);
		
		Integer operazione = 0;
		Boolean ris = true;
		
		do {
			System.out.println("\n1) Imbarco;");
			System.out.println("2) Decollo;");
			System.out.println("3) Atterraggio;");
			System.out.println("4) Exit");
			System.out.print("Quale operazione vuoi eseguire(Digitare il numero associato): ");
			operazione = input.nextInt(); 
			input.nextLine();
			
			switch (operazione) {
			case 1: {
				
				System.out.print("\nDi quale volo vuoi chiudere l'imbarco: ");
				String nomeVolo = input.next();
				Volo volo = alitalia.TrovaVolo(nomeVolo);
				
				if (volo == null) {
					System.out.println("\nNon esiste nessun volo con questo nome.");
				}else {
					volo.setImbarco(false);
					System.out.println("\nl'Imbarco del volo " + volo.getNome() + " è stato chiuso.");
				}
				break;
			}
			case 2: {
				
				System.out.print("\nDi quale volo vuoi sapere l'orario di decollo: ");
				String nomeVolo = input.next();
				Volo volo = alitalia.TrovaVolo(nomeVolo);
				
				if (volo == null) {
					System.out.println("\nNon esiste nessun volo con questo nome.");
				}else {

					System.out.println("\nL'orario di decollo del volo " + volo.getNome() + " è previsto per le " + volo.getDecollo() + ".");
				}
				break;
			}
				
			case 3: {

				System.out.print("\nDi quale volo vuoi sapere l'orario di atterraggio: ");
				String nomeVolo = input.next();
				Volo volo = alitalia.TrovaVolo(nomeVolo);
				
				if (volo == null) {
					System.out.println("\nNon esiste nessun volo con questo nome.");
				}else {

					System.out.println("\nL'orario di atterraggio del volo " + volo.getNome() + " è previsto per le " + volo.getAtteraggio() + ".");
				}
				break;
			}
			case 4: {

				ris = false;
				//input.close();
				break;
			}
			default:
				System.out.println("\nIl menu " + operazione + " non esiste.");;
			}
			
		}while(ris);
		
	}
}
