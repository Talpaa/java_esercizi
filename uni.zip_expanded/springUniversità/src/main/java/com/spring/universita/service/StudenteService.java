package com.spring.universita.service;

import java.util.List;

import com.spring.universita.dto.studente.CognomeAnnoIscrizioneDTO;
import com.spring.universita.dto.studente.CognomeAnnoNascitaDTO;
import com.spring.universita.dto.studente.StudenteDTO;

public interface StudenteService {
	
	public Boolean carica(StudenteDTO dto);
	public StudenteDTO cerca(int id);
	public List<StudenteDTO> mostraStudenti();
	public StudenteDTO elimina(int id);
	public StudenteDTO modificaIndStud(int id, String newIndirizzo);
	public List<String> elencoNomi();
	public CognomeAnnoNascitaDTO giovaneStud();
	public CognomeAnnoIscrizioneDTO primoStud();
}
