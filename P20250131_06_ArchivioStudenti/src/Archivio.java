import java.util.LinkedList;

public class Archivio {

	private static LinkedList<Studente> studenti = new LinkedList<Studente>();

	public Archivio() {
		super();
	}
	
	public void AddStudente(Studente studente) {
		
		Boolean ris = true;
		
		for (Studente stud : studenti) {
			
			if (stud.getMatricola().equals(studente.getMatricola())) {
				
				ris = false;
			}
		}
		
		if (ris) {
			studenti.add(studente);
			System.out.println("Studente aggiunto.");
		}else {
			System.out.println("Studente già presente.");
		}
		
	}
	
	public void DeleteStudente(Studente studente) {
		
		Boolean ris = true;
		
		for (Studente stud : studenti) {
			
			if (stud.getMatricola().equals(studente.getMatricola())) {
				
				studenti.remove(studente);
				System.out.println("Studente rimosso.");
				
				ris = false;
			}
		}
		
		if (ris) {
			System.out.println("Studente Non presente.");
		}
		
	}
	
	public void DeleteAllStudent() {
		
		while(studenti.size() > 0) {
			
			studenti.remove(0);
		}
		
		System.out.println("Tutti gli studenti sono stati rimossi.");
	}
	
	public int NumeroStudenti() {
		return studenti.size();
	}
}
