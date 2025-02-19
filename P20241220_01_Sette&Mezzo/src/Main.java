import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//System.out.println(Math.random());

		/*
		for (int i = 0; i < 0; i++) {
		      int index = (int)(Math.random() * 40);
		      
		      System.out.println(index + " ");
		    }
		
		Partita part = new Dealer();
		
		part.IniziaParitita();
		
		for (int i = 1; i<41; i++) {
			
			String[] carta = part.getMazzo().get(i).split(",");
			System.out.println(i + ") " + carta[0] + " di " + carta[1]);
		}
		
		for (int i : part.getOrdine()) {
			System.out.println(i);
		}
		*/
		
		
		
		String ris = "vai";
		Scanner input = new Scanner(System.in);
		
		do {
			
			System.out.println("La Mia mano: ");
				
			
			
		}while(ris == "sto");
		
		Partita partita = new Partita();
		
		Giocatore giocatore = new Giocatore();
		
		Dealer dealer = new Dealer();
		
		partita.IniziaParitita();
		
		partita.Partita(dealer, giocatore);
		
		input.close();
	}

}
