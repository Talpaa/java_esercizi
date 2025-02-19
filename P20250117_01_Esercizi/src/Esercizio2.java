public class Esercizio2 {

	public static void main(String[] args) {
		
		VerificatoreParola parola = (a,b)-> a.length() == b;
		
		System.out.println(parola.verifica("ciao", 4));
	}

	//Verificare se una parola è lunga più di un certo numero di caratteri utilizzando una espressione lambda
	@FunctionalInterface
	interface VerificatoreParola {

	             boolean verifica(String parola, int lunghezza);

	}

}
