
public class Esercizio5 {

	public static void main(String[] args) {
		
		ConcatenatoreStringhe str = (a,b)-> a + b;

		System.out.println(str.concatena("Ciao ", "mondo"));
	}

	//Concatenare due stringhe utilizzando una espressione lambda
	@FunctionalInterface
	interface ConcatenatoreStringhe{
	    String concatena(String str1, String str2);
	}
}
