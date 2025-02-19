
public class Main {

	public static void main(String[] l) {

		/*
		MyThread th1 = new MyThread(1000);
		//th1.run();
		th1.start();

		MyThread th2 = new MyThread(1000);
		//th2.run();
		th2.start();
		
		//System.exit(0);
		 */
		
		for (int i=0; i<100; i++) {
			new GenID().start();
		}
		
		/*
		 * GenID id1 = new GenID(); id1.start(); 
		 * GenID id2 = new GenID(); id2.start();
		 * GenID id3 = new GenID(); id3.start(); 
		 * GenID id4 = new GenID(); id4.start();
		 */
	}
}
