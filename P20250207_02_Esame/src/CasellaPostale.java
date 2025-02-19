import java.util.LinkedList;

public class CasellaPostale {

	LinkedList<Mail> mails = new LinkedList<Mail>();

	public CasellaPostale() {
		super();
	}
	
	public void AddMail(Mail mail) {
		
		if (mails.size() < 10) {
			mails.add(mail);
			System.out.println(" - Mail aggiunta.");
		}else {
			System.out.println(" - Mail non aggiunta, troppe mail nella casella postale.");
		}
	}
	
	public void ReadsMail() {
		

		if (mails.size() > 0) {
			mails.remove(mails.removeFirst());
			System.out.println(" - Mail letta.");
		}else {
			System.out.println(" - Mail non letta, non ci sono più mail nella casella postale.");
		}
	}
}
