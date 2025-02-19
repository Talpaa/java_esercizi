
public class Thread3 implements Runnable {
	public void run() {
		
		for(int i = 1; i<6; i++) {
			
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		
		Thread  t3a = new Thread(new Thread3());
		Thread  t3b = new Thread(new Thread3());
		t3a.start();
		t3b.start();
	}
}