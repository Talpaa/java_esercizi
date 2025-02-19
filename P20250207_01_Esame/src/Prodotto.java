/*
Una classe Prodotto 
	con ID del prodotto, nome, descrizione, prezzo e lista dei negozi che lo vendono.
*/

import java.util.LinkedList;

public class Prodotto {
	
	String ID;
	String nome;
	String descrizione;
	String prezzo;
	LinkedList<String> negozi = new LinkedList<String>();
	
	public Prodotto() {
		super();
	}
	
	public Prodotto(String id, String nome, String descrizione, String prezzo, LinkedList<String> negozi) {
		super();
		ID = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.negozi = negozi;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public LinkedList<String> getNegozi() {
		return negozi;
	}

	public void setNegozi(LinkedList<String> negozi) {
		this.negozi = negozi;
	}

	@Override
	public String toString() {
		return "Prodotto [ID=" + ID + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzo=" + prezzo
				+ " €, negozi=" + negozi + "]";
	}
	
	
}
