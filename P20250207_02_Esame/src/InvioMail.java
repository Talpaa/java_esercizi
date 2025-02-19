/*
Un thread scrive dei messaggi in una casella di posta che può contenere al massimo 10 messaggi 
e si ferma quando la casella è piena. Riprende a scrivere messaggi quando almeno un messaggio viene letto.
 */
public class InvioMail extends Thread {
	
	private Mail mail;
	private CasellaPostale casella;
	
	public InvioMail(Mail mail, CasellaPostale casella) {
		super();
		this.mail = mail;
		this.casella = casella;
	}
	
	public void run() {
		while(true) {
			casella.AddMail(mail);

			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
