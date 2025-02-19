import java.sql.Date;
import java.time.Year;

public class Computer {
	 
	private static int quantita = 0;
	
	private double prezzo;
	private String peso;
	private String larghezza;
	private String altezza;
	private String profondita;
	private String produttore;
	private String annoProduzione;
	
	
	
	public int getQuantita() {
		return quantita;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public String getPeso() {
		return peso;
	}
	public String getLarghezza() {
		return larghezza;
	}
	public String getAltezza() {
		return altezza;
	}
	public String getProfondita() {
		return profondita;
	}
	public String getProduttore() {
		return produttore;
	}
	public String getAnnoProduzione() {
		return annoProduzione;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public void setLarghezza(String larghezza) {
		this.larghezza = larghezza;
	}
	public void setAltezza(String altezza) {
		this.altezza = altezza;
	}
	public void setProfondita(String profondita) {
		this.profondita = profondita;
	}
	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}
	public void setAnnoProduzione(String annoProduzione) {
		this.annoProduzione = annoProduzione;
	}

	public Computer(double prezzo, String peso, String larghezza, String altezza, String profondita, String produttore, String annoProduzione) {
		
		super();
		
		this.quantita += 1;
		
		this.prezzo = prezzo;
		this.peso = peso;
		this.larghezza = larghezza;
		this.altezza = altezza;
		this.profondita = profondita;
		this.produttore = produttore;
		this.annoProduzione = annoProduzione;
	}
}
