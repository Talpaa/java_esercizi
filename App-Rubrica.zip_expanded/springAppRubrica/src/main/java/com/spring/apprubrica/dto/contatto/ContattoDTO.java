package com.spring.apprubrica.dto.contatto;

import java.util.Date;

public class ContattoDTO {

	private Integer id;
	private String nome;
	private String cognome;
	private Integer numero;
	private String gruppoDiAppartenenza;
	private Date annoNascita;
	private Boolean preferito;
	
	public ContattoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ContattoDTO(Integer id, String nome, String cognome, int numero,
			Date annoNascita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppoDiAppartenenza = "Default";
		this.annoNascita = annoNascita;
		this.preferito = false;
	}
	
	public ContattoDTO(Integer id, String nome, String cognome, int numero, String gruppoAppartenenza,
			Date annoNascita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppoDiAppartenenza = gruppoAppartenenza;
		this.annoNascita = annoNascita;
		this.preferito = false;
	}
	
	public ContattoDTO(Integer id, String nome, String cognome, int numero,
			Date annoNascita, boolean preferito) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppoDiAppartenenza = "Default";
		this.annoNascita = annoNascita;
		this.preferito = preferito;
	}

	public ContattoDTO(Integer id, String nome, String cognome, int numero, String gruppoDiAppartenenza,
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
}
