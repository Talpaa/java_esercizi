import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromaTest {

	@Test
	void testPalindromaVera1() {
		
		assertEquals(true, Palindroma.palindroma("anna"));
	}
	
	@Test
	void testPalindromaVera2() {
		
		assertEquals(true, Palindroma.palindroma("anxna"));
	}

	@Test
	void testPalindromaFalsa() {
		
		assertEquals(false, Palindroma.palindroma("anzxna"));
	}
}
