import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContatoreTest {

	@Test
	void testConteggio1() {
		
		assertEquals(3, Contatore.conteggio("Li vuoi quei kiwi", ' '));
	}
	
	@Test
	void testConteggio2() {
		
		assertEquals(2, Contatore.conteggio("Li vuoi quei kiwi", ' '));
	}
	
	@Test
	void testConteggio3() {
		
		assertEquals(0, Contatore.conteggio("Li vuoi quei kiwi", '.'));
	}

}
