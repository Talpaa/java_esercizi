import java.util.LinkedList;
import java.util.List;

public class Esercizio7 {

	public static void main(String[] args) {
		
		Sommatore risultato = (a)->{ 
			
			Integer somma = 0;
			for(Integer x : a) {somma += x;}return somma;
		};
		
		List<Integer> lista = new LinkedList<Integer>();
		
		for (int i = 0; i<10000; i++) {lista.add(i + 1);}
		
		System.out.println(risultato.somma(lista));
	}

	//Calcolare la somma di una lista di numeri utilizzando una espressione lambda
	@FunctionalInterface
	interface Sommatore {
	    int somma(List<Integer> lista);
	}
}
