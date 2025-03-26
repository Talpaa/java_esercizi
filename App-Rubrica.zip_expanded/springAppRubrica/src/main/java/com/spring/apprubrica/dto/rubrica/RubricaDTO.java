package com.spring.apprubrica.dto.rubrica;

import java.util.HashMap;
import java.util.Map;

import com.spring.apprubrica.dto.contatto.ContattoDTO;
import com.spring.apprubrica.entity.Contatto;

public class RubricaDTO {
	
	private Integer id;
	private String proprietario;
	private int anno;
	private Map<Integer, ContattoDTO> contatti = new HashMap<>();

	public RubricaDTO() {
		// TODO Auto-generated constructor stub
	}

	public RubricaDTO(Integer id, String proprietario, int anno, Map<Integer, ContattoDTO> contatti) {
		super();
		this.id = id;
		this.proprietario = proprietario;
		this.anno = anno;
		this.contatti = contatti;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public Map<Integer, ContattoDTO> getContatti() {
		return contatti;
	}

	public void setContatti(Map<Integer, ContattoDTO> contatti) {
		this.contatti = contatti;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}
}
