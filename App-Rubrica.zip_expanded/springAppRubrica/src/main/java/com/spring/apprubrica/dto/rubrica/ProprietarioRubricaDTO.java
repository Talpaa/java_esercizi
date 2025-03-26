package com.spring.apprubrica.dto.rubrica;

public class ProprietarioRubricaDTO {

	private String proprietario;
	private Integer numNumeri;
	
	public ProprietarioRubricaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProprietarioRubricaDTO(String proprietario, Integer numNumeri) {
		super();
		this.proprietario = proprietario;
		this.numNumeri = numNumeri;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public Integer getNumeri() {
		return numNumeri;
	}

	public void setNumeri(Integer numNumeri) {
		this.numNumeri = numNumeri;
	}
}
