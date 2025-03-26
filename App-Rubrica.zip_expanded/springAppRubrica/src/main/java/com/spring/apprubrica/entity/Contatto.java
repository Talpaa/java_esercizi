package com.spring.apprubrica.entity;

import java.util.Date;

public class Contatto {

	private Integer id;
	private String nome;
	private String cognome;
	private Integer numero;
	private String gruppoDiAppartenenza;
	private Date annoNascita;
	private Boolean preferito;
	
	public Contatto() {
		// TODO Auto-generated constructor stub
	}

	public Contatto(Integer id, String nome, String cognome, Integer numero, String gruppoDiAppartenenza,
			Date annoNascita, Boolean preferito) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppoDiAppartenenza = gruppoDiAppartenenza;
		this.annoNascita = annoNascita;
		this.preferito = preferito;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getGruppoDiAppartenenza() {
		return gruppoDiAppartenenza;
	}

	public void setGruppoDiAppartenenza(String gruppoDiAppartenenza) {
		this.gruppoDiAppartenenza = gruppoDiAppartenenza;
	}

	public Date getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(Date annoNascita) {
		this.annoNascita = annoNascita;
	}

	public Boolean getPreferito() {
		return preferito;
	}

	public void setPreferito(Boolean preferito) {
		this.preferito = preferito;
	}

	@Override
	public String toString() {
		return "Contatto [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", numero=" + numero
				+ ", gruppoDiAppartenenza=" + gruppoDiAppartenenza + ", annoNascita=" + annoNascita + ", preferito="
				+ preferito + "]";
	}
}
