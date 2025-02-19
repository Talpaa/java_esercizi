/*
Un thread legge i messaggi dalla casella di posta è si ferma quando la casella è vuota. 
Riprende a leggere i messaggi quando la casella contiene almeno un messaggio.
Creare una classe che scrive i messaggi, 
una classe che legge i messaggi e una classe di test che attiva i due thread.
 */
public class Main {

	public static void main(String[] args) {
		
		CasellaPostale casella = new CasellaPostale();
		Mail mail = new Mail("mittente@gmail.com", "destinatario@gmail.com", "SPAM", "Questa mail è inutile.");
		
		Thread  invio = new InvioMail(mail, casella);
		Thread  leggi = new LeggiMail(mail, casella);
		
		invio.start();
		leggi.start();

	}

}
