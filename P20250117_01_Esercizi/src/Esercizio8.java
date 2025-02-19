
public class Esercizio8 {

	public static void main(String[] args) {
		
		VerificatoreParola palindromo = (str)-> {
			
			String revStr = "";
			
			for (int i = 0; i < str.length(); i++) {
			    revStr = str.charAt(i) + revStr;
			}
			
			for (int i = 0; i < str.length(); i++) {
			    
				char a = str.charAt(i);
				char b = revStr.charAt(i);
				
				if(a != b) {
					return false;
				}
			}
			
			return true;
			
		};
		
		System.out.print("La parola 'anzxna' è palindroma: ");
		System.out.println(palindromo.verifica("anzxna"));
		
		System.out.print("La parola 'anna' è palindroma: ");
		System.out.println(palindromo.verifica("anna"));

	}

	//Verificare se una parola è palindroma utilizzando una espressione lambda
	@FunctionalInterface
	interface VerificatoreParola {
	    boolean verifica(String parola);
	}
}
