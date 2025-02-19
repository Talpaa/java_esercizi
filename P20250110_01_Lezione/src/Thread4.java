
public class Thread4 extends Thread{

	public void run() {
		
		for(int i = 1; i<6; i++) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		
		Thread  t4a = new Thread4();
		Thread  t4b = new Thread4();
		t4a.start();
		t4b.start();
	}
}
