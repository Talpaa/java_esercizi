import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalcolatriceTest {

	@Test
	void testSomma() {
		assertEquals(2.0, Calcolatrice.somma("1", "1"));
		assertEquals(2.5, Calcolatrice.somma("1.5", "1"));
	}

	@Test
	void testSottrazione() {
		assertEquals(0.0, Calcolatrice.sottrazione("1", "1"));
	}

	@Test
	void testMoltiplicazione() {
		assertEquals(1.0, Calcolatrice.moltiplicazione("1", "1"));
	}

	@Test
	void testDivisione() {
		assertEquals(1.0, Calcolatrice.divisione("1", "1"));
	}

}
