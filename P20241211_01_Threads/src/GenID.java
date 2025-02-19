import java.util.Random;

public class GenID extends Thread {

	static long ID=0;
	
	public void run() {
		
		Random rng = new Random();
		
		while (true) {
			
			ID += 1;
			//Simulare un minimo tempo di calcolo
			try {
				Thread.sleep(rng.nextInt(100, 3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(ID);
			
		}
	}
}
