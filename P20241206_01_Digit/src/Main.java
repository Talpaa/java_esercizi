import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(!true);
		
		String ciao = "ci";
		
		ciao = ciao + 'a' +'o';
		
		System.out.println(ciao);
		
		char[] cars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		//if (cars.)
		
		LinkedList<Character> cifre = new LinkedList<Character>();
		
		for (Character c : cifre) {
			
			cifre.add(c);
		}
		
		System.out.println(cifre.contains('o'));
		System.out.println(cifre.contains('0'));
		
		LinkedList<String> valori = new LinkedList<String>();
		valori.add("-.123");
		
		for (String valore : valori) {
			if(Produttore.Scandisci(valore)) {
				
				System.out.println("Il valore è stato convertito in Double: " + Consumatore.valore);
			}else {
				System.out.println("Non è stato possibile convertire il valore");
			}
		}
	}

}
