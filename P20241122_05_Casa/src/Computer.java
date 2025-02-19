public class Computer {
	 
	private static int quantita = 0;
	
	private double prezzo;
	private double peso;
	private double larghezza;
	private double altezza;
	private double profondita;
	private String produttore;
	private int annoProduzione;
	
	
	
	public static int getQuantita() {
		return quantita;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public double getPeso() {
		return peso;
	}
	public double getLarghezza() {
		return larghezza;
	}
	public double getAltezza() {
		return altezza;
	}
	public double getProfondita() {
		return profondita;
	}
	public String getProduttore() {
		return produttore;
	}
	public int getAnnoProduzione() {
		return annoProduzione;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setLarghezza(double larghezza) {
		this.larghezza = larghezza;
	}
	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	public void setProfondita(double profondita) {
		this.profondita = profondita;
	}
	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}
	public void setAnnoProduzione(int annoProduzione) {
		this.annoProduzione = annoProduzione;
	}

	public Computer(double prezzo, double peso, double larghezza, double altezza, double profondita, String produttore, int annoProduzione) {
		
		super();
		
		Computer.quantita += 1;
		
		this.prezzo = prezzo;
		this.peso = peso;
		this.larghezza = larghezza;
		this.altezza = altezza;
		this.profondita = profondita;
		this.produttore = produttore;
		this.annoProduzione = annoProduzione;
	}
	
	public void stamp() {
		
		String mess = "\n_____________________________"
					+ "\n|Prezzo: %.2f €|" 
					+ "\n|Anno di produzione: %d|" 
					+ "\n|Produttore: %s|" 
					+ "\n|Peso: %.2f g|" 
					+ "\n|Altezza: %.2f cm|"  
					+ "\n|Larghezza: %.2f cm|" 
					+ "\n|Profondità: %.2f cm|" 
					+ "\n|___________________________|";
		
		System.out.printf(mess, this.getPrezzo(), this.getAnnoProduzione(), this.getProduttore(), this.getPeso(), this.getAltezza(), this.getLarghezza(), this.getProfondita());
	}
}
