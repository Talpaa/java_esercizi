
public class Esercizio {

	public static void main(String[] args) {
		
		/*
		 * Realizzare una classe Computer con i seguenti attributi
		 * 	- Prezzo
		 * 	- Peso
		 *  - Dimensioni(larghezza,altezza,profondità)
		 *  - Produttore
		 *  - Anno di produzione
		 *  
		 *  nel main creare degli oggetti di tipo Computer e stampare il loro contenuto
		 *  
		 *  NB: ricondare di utilizzare getter, setter e costruttore generati da eclipse
		 *  
		 *  Bonus: aggiungere un metodo alla classe Computer che stampi quanti oggetti(di tipo computer) 
		 *  	   sono stati creati
		 */
		
		Computer c1 = new Computer(980.89, "20.41", "20.17", "40.82", "43.92", "asus", "2017");
		Computer c2 = new Computer(199.99, "1500   g", "325.4   mm", "19.7   mm", "288   mm", "Acer", "2017");
		Computer c3 = new Computer(980.89, "20.41", "20.17", "40.82", "43.92", "asus", "2017");
		
		System.out.println(c1.getAltezza());

		System.out.println(c1.getPrezzo());
		
		System.out.println(c1.getPeso());
		
		System.out.println(c1.getAltezza());
		
		System.out.println(c1.getQuantita());
		
		System.out.println(c1);

	}

}
