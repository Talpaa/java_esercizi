public class Ghepardo extends Mammifero implements Must, Req{

	private Double speed;
	
	@Override
	public String Verso() {
		return "Roar";
	}

	@Override
	public String toString() {
		return "Ghepardo [getFreqResp()=" + getFreqResp() + ", getFreqCardio()=" + getFreqCardio() + "]";
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Ghepardo() {
		super();
	}

	public Ghepardo(Integer freqResp, Integer freqCardio, Double speed) {
		super(freqResp, freqCardio);
		this.speed = speed;
	}

	@Override
	public String GetClassName() {
		return "Ghepardo";
	}

	@Override
	public String GetVersion() {
		return "1.0";
	}

	@Override
	public String GetSerial() {
		return "AI48";
	}
}
