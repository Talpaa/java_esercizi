public class Mail {

	String Mittente;
	String Destinatario;
	String Oggetto;
	String testo;
	
	public Mail() {
		super();
	}
	
	public Mail(String mittente, String destinatario, String oggetto, String testo) {
		super();
		Mittente = mittente;
		Destinatario = destinatario;
		Oggetto = oggetto;
		this.testo = testo;
	}
	
	
}
