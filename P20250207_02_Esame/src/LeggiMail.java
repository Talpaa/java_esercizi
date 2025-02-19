
public class LeggiMail extends Thread {

	private Mail mail;
	private CasellaPostale casella;
	
	public LeggiMail(Mail mail, CasellaPostale casella) {
		super();
		this.mail = mail;
		this.casella = casella;
	}
	
	public void run() {
		while(true) {
			casella.ReadsMail();
			
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
