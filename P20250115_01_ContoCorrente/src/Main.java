
public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		ClienteNonSync c1 = new ClienteNonSync("Mario", 20);
		ClienteSync c2 = new ClienteSync("Lucia", 50);
		// Avvio i Threads
		c1.start();
		c2.start();
		// Attendo il completamento
		c1.join();
		c2.join();

	}

}
