public class Studente extends Persona implements Comparable<Studente>{
	
	public static int studentiCreati = 0;
	
	private String corso;
	private String annoFrequenza;

	public Studente() {
		super();
	}

	public Studente(String nome, String cognome, int età, String corso, String annoFrequenza) {
		super(nome, cognome, età);
		this.corso = corso;
		this.annoFrequenza = annoFrequenza;
		
		studentiCreati++;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public String getAnnoFrequenza() {
		return annoFrequenza;
	}

	public void setAnnoFrequenza(String annoFrequenza) {
		this.annoFrequenza = annoFrequenza;
	}

	@Override
	public String toString() {
		return "\nStudente [Corso=" + corso + ", Anno di Frequenza=" + annoFrequenza + ", Nome=" + getNome()
				+ ", Cognome=" + getCognome() + ", Età=" + getEtà() + "]";
	}

	@Override
	public int compareTo(Studente o) {
		
		if ((getNome().compareTo(o.getNome())) != 0) {
			
			return getNome().compareTo(o.getNome());
			
		}else if ( (getEtà()- o.getEtà()) != 0 ) {
				
			return (getEtà()- o.getEtà());
				
		}else if ( (getCorso().compareTo(o.getCorso())) != 0 ){
				
			return (getCorso().compareTo(o.getCorso()));
				
		}else if ( (getAnnoFrequenza().compareTo(o.getAnnoFrequenza())) != 0 ){
			
			return (getAnnoFrequenza().compareTo(o.getAnnoFrequenza()));
			
		}else {return 0;}
	}
}
