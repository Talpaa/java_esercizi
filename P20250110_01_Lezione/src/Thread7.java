public class Thread7 extends Thread {

	@Override
	public void run() {
		
		System.out.println();
		System.out.println(this.getName() + " " + this.getState());
		
	}
	
	public static void main(String[] args) {
		
		Thread7 t7 = new Thread7();
		
		System.out.println();
		System.out.println(t7.getName() + " " + t7.getState());
		
		t7.start();
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println(t7.getName() + " " + t7.getState());
	}
}
