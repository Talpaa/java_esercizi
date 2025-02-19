import java.util.LinkedList;

public class OrdinamentoArray {

	public static LinkedList<Integer> ordina(Integer[] numeri) {
		
		LinkedList<Integer> listNumeri = new LinkedList<Integer>();
		
		for (int numero : numeri) {
			listNumeri.add(numero);
		}
		LinkedList<Integer> numeriOrdinati = new LinkedList<Integer>();
		
		int x = listNumeri.size();
		
		while (0<x) {
			
			int num = listNumeri.getFirst();
			for (int numero : listNumeri) {
				if(numero<num) {
					num = numero;
				}
			}
			
			numeriOrdinati.add(num);
			listNumeri.removeFirstOccurrence(num);
			x = listNumeri.size();
		}
		
		
		//Integer[] numeriOrdinati = (Integer[])listNumeri.toArray();
		//System.out.println(numeriOrdinati);
		return numeriOrdinati;
	}
}
