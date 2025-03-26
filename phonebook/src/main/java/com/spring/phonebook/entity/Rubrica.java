package com.spring.phonebook.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Rubrica {

	@Id
	private int idRubrica;
	
	private String proprietario;
	private Integer annoCreazione;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_Rubrica")
	private List<Contatto> contatti = new ArrayList<Contatto>();
	
	public Rubrica() {
		// TODO Auto-generated constructor stub
	}

	public Rubrica(int idRubrica, String proprietario, Integer annoCreazione) {
		super();
		this.idRubrica = idRubrica;
		this.proprietario = proprietario;
		this.annoCreazione = annoCreazione;
	}

	public int getIdRubrica() {
		return idRubrica;
	}

	public void setIdRubrica(int idRubrica) {
		this.idRubrica = idRubrica;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public Integer getAnnoCreazione() {
		return annoCreazione;
	}

	public void setAnnoCreazione(Integer annoCreazione) {
		this.annoCreazione = annoCreazione;
	}

	public List<Contatto> getContatti() {
		return contatti;
	}

	public void setContatti(List<Contatto> contatti) {
		this.contatti = contatti;
	}
	
	//aggiungo qualche metodo di business
	
	public void addContatto(Contatto contatto) {
		contatti.add(contatto);
	}
}

/*
 [
  {
    "idRubrica": 1, "proprietario": "Mario Rossi", "annoCreazione": 2024
  },
  {
    "idRubrica": 2, "proprietario": "Giulia Verdi", "annoCreazione": 2023
  },
  {
    "idRubrica": 3, "proprietario": "Alessandro Neri", "annoCreazione": 2022
  },
  {
    "idRubrica": 4, "proprietario": "Francesca Blu", "annoCreazione": 2021
  },
  {
    "idRubrica": 5, "proprietario": "Roberto Grigio", "annoCreazione": 2020
  }
 ]
 */
