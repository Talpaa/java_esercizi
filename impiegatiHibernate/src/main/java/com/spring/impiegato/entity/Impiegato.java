package com.spring.impiegato.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Impiegato {

	@Id
	private Integer matricola;
	
	private String nome;
	private String cognome;
	private Double salario;
	
	public Impiegato() {}

	public Impiegato(Integer matricola, String nome, String cognome, Double salario) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.salario = salario;
	}

	public Integer getMatricola() {
		return matricola;
	}

	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
}
