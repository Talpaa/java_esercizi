import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		//var Now = System.nanoTime();
		
		/*calcolare il tempo che ci vuole
		 * per inserire 1'000'000 di numeri interi
		 * sequenziali in testa a una LinkedList*/
		final Integer N=1000000;
		long inizio, fine;
		
		inizio = System.nanoTime();
		AddToLinkedList(N);
		fine = System.nanoTime();
		
		System.out.println("Risultato AddToLinkedList di " + N + " Elementi: " +
							(fine-inizio)/1000000000.0 + " Sec.");
		
		inizio = System.nanoTime();
		AddFirstToLinkedList(N);
		fine = System.nanoTime();
		
		System.out.println("Risultato AddFirstToLinkedList di " + N + " Elementi: " +
							(fine-inizio)/1000000000.0 + " Sec.");
		
		
		
		inizio = System.nanoTime();
		AddToArrayList(N);
		fine = System.nanoTime();
		
		System.out.println("Risultato AddToArrayList di " + N + " Elementi: " +
							(fine-inizio)/1000000000.0 + " Sec.");

		inizio = System.nanoTime();
		AddFirstToArrayList(N);
		fine = System.nanoTime();
		
		System.out.println("Risultato AddFirstToArrayList di " + N + " Elementi: " +
							(fine-inizio)/1000000000.0 + " Sec.");
		
		
		
		inizio = System.nanoTime();
		AddFirst(N);
		fine = System.nanoTime();
		
		System.out.println("Risultato NostraLL di " + N + " Elementi: " +
							(fine-inizio)/1000000000.0 + " Sec.");

	}

	private static LinkedList<Integer> AddToLinkedList(Integer n) {
		
		LinkedList<Integer> lli = new LinkedList<Integer>();
		while (n > 0) {
			lli.add(n--);
		}
		return lli;
		
	}
	
	private static ArrayList<Integer> AddToArrayList(Integer n) {
		
		ArrayList<Integer> lli = new ArrayList<Integer>();
		while (n > 0) {
			lli.add(n--);
		}
		return lli;
		
	}
	
	
	
	private static LinkedList<Integer> AddFirstToLinkedList(Integer n) {
		
		LinkedList<Integer> lli = new LinkedList<Integer>();
		while (n > 0) {
			lli.addFirst(n--);
		}
		return lli;
		
	}
	
	private static ArrayList<Integer> AddFirstToArrayList(Integer n) {
		
		ArrayList<Integer> lli = new ArrayList<Integer>();
		while (n > 0) {
			lli.addFirst(n--);
		}
		return lli;
		
	}

}
