package com.spring.apprubrica.dto.rubrica;

public class ProprietarioCreazioneDTO {

	private String proprietario;
	private int anno;
	
	public ProprietarioCreazioneDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProprietarioCreazioneDTO(String proprietario, int anno) {
		super();
		this.proprietario = proprietario;
		this.anno = anno;
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
}
