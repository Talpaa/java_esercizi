import java.util.HashMap; // import the HashMap class

public class Main {

	public static void main(String[] args) {
		
		HashMap<Integer,Long> hm1 = Fibonacci();
		
		for(int i = 0; i<hm1.size(); i++) {
			
			System.out.println(hm1.get(i));
		}
		
		System.out.println("\n\n\n");
		
		HashMap<Integer,Long> hm2 = new HashMap<Integer, Long>();
		System.out.println(Fib(50, hm2));

	}
	
	public static Long Fib(int n, HashMap<Integer, Long> hm) {
		
		if(n<2) {
			return 1L;
		}
		
		Long n1, n2;
		if(hm.containsKey(n-1)) {
			n1 = hm.get(n-1);
		}else {
			n1 = Fib(n-1, hm);
			hm.put(n-1, n1);
		}
		if(hm.containsKey(n-2)) {
			n2 = hm.get(n-2);
		}else {
			n2 = Fib(n-2, hm);
			hm.put(n-2, n2);
		}

		return n1+n2;
			
	}

	private static HashMap<Integer, Long> Fibonacci() {
		
		HashMap<Integer,Long> hm = new HashMap<Integer,Long>();
		
		hm.put(0, 1L);
		hm.put(1, 1L);
		
		for(int i = 2; i<=50; i++) {
			
			hm.put(i, (hm.get(i-1) + hm.get(i-2)));
		}
		return hm;
	}

}
