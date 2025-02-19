        /*
         * Definire la classe astratta Automezzo con attributi
         * - numero di ruote
         * - carburante
         * e con il metodo astratto getMaxSpeed()
         */
public abstract class Automezzo implements Comparable<Automezzo>{

	Integer ruote;
	Double carburante;
	public Automezzo() {
		super();
	}
	public Automezzo(Integer ruote, Double carburante) {
		super();
		this.ruote = ruote;
		this.carburante = carburante;
	}
	public Integer getRuote() {
		return ruote;
	}
	public void setRuote(Integer ruote) {
		this.ruote = ruote;
	}
	public Double getCarburante() {
		return carburante;
	}
	public void setCarburante(Double carburante) {
		this.carburante = carburante;
	}
	@Override
	public String toString() {
		return "Automezzo [ruote=" + ruote + ", carburante=" + carburante + ", Velocità massima=" + getMaxSpeed() + "]";
	}
	
	public abstract String getMaxSpeed();
	public abstract Double getConsumo();
	
	public int compareTo(Automezzo o) {
		
		if ((getMaxSpeed().compareTo(o.getMaxSpeed())) != 0) {
			
			return getMaxSpeed().compareTo(o.getMaxSpeed());
			
		}else if ( (getConsumo()- o.getConsumo()) != 0 ) {
				
			return (int)(getConsumo()- o.getConsumo());
				
		}else {return 0;}
	}
}
