package com.spring.apprubrica.dto.rubrica;

import java.util.List;

public class NomiENumeroProprietariDTO {

	private int numeroProprietari;
	private List<String> nomiProprietari;
	
	public NomiENumeroProprietariDTO() {
		// TODO Auto-generated constructor stub
	}

	public NomiENumeroProprietariDTO(List<String> nomiProprietari) {
		super();
		this.numeroProprietari = nomiProprietari.size();
		this.nomiProprietari = nomiProprietari;
	}

	public int getNumeroProprietari() {
		return numeroProprietari;
	}

	public void setNumeroProprietari(int numeroProprietari) {
		this.numeroProprietari = numeroProprietari;
	}

	public List<String> getNomiProprietari() {
		return nomiProprietari;
	}

	public void setNomiProprietari(List<String> nomiProprietari) {
		this.nomiProprietari = nomiProprietari;
	}
}
