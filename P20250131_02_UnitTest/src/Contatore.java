public class Contatore {
	public static Integer conteggio(String parola, Character carattere) {
		
		char[] caratteri = parola.toCharArray();
		int a = 0;
		
		for (Character x : caratteri) {
			
			if (x.equals(carattere)) {
				a += 1;
			}
			
		}

		return a;
	}
}
