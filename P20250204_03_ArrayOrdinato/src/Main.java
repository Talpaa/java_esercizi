import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		Integer[] numeri = {3, 56, 82, 12, 45, 84, 37, 53, 94};

		System.out.print("ARRAY non ordinato:");
		
		for (int numero : numeri) {
			System.out.print(" " + numero);
		}
		System.out.println();
		LinkedList<Integer> numeriOrdinati = OrdinamentoArray.ordina(numeri);
		System.out.print("ARRAY ordinato:    ");
		for (int numero : numeriOrdinati) {
			System.out.print(" " + numero);
		}
	}

}
