public class Studente extends Persona{
	
	private String matricola;

	public Studente(String matricola) {
		super();
		this.matricola = matricola;
	}

	public Studente(String nome, String cognome, int età, String matricola) {
		super(nome, cognome, età);
		this.matricola = matricola;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	@Override
	public String toString() {
		return "Studente [matricola: " + matricola + " nome: " + super.getNome() + " cognome: " + super.getCognome() + " età: " + super.getEtà() + "]";
	}
	
	public String Stampa(Studente studenti[]) {
		
		String mess = "";
		
		for (int i = 0; i < studenti.length; i++) {
			
			if (studenti[i] != null) {

				mess += "		" + studenti[i] + "\n";
				
			}else {
				mess += "Studenti finiti";
				break;
			}
			
		}
		
		return mess;
	}
	
}
