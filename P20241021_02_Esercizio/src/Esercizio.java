
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
		
		String[] marche = {"Asus", "Acer", "HP", "Lenovo", "Apple", "LG", "Dell", "Samsung", "Microsoft", "Razer"};
		Computer computers[] = new Computer[10];
		
		for (int i = 0; i<10; i++) {
			
			double prezzo = Math.random()* 1000;
			
			double peso = Math.random() * 100;
			double altezza = Math.random() * 100;
			double larghezza = Math.random() * 100;
			double profondita = Math.random() * 100;
			
			String marca = marche[ (int)( Math.random() * 10) ];
			
			int anno = (int)( Math.random() * 100 + 2000);
			
			
			
			computers[i] = new Computer(prezzo, peso, altezza, larghezza, profondita, marca, anno);
		}
		
		
		for (int i = 0; i<10; i++) {
			
			System.out.println();
			computers[i].stamp(i+1);
		}
		
	}

}
