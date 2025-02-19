
public class Esercizio6 {

	public static void main(String[] args) {
		
		VerificatorePari numero = (a)-> (a%2) == 0;

		System.out.print("Il numero " + 1 + " è pari? ");
		System.out.println(numero.verifica(1));
		
		System.out.print("Il numero " + 2 + " è pari? ");
		System.out.println(numero.verifica(2));
	}
	
	//Verificare se un numero è pari utilizzando una espressione lambda
	@FunctionalInterface
	interface VerificatorePari {
	    boolean verifica(int numero);
	}

}
