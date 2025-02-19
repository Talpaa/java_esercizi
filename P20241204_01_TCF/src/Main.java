import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Random rng = new Random();
		
		for (int i=0;i<20;i++) {
			int a = rng.nextInt(10);
			int b = rng.nextInt(10);
			Integer num = Dividi(a, b);
			//System.out.println("la divisione tra " + a + " e " + b + " è uguale a " + num);
		}
	}

	private static Integer Dividi(int i, int j) {
		try {
			Integer q = i/j;
			System.out.print("ok ");
			return q;
		}catch (Exception ex) {
			//ex.printStackTrace();
			System.out.print("ko ");
			return null;
		}
	}

}
