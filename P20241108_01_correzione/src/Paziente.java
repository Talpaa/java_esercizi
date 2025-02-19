
public class Paziente extends Persona implements Specs{
	
	private String illness;
	private Boolean codiceRosso;
	
	public Paziente() {
		super();
	}

	public Paziente(String nome, String cognome, int età, String illness, Boolean codiceRosso) {
		super(nome, cognome, età);
		this.illness = illness;
		this.codiceRosso = codiceRosso;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public Boolean getCodiceRosso() {
		return codiceRosso;
	}

	public void setCodiceRosso(Boolean codiceRosso) {
		this.codiceRosso = codiceRosso;
	}

	@Override
	public String toString() {
		return "Paziente [Illness=" + illness + ", Codice Rosso=" + codiceRosso + ", Nome=" + getNome()
				+ ", Cognome=" + getCognome() + ", Età=" + getEtà() + "]";
	}

	@Override
	public String GetVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
