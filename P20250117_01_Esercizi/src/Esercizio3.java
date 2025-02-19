public class Esercizio3 {

	public static void main(String[] args) {
		
		CalcolatoreArea area = (a)-> Math.PI * (a * a);

		System.out.println(area.calcola(2));
	}
	
	//Calcolare l'area di un cerchio utilizzando una espressione lambda
	@FunctionalInterface
	interface CalcolatoreArea {

	             double calcola(double raggio);

	}

}
