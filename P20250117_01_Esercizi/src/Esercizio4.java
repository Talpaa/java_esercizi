
public class Esercizio4 {

	public static void main(String[] args) {
		
		VerificatoreNumero numero = (a)-> a >= 0;
		
		System.out.print("Il numero " + 12 + " è positivo? ");
		System.out.println(numero.verifica(12));
		
		System.out.print("Il numero " + -2 + " è positivo? ");
		System.out.println(numero.verifica(-2));

	}
	
	//Verificare se un numero è positivo utilizzando una espressione lambda
	@FunctionalInterface
	interface VerificatoreNumero {
	    boolean verifica(int numero);
	}

}
