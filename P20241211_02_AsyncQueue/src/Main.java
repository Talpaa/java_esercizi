import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] s) {
		/*
		 * Realizzare un programma con due thread, un thread produttore e un thread
		 * consumatore i due thread condividono una coda di numeri casuali. Il primo
		 * thread genera ad intervalli casuali (variabili tra 100 e 1000 ms) dei numeri
		 * interi casuali e li aggiunge in coda. IL secondo thread legge i numeri
		 * presenti in coda, a intervalli casuali compresi tra 100 e 500 ms), ne calcola
		 * somma e valor medio e li stampa ogni 2 secondi. Quindi il secondo thread
		 * legge a intervalli casuali e quando la somma di questi intervalli ha superato
		 * i due secondi, stampa somma e media. Implica il fatto che il secondo thread
		 * tra una lettura e l'altra accumula i valori di somma e media NB: la media è
		 * la somma/numero di elementi letti. Quindi non dovete ricordare la somma e la
		 * media ma dovete ricordare la somma e il numero di elementi letti. Il
		 * programma non deve terminare mai.
		 */
		
		//Dichiazione della coda
		//Dichiarazione dei metodi di accesso alla coda (per renderli bloccanti)
		//dichiarazione dei due thread
		//start dei due thread
		
		//Inizia esecuzione
		new Produttore().start();
		new Consumatore().start();
	}
	
	//la dichiarazione della coda
	static public Queue<Integer> coda = new LinkedList<Integer>();

	//I metodi di accesso alla coda, per ora senza controllo della concorrenza
	public static Boolean CodaVuota() {
		return coda.isEmpty();
	}

	public static void PushCoda(Integer i) {
		coda.add(i);
	}

	public static Integer PullCoda() {
		return coda.poll();
	}

}