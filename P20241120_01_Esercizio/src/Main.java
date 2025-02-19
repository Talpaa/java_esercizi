
public class Main {

	public static void main(String[] args) {

		Coppia<Integer, Double> ci1 = new Coppia<Integer, Double>(1, 2.0);
		Coppia<Integer, Double> ci2 = new Coppia<Integer, Double>(111, 112.0);
		System.out.println(ci1);
		System.out.println(ci2);
		
		SwapCoppia(ci1, ci2);
		
		System.out.println(ci1);
		System.out.println(ci2);
		
		int arr[] = {0,1,2,3,4,5,6,7,8,9};
		
		for(int i = 0; i<arr.length; i++)
			System.out.println(arr[i]);
		
		SwapArr(arr, 1, 2);
		System.out.println();
		
		for(int i = 0; i<arr.length; i++)
			System.out.println(arr[i]);
	}
	
	public static <T1, T2> void SwapCoppia(Coppia<T1, T2> ci1, Coppia<T1, T2> ci2) {
		
		Coppia<T1, T2> ci3 = new Coppia<T1, T2>(ci1.getPrimo(), ci1.getSecondo());
		
		ci1.setPrimo(ci2.getPrimo());
		ci1.setSecondo(ci2.getSecondo());
		
		ci2.setPrimo(ci3.getPrimo());
		ci2.setSecondo(ci3.getSecondo());
	}
	
	public static int[] SwapArr(int[] num, int p1, int p2) {
		
		int appo = num[p1];
		num[p1] = num[p2];
		num[p2] = appo;
		
		return num;
	}
	
}


