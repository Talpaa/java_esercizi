package com.spring.phonebook.dto;

import java.util.ArrayList;
import java.util.List;

public class RubricaDTO {

	private int idRubrica;
	
	private String proprietario;
	private Integer annoCreazione;
	
	private List<ContattoDTO> contatti = new ArrayList<ContattoDTO>();
	
	public RubricaDTO() {
		// TODO Auto-generated constructor stub
	}

	public RubricaDTO(int idRubrica, String proprietario, Integer annoCreazione) {
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

	public List<ContattoDTO> getContatti() {
		return contatti;
	}

	public void setContatti(List<ContattoDTO> contatti) {
		this.contatti = contatti;
	}
	
	//aggiungo qualche metodo di business
	
	public void addContatto(ContattoDTO contatto) {
		contatti.add(contatto);
	}
}
