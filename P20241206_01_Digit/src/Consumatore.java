import java.util.LinkedList;

public class Consumatore {
	
	public static Double valore;
	private static String numero = "";
	private static Boolean negativo = false;
	private static Boolean positivo = false;
	private static Boolean punto = false;
	private static Character[] cifre1 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private static LinkedList<Character> cifre = new LinkedList<Character>();
	

	public static Boolean Controlla(Character digit) {
		
		for (Character c : cifre1) {cifre.add(c);}
		
		if ((digit == '-')&&(!negativo)&&(!positivo)) {
			
			negativo = true;
		}else if((digit == '+')&&(!positivo)&&(!negativo)) {
			
			positivo = true;
		}else if((digit == '.')&&(!punto)) {
			
			punto = true;
			
			if (numero.length() == 0) {
				numero = numero + '0' + digit;
			}else {
				numero = numero + digit;
			}
			
		}else if(cifre.contains(digit)) {
			
			numero = numero + digit;
		}else if(digit == '\n') {
			
			if (numero.length() == 0) {
				
				valore = 0.0;
			}else {
				
				if(negativo) {
					valore = Double.parseDouble(numero);
					
					valore = (-1) * valore;
				}else {
					valore = Double.parseDouble(numero);
				}
				
			}
		}else {
			negativo = false;
			positivo = false;
			punto = false;
			return false;
		}
		
		negativo = false;
		positivo = false;
		punto = false;
		return true;
	}
}
