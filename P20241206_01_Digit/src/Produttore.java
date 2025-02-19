public class Produttore {
	
	public static Boolean Scandisci(String numero) {
		
		Boolean ris = null;
		
		for (int i=0; i<numero.length(); i++) {
			
			Character digit = numero.charAt(i);
			
			ris = Consumatore.Controlla(digit);
			
			if (!ris) {
				
				return ris;
			}
		}
		
		return ris;
	}

}
