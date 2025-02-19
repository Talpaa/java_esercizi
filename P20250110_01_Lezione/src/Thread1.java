
public class Thread1 extends Thread {

	public void run() {
		System.out.println("Sono il primo Thread");
	}
	
	public static void main(String[] args) {
		
		Thread  t1 = new Thread1();
		t1.start();
	}
}
