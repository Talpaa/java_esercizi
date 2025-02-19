
public class Main {

	public static void main(String[] args) {

		LogConsole lc = new LogConsole();
		
		System.out.println();
		System.out.println("Risultato: " + Calcolatrice.somma(14, 7));
		System.out.println("Risultato: " + Calcolatrice.somma(14.5, 7));
		System.out.println("Risultato: " + Calcolatrice.somma(14, 7.5));
		System.out.println("Risultato: " + Calcolatrice.somma(14.75, 7.5));
		
		System.out.println();
		System.out.println("Risultato: " + Calcolatrice.sottrazione(14, 7));
		System.out.println("Risultato: " + Calcolatrice.sottrazione(14.5, 7));
		System.out.println("Risultato: " + Calcolatrice.sottrazione(14, 7.5));
		System.out.println("Risultato: " + Calcolatrice.sottrazione(14.75, 7.5));
		
		System.out.println();
		System.out.println("Risultato: " + Calcolatrice.moltiplicazione(14, 7));
		System.out.println("Risultato: " + Calcolatrice.moltiplicazione(14.5, 7));
		System.out.println("Risultato: " + Calcolatrice.moltiplicazione(14, 7.5));
		System.out.println("Risultato: " + Calcolatrice.moltiplicazione(14.75, 7.5));
		
		System.out.println();
		System.out.println("Risultato: " + Calcolatrice.divisione(14, 7));
		System.out.println("Risultato: " + Calcolatrice.divisione(14.5, 7));
		System.out.println("Risultato: " + Calcolatrice.divisione(14, 7.5));
		System.out.println("Risultato: " + Calcolatrice.divisione(14.75, 7.5));

	}

}
