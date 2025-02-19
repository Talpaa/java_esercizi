public class Palindroma {

	public static Boolean palindroma(String parola) {
		
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
		
		return palindromo.verifica(parola);

	}

	//Verificare se una parola è palindroma utilizzando una espressione lambda
	@FunctionalInterface
	interface VerificatoreParola {
	    boolean verifica(String parola);
	}
}
