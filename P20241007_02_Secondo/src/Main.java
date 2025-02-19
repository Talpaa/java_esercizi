
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Prima riga");
		System.out.println("Seconda riga");
		System.out.println("Terza riga");
		System.out.println("Quarta riga");

		byte b1 = 10;
		byte b2;
		b2 = 100;
		byte b3, b4, b5;

		System.out.println("Il valore di b1 è: " + b1);
		b1 = 127;
		System.out.println("Il valore di b1 è: " + b1);
		b1 += 1;
		System.out.println("Il valore di b1 è: " + b1);
		
		double d1=2.3;
		System.out.println(d1);
		float f1=2.3F;
		System.out.println(f1);
		
		/*
		 * Operatori aritmetici e logici
		 * 
		 * +,-,*,/,%,
		 * 
		 * &&(AND)
		 * ||(OR)
		 * 
		 * Logica binaria
		 * & (AND)
		 * | (OR)
		 * 
		 */
		
		int v1=35;
		int v2=41;
		
		//System.out.println(v1 && v2);
		System.out.println(v1 & v2);
		
		/*
		 * Altri operatori aritmetici e binari
		 * ++, --, +=, -=, *=, /=, &=, |=, ^=
		 * 
		 * confronto
		 * >, <, ==, <=, >0
		 * 
		 * Poi gli operatori di shifting
		 * <<, >>, <<=, >>0
		 * 
		 * ecc.
		 */
		
		{
			int num1=10;
			System.out.println(num1);
		}
		{
			boolean num1=true;
			System.out.println(num1);
		}
		
	}
}
