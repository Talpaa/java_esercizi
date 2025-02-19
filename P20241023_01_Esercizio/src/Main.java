
public class Main {

	public static void main(String[] args) {
		
		int[] vint;
		vint = new int[100];
		
		double[] vdou;
		vdou = new double[100];
		
		System.out.println(vint[10]);
		
		boolean[] v = new boolean[1000000000];
		
		for (int i = 0; i<v.length; i++) {
			
			v[i] = true;
		}
		
		for (int i=2; i<v.length; i++) {
			
			if(v[i]==true) {
				
				System.out.println(i + " è un numero primo");
				
				for (int k=i+1; k<v.length; k++) {
					
					if ((k%i) == 0) {
						
						v[k]=false;
					}
					
				}
			}
		}
	}
		
	private static void Eratostene(int N) {
			
		boolean[] v = new boolean[1000000000];
			
		for (int i=2; i<v.length; i++) {
			
			if(v[i]==true) {
				
				System.out.println(i + " è un numero primo");
				
				for (int k=i+1; k<v.length; k++) {
					
					v[k]=false;
				}
			}
		}
	}
		
	private static void StampaVint(int[] vint) {
			
		for (int v: vint) {
				
			System.out.println(v + " ");
		}
	}
}
