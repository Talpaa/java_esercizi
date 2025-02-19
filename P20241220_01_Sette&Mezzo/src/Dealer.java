import java.util.LinkedList;

public class Dealer {

	private String name = "Dealer";

	private LinkedList<Integer> mano = new LinkedList<Integer>();
	
	public Dealer() {
		super();
	}
	
	public void AddCard(Integer carta) {
		
		mano.add(carta);
	}
	
	public Double Punteggio() {
		
		Double punteggio = 0.0;
		Double val = 0.0;
		
		for (Integer carta : mano) {
			
			if (carta > 30) {
				val = (double)carta - 30.0;
			}else if (carta > 20) {
				val = (double)carta - 20.0;				
			}else if (val > 10)
				val = (double)carta - 10.0;
			
			if (val> 7) {
				punteggio += 0.5;
			}else {
				punteggio += val;
			}
		}
		return punteggio;
	}
	
	public String getName() {
		return name;
	}

	public LinkedList<Integer> getMano() {
		return mano;
	}
}
