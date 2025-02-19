/*
Un Main di test in cui uno o due clienti registrano il proprio nome e acquistano  uno o più prodotti. 
Stampare la lista dei prodotti acquistati.
 */

import java.util.LinkedList;

public class main {

	public static void main(String[] args) {
		
		LinkedList<String> negozi = new LinkedList<String>();

		Prodotto prodotto = new Prodotto("?", "?", "?", "?", negozi);
		
		System.out.println(prodotto.toString());
		
		negozi.add("Euronics");
		negozi.add("MediaWorld");
		negozi.add("Expert");
		negozi.add("Unieuro");
		
		
		
		Telefono telefono = new Telefono("537-579-6", "S7+", "Telefono cellulare", "190.00", negozi, "Samsung");

		Televisore televisore = new Televisore("576-089-2", "JVC LT-40VAF335I TV", "Televisore smart, Full HD", "179.99", negozi, "JVC");

		Cliente cliente1 = new Cliente("4563782", "Adriano", "Sarni", "Adriano.sarni@gmail.com", "S0Z0SC3W0");
		
		cliente1.acquistaProdotto(telefono);
		cliente1.acquistaProdotto(televisore);
		
		System.out.println(cliente1.toString());
	}

}
