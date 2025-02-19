import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArchivioTest {

	@Test
	void testAddStudente() {
		String matricola = "1871744";
		String nome = "carlo";
		String cognome = "carli";
		
		Studente stud = new Studente(matricola, nome, cognome);
		
		Archivio arc = new Archivio();
		
		assertEquals(0, arc.NumeroStudenti());
		
		arc.AddStudente(stud);
		arc.AddStudente(stud);
		arc.AddStudente(stud);
		arc.AddStudente(stud);
		arc.AddStudente(stud);
	
		assertEquals(1, arc.NumeroStudenti());
		
		arc.DeleteStudente(stud);assertEquals(0, arc.NumeroStudenti());
	}

	@Test
	void testDeleteStudente() {
		String matricola = "1871744";
		String nome = "carlo";
		String cognome = "carli";
		
		Studente stud = new Studente(matricola, nome, cognome);
		
		Archivio arc = new Archivio();
		
		assertEquals(0, arc.NumeroStudenti());
		
		arc.AddStudente(stud);
	
		assertEquals(1, arc.NumeroStudenti());
		
		arc.DeleteStudente(stud);

		assertEquals(0, arc.NumeroStudenti());
		
	}

	@Test
	void testDeleteAllStudent() {
		String matricola1 = "1871744";
		String matricola2 = "1871745";
		String matricola3 = "1871746";
		String nome1 = "carlo";
		String nome2 = "carla";
		String nome3 = "carletto";
		String cognome1 = "carli";
		String cognome2 = "carli";
		String cognome3 = "carli";
		
		Studente stud1 = new Studente(matricola1, nome1, cognome1);
		Studente stud2 = new Studente(matricola2, nome2, cognome2);
		Studente stud3 = new Studente(matricola3, nome3, cognome3);
		
		Archivio arc = new Archivio();
		assertEquals(0, arc.NumeroStudenti());
		
		arc.AddStudente(stud1);
		assertEquals(1, arc.NumeroStudenti());
		arc.AddStudente(stud2);
		assertEquals(2, arc.NumeroStudenti());
		arc.AddStudente(stud3);
		assertEquals(3, arc.NumeroStudenti());
		
		arc.DeleteAllStudent();
		assertEquals(0, arc.NumeroStudenti());
		
		
	}

}
