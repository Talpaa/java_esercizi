/*
 Una classe Cliente con ID del cliente, nome, cognome, e-mail, password etc.
 */

import java.util.LinkedList;

public class Cliente {

	String ID;
	String nome;
	String cognome;
	String email;
	String password;
	LinkedList<Prodotto> acquisti;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String iD, String nome, String cognome, String email, String password) {
		super();
		ID = iD;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.acquisti = new LinkedList<Prodotto>();
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		password = password;
	}
	
	public void acquistaProdotto(Prodotto prodotto) {
		acquisti.add(prodotto);
		System.out.println("Prodotto acquistato");
	}

	@Override
	public String toString() {
		
		String mes = "";
		
		for(Prodotto prodotto: acquisti) {
			
			mes += " - " + prodotto.toString() + "\n";
		}
		
		return "\nCliente [ID=" + ID + ", Nome=" + nome + ", Cognome=" + cognome + ", Email=" + email + ", Password="
				+ password + "] \n\nAcquisti: \n" + mes;
	}
}
