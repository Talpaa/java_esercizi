/*
 Due o più classi (es. Smartphone, Televisore) che estendono la classe prodotto 
	e hanno altre caratteristiche.
 */

import java.util.LinkedList;

public class Televisore extends Prodotto {

	String marca;

	public Televisore() {
		super();
	}
	
	public Televisore(String id, String nome, String descrizione, String prezzo, LinkedList<String> negozi, String marca) {
		super();
		ID = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.negozi = negozi;
		this.marca = marca;
	}

	public String getModello() {
		return marca;
	}

	public void setModello(String modello) {
		this.marca = modello;
	}

	@Override
	public String toString() {
		return "Televisore [marca=" + marca + super.toString() + "]";
	}
}
