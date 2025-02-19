
public class Thread6 extends Thread {
	
	@Override
	public void run() {

		System.out.println();
		System.out.println(this.getName());
		System.out.println(this.getState());
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println(this.getName());
		System.out.println(this.getState());
		
	}

	public static void main(String[] args) {
		
		Thread6 t6a = new Thread6();
		Thread6 t6b = new Thread6();
		
		t6a.start();
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t6a.setName("Thread 0");
		
		t6b.start();
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t6b.setName("Thread 1");
	}
}
