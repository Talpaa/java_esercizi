package com.spring.apprubrica.dto.contatto;

import java.util.Date;

public class ContattoNoIDDTO {

	private String nome;
	private String cognome;
	private Integer numero;
	private String gruppoDiAppartenenza;
	private Date annoNascita;
	private Boolean preferito;
	
	public ContattoNoIDDTO() {
		// TODO Auto-generated constructor stub
	}

	public ContattoNoIDDTO(String nome, String cognome, int numero, String gruppoDiAppartenenza,
			Date annoNascita, Boolean preferito) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppoDiAppartenenza = gruppoDiAppartenenza;
		this.annoNascita = annoNascita;
		this.preferito = preferito;
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
}
