public class Calcolatrice {
	
	public static Double somma(String a, String b) {
		Double val1 = Double.parseDouble(a);
		Double val2 = Double.parseDouble(b);
		
		return (val1+val2);
	}
	
	public static Double sottrazione(String a, String b) {
		Double val1 = Double.parseDouble(a);
		Double val2 = Double.parseDouble(b);
		
		return (val1-val2);
	}

	public static Double moltiplicazione(String a, String b) {
		Double val1 = Double.parseDouble(a);
		Double val2 = Double.parseDouble(b);
		
		return (val1*val2);
	}
	
	public static Double divisione(String a, String b) {
		Double val1 = Double.parseDouble(a);
		Double val2 = Double.parseDouble(b);
		
		return (val1/val2);
	}
}