import java.util.Random;

public class Produttore extends Thread {

	public void run() {
		Random rng = new Random();
		while (true) {
			Integer num = rng.nextInt(0, 1000);
			Main.PushCoda(num);
			try {
				Thread.sleep(rng.nextInt(100, 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}