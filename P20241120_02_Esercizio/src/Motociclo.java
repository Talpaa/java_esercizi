		/* Definire due classi figlie di Automezzo: Motociclo e Autovettura
         * che aggiungono gli attributi cilindrata e consumo
         */
public class Motociclo extends Automezzo{

	Integer cilindrata;
	Double consumo;
	
	
	
	public Motociclo() {
		super();
	}

	public Motociclo(Integer ruote, Double carburante, Integer cilindrata, Double consumo) {
		super(ruote, carburante);
		this.cilindrata = cilindrata;
		this.consumo = consumo;
	}

	public Integer getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(Integer cilindrata) {
		this.cilindrata = cilindrata;
	}

	@Override
	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}

	@Override
	public String toString() {
		return "Motociclo [cilindrata=" + cilindrata + ", consumo=" + consumo + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public String getMaxSpeed() {
		return "150";
	}
}
