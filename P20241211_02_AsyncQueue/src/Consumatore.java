import java.util.Random;

public class Consumatore extends Thread {
	public void run() {
		Random rng = new Random();
		Integer somma=0;
		Integer quanti=0;
		Integer tempo=0; //in millisecondi!
		while (true) {
			if (tempo > 2000) {
				//Sono trascorsi più di due secondi
				System.out.println("Elementi letti: " + quanti);
				if (quanti > 0) {
					System.out.println("Totale finora: " + somma + ". Media finora: " + somma/(1.0*quanti));
				}
				tempo=0;
			}
			while (Main.CodaVuota()) {
				try {
					System.out.print(".");
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tempo+=10;
			}
			System.out.println();
			Integer num = Main.PullCoda(); //prendo un elemento dalla coda
			quanti++;
			somma+=num;
			try {
				int sleep = rng.nextInt(100, 500);
				tempo += sleep;
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}