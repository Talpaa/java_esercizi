package com.spring.apprubrica.entity;

import java.util.HashMap;
import java.util.Map;

public class Rubrica {

	private Integer id;
	private String proprietario;
	private int anno;
	private Map<Integer, Contatto> contatti = new HashMap<>();
	
	public Rubrica() {
		// TODO Auto-generated constructor stub
	}

	public Rubrica(Integer id, String proprietario, int anno, Map<Integer, Contatto> contatti) {
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

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public Map<Integer, Contatto> getContatti() {
		return contatti;
	}

	public void setContatti(Map<Integer, Contatto> contatti) {
		this.contatti = contatti;
	}
}
