import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

	public static void main(String[] args) {
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
		
		System.out.println(arc.NumeroStudenti());
		
		arc.AddStudente(stud1);System.out.println(arc.NumeroStudenti());
		arc.AddStudente(stud2);System.out.println(arc.NumeroStudenti());
		arc.AddStudente(stud3);
		
		System.out.println(arc.NumeroStudenti());
		
		arc.DeleteAllStudent();

		System.out.println(arc.NumeroStudenti());
	}

}
