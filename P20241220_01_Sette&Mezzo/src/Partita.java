import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Partita {

	private HashMap<Integer, String> mazzo = new HashMap<Integer, String>();

	private LinkedList<Integer> ordine = new LinkedList<Integer>();

	public Partita() {
		super();
	}

	public void IniziaParitita() {

		CreaMazzo();
		Mischia();
	}

	private void CreaMazzo() {

		String[] segni = { "Denara", "Coppe", "Spade", "Bastoni" };

		String[] valori = { "Asso", "Due", "Tre", "Quattro", "Cinque", "Sei", "Sette", "Fante", "Cavallo", "Re" };

		Integer i = 1;

		for (String segno : segni) {

			for (String val : valori) {

				String carta = val + "," + segno;

				mazzo.put(i++, carta);
			}
		}
	}

	public void Mischia() {

		int[] array = new int[40];
		for (int i = 0; i < 40; i++) {
			array[i] = i + 1;
		}

		Integer x = 0;

		for (int i = 0; i < 40; i++) {

			Integer num = ((int) (Math.random() * 40)) + 1;
			System.out.println(num);

			while ((ordine.contains(num)) && (x < 10000)) {

				x++;
				num = ((int) (Math.random() * 40)) + 1;
				System.out.println(num);
			}

			ordine.add(num);
		}

		for (int j = 1; j < 41; j++) {

			if (!ordine.contains(j)) {
				ordine.add(j);
			}
		}
	}

	public void Partita(Dealer dealer, Giocatore giocatore) {

		String ris = "vai";
		Scanner input = new Scanner(System.in);
		Integer carta = 0;

		do {

			carta = ordine.pollFirst();
			if (carta.equals(null)) {
				ris = "sto";
			} else {

				giocatore.AddCard(carta);
				System.out.println("La Mia mano: ");

				for (Integer valore : giocatore.getMano()) {

					String[] pas = mazzo.get(valore).split(",");
					System.out.println(" " + pas[0] + " di " + pas[1]);
				}
			}
			
			if (giocatore.Punteggio() > 7.5) {

				System.out.println("Sballato");
				ris = "sballato";
			}

			if (ris.equals("vai")) {
				System.out.println("(vai/sto)");
				input.next();
			} else if ((ris.equals("sto")) || (ris.equals("sballato"))) {
			} else {
				ris = "vai";
			}

		} while (ris.equals("vai"));

		if (!(ris.equals("sballato"))) {
			Boolean con = true;
			while ((dealer.Punteggio() < 5.5) && (con)) {

				carta = ordine.pollFirst();
				if (carta == null) {
					con = false;
					System.out.println("Carte esaurite.");
				}
			}
		}
		if (ris.equals("sballato")) {
			System.out.println("Il deler vince");
		}else if (giocatore.Punteggio() > dealer.Punteggio()) {
			System.out.println("Il giocatore vince");
		} else {
			System.out.println("Il deler vince");
		}
		
	}

	public HashMap<Integer, String> getMazzo() {
		return mazzo;
	}

	public LinkedList<Integer> getOrdine() {
		return ordine;
	}
}
