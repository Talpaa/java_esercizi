package com.spring.magazzino.dto;

public class ProdottoDTO {

	private int id;
	private String marca;
	private String modello;
	private String descrizione;
	private Double prezzoConsigliato;
	private Double prezzoMax;
	private int quantità;
	private String categoria;
	
	
	public ProdottoDTO() {
		// TODO Auto-generated constructor stub
	}


	public ProdottoDTO(int id, String marca, String modello, String descrizione, Double prezzoConsigliato,
			Double prezzoMax, int quantità, String categoria) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.descrizione = descrizione;
		this.prezzoConsigliato = prezzoConsigliato;
		this.prezzoMax = prezzoMax;
		this.quantità = quantità;
		this.categoria = categoria;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModello() {
		return modello;
	}


	public void setModello(String modello) {
		this.modello = modello;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Double getPrezzoConsigliato() {
		return prezzoConsigliato;
	}


	public void setPrezzoConsigliato(Double prezzoConsigliato) {
		this.prezzoConsigliato = prezzoConsigliato;
	}


	public Double getPrezzoMax() {
		return prezzoMax;
	}


	public void setPrezzoMax(Double prezzoMax) {
		this.prezzoMax = prezzoMax;
	}


	public int getQuantità() {
		return quantità;
	}


	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}

