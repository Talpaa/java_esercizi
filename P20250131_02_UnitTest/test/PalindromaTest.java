import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromaTest {

	@Test
	void testPalindromaVera1() {
		
		assertTrue( (Palindroma.palindroma("anna")) ,"La parola anche se palindroma rinorna false");
		
	}
	
	@Test
	void testPalindromaVera2() {
		
		assertTrue( (Palindroma.palindroma("anxna")) ,"La parola anche se palindroma rinorna false");
		
	}

	@Test
	void testPalindromaFalsa() {
		
		assertEquals(false, Palindroma.palindroma("anzxna"));
		assertFalse( (Palindroma.palindroma("anzxna")), "La parola anche se non è palindroma rinorna true");
	}
}
