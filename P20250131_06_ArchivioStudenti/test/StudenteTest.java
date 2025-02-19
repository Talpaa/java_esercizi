import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudenteTest {

	@Test
	void testEmptyConstructor() {
		
		Studente stud = new Studente();
		
		assertEquals(null, stud.getNome());
		assertEquals(null, stud.getCognome());
		assertEquals(null, stud.getMatricola());
	}

	@Test
	void testConstructor() {
		
		String matricola = "1871744";
		String nome = "carlo";
		String cognome = "carli";
		
		Studente stud = new Studente(matricola, nome, cognome);
		
		assertEquals(matricola, stud.getMatricola());
		assertEquals(nome, stud.getNome());
		assertEquals(cognome, stud.getCognome());
	}

	@Test
	void testToString() {
		String matricola = "1871744";
		String nome = "carlo";
		String cognome = "carli";
		
		Studente stud = new Studente(matricola, nome, cognome);
		
		assertEquals("Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + "]", stud.toString());
	}

}
