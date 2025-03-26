package com.spring.universita.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.spring.universita.dto.professore.ProfessoreDTO;

public interface ProfessoreService {
	public Boolean carica(ProfessoreDTO prof);
	public ProfessoreDTO cerca(int id);
	public List<Boolean> caricaProfessori(LinkedList<ProfessoreDTO> professoriDTO);
	public List<ProfessoreDTO> mostraProfessori();
	public ProfessoreDTO elimina(int id);
	public ProfessoreDTO modificaProfMateria(int id, String newMateria);
	public List<ProfessoreDTO> cercaProfPerMateria(String materia);
	public List<ProfessoreDTO> ordinaProfessori();
	public Set<String> elencoMaterie();
}
