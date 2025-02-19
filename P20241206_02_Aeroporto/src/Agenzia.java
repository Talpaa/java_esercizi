import java.util.Scanner;

public class Agenzia {

	public static void Menu(CompagniaAerea alitalia) {		
		//Menu per agenzia
			//prenotazione
			//disdetta
		
		@SuppressWarnings("resource")//viene chiuso nel main.
		Scanner input = new Scanner(System.in);
		
		Integer operazione = 0;
		Boolean ris = true;
		
		do {
			System.out.println("\n1) Prenotazione;");
			System.out.println("2) Disdetta;");
			System.out.println("3) Exit");
			System.out.println("Quale operazione vuoi eseguire(Digitare il numero associato): ");
			operazione = input.nextInt(); 
			input.nextLine();
			
			switch (operazione) {
			case 1: {
				System.out.print("\nQuale è il nome del volo che vuoi prenotare: ");
				String nomeVolo = input.next();
				
				System.out.print("\nQuale è il numero di posti che vuoi prenotare sul volo: ");
				Integer posti = input.nextInt();
				
				alitalia.PrenotaVolo(nomeVolo, posti);
				
				break;
			}
			case 2: {

				System.out.print("\nQuale è il nome del volo che vuoi disdire: ");
				String nomeVolo = input.next();
				
				System.out.print("\nQuale è il numero di posti che vuoi disdire sul volo: ");
				Integer posti = input.nextInt();
				
				alitalia.CancellaPrenotazione(nomeVolo, posti);
				break;
			}
			case 3: {

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
