package com.spring.impiegato.dto;

public class ImpiegatoDTO {

private Integer matricola;
	
	private String nome;
	private String cognome;
	private Double salario;
	
	public ImpiegatoDTO() {}

	public ImpiegatoDTO(Integer matricola, String nome, String cognome, Double salario) {
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
