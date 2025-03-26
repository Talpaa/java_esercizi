package com.spring.phonebook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contatto {

	@Id
	private int idContatto;
	
	private String nome;
	private String cognome;
	private String numero;
	
	public Contatto() {
		// TODO Auto-generated constructor stub
	}

	public Contatto(int idContatto, String nome, String cognome, String numero) {
		super();
		this.idContatto = idContatto;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
	}

	public int getIdContatto() {
		return idContatto;
	}

	public void setIdContatto(int idContatto) {
		this.idContatto = idContatto;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}

/*
 [
  {
    "idContatto": 1, "nome": "Luca", "cognome": "Bianchi", "numero": "1234567890"
  },
  {
    "idContatto": 2, "nome": "Anna", "cognome": "Verdi", "numero": "0987654321"
  },
  {
    "idContatto": 3, "nome": "Marco", "cognome": "Rossi", "numero": "1112223333"
  },
  {
    "idContatto": 4, "nome": "Elena", "cognome": "Neri", "numero": "4445556666"
  },
  {
    "idContatto": 5, "nome": "Sara", "cognome": "Gialli", "numero": "7778889999"
  }
 ]
 */
