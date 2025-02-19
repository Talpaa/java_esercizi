public class Esercizio1 {

	public static void main(String[] args) {
		 
		Calcolatore somma = (a,b)-> a + b;
		
		System.out.println(somma.calcola(7, 180));
	}
	
	//Sommare due numeri utilizzando una espressione lambda
	@FunctionalInterface
	interface Calcolatore {

	    int calcola(int a, int b);

	}

}
