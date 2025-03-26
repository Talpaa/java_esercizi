package checked;

public class MainImpiegato {

	public static void main(String[] args) {
		
		Impiegato imp = new Impiegato("Mario Rossi", 1700);
		System.out.println(imp);

		try {
			imp.incrementaDalario(-500);
		} catch (IncrementoNegativoException e) {
			System.out.println("Hai inserito un valore negativo o nullo");
		}
		System.out.println(imp);
	}

}
