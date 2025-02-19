import java.util.Random;

public class Esempi1 {

	public static void main(String[] args) {
		/*
		 * Usualmente nei linguaggi di programmazione abbiamo diversi generatori di
		 * numeri "pseudocasuali" A volte ci sono generatori "crittografici" che cercano
		 * di essere meno pseudocasuali e quindi più casuali in tal caso questi
		 * generatori sono legati a eventi esterni al programma: temperatura della CPU,
		 * temperatura del DISCO, temperatura esterna, velocità della CPU, digitazione
		 * dei tasti della tastiera, velocità delle rete, ecc., che accompagnano
		 * "aggiungendo un bias", un generatore standard pseudocasuale Il più banale
		 * generatore pseudocasuale? => SempliceRnd In generale c'è sempre un generatore
		 * random che genera valori double tra 0.0 e 1.0 (escluso) In java abbiamo ad
		 * esempio Math.random()
		 */

		// Random è anche una classe
		Random rng = new Random();

		StampaConCornice();
	}

	private static int Xi;

	public static void SempliceRnd(int seed) {
		Xi = seed;
	}

	public static int SempliceRnd() {
		Xi = (Xi * 12371523 + 498712) % 15624311;
		return Xi;
	}

	public static double GeneraDoubleTra0E1() {
		return Math.random();
	}

	// se per caso avessi bisogno di generare numeri double
	// compresi tra 0.0 e 1000.0 ?
	public static double GeneraDoubleTra0EN(double N) {
		double d = Math.random();
		return d * N;
	}

	// se per caso avessi bisogno di generare numeri double
	// compresi tra Inizio e Fine?
	public static double GeneraDoubleTraInizioEFine(double inizio, double fine) {
		double d = Math.random() * (fine - inizio) + inizio;

		return d;
	}

	static public String GeneraStringaRandom(int len) {
		String minuscole = "abcdefghijklmnopqrstuvwxyz";
		String maiuscole = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numeri = "0123456789";
		String speciali = ",.-;:_@#§°[]{}+^'?=)(/&%$£\"!\\|<>";

		String all = minuscole + maiuscole + numeri + speciali;
		String res = "";

		for (int i = 0; i < len; i++) {
			res += all.charAt((int) (Math.random() * all.length()));
		}
		return res;
	}

	public static void StampaIntestazioneOChiusura() {
		System.out.printf("+");
		for (int i = 0; i < 59; i++) {
			System.out.printf("-");
		}
		System.out.printf("+\n");
	}

	// Come stampare inserendo cornicette e quant'altro?
	public static void StampaConCornice() {
		/*
		 * come esempio Stampiamo le tabelline
		 * +-----------------------------------------------------------+ | 1 | 2 | 3 | 4
		 * | 5 | 6 | 7 | 8 | 9 | 10 | +-----------------------+ | 2 | 4 | 6 | 8 | 10 |
		 * +-----------------------+ | |
		 */

		// intestazione
		for (int base = 1; base <= 10; base++) {
			// intestazione riga
			StampaIntestazioneOChiusura();

			// valori riga
			// devo stampare | 3digit |
			for (int i = 1; i <= 10; i++) {
				System.out.printf("| %3d ", i * base);
			}
			System.out.printf("|\n");
		}
		StampaIntestazioneOChiusura();
	}

}