package com.spring.studente.service;

import java.util.List;

import com.spring.studente.dto.StudenteDTO;

public interface StudenteService {

	public boolean immatricola(StudenteDTO dto);
	public StudenteDTO cerca(Integer matricola);
	public List<StudenteDTO> mostra();
	public StudenteDTO elimina(Integer matricola);
	public StudenteDTO modifica(Integer matricola, StudenteDTO dto);
	public List<StudenteDTO> immatricolaStudenti(List<StudenteDTO> studentiDTO);
	public List<StudenteDTO> getGiovani(int annoImm);
}
