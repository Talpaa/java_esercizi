package com.spring.universita.service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.spring.universita.dao.DAOProfessoreMappa;
import com.spring.universita.dto.professore.ProfessoreDTO;
import com.spring.universita.entity.Professore;
import com.spring.universita.utility.ConversioniProf;

public class ProfessoreService {
	
	private DAOProfessoreMappa dao = new DAOProfessoreMappa();

	public Boolean carica(ProfessoreDTO prof) {
		Professore professore = ConversioniProf.daProfessoreDTOAProfessore(prof);
		return dao.insert(professore);
	}

	public ProfessoreDTO cerca(int id) {
		
		Professore p = dao.selectById(id);
		
		if(p != null) {
			return ConversioniProf.daProfessoreAProfessoreDTO(p);
		}
		return null;
		
	}
	
	
	public List<Boolean> caricaProfessori(LinkedList<ProfessoreDTO> professoriDTO) {
		// TODO Auto-generated method stub
		List<Boolean> risposte = new LinkedList<Boolean>(); 
	
		for(ProfessoreDTO dto: professoriDTO) {
			
			Professore entity = ConversioniProf.daProfessoreDTOAProfessore(dto);
			risposte.add(dao.insert(entity));
		}
		
		return risposte;
}


	public List<ProfessoreDTO> mostraProfessori() {
		
		List<Professore> professori = dao.selectAll();
		LinkedList<ProfessoreDTO> professoriDTO = new LinkedList<ProfessoreDTO>();
		
		for (Professore prof : professori) {
			professoriDTO.add(ConversioniProf.daProfessoreAProfessoreDTO(prof));
		}
		
		return professoriDTO;
	}

	public ProfessoreDTO elimina(int id) {
		
		Professore p = dao.selectById(id);
		
		if(p != null) {
			ProfessoreDTO ris = ConversioniProf.daProfessoreAProfessoreDTO(p);
			Boolean test = dao.delete(id);
			
			if(test) {return ris;}	
		}
		return null;
	}

	public ProfessoreDTO modificaProfMateria(int id, String newMateria) {
		
		Professore p = dao.selectById(id);
						
		if(p != null) {
			p.setMateria(newMateria);
			
			
			ProfessoreDTO profDTO = ConversioniProf.daProfessoreAProfessoreDTO(dao.selectById(id));
			
			return profDTO;
		}
		return null;
	}

	public List<ProfessoreDTO> cercaProfPerMateria(String materia) {
		
		List<Professore> professori = dao.selectAll();
		LinkedList<ProfessoreDTO> professoriDTO = new LinkedList<ProfessoreDTO>();
		
		for (Professore prof : professori) {
			
			if(prof.getMateria().equals(materia)) {
				professoriDTO.add(ConversioniProf.daProfessoreAProfessoreDTO(prof));
			}
			
		}
		
		return professoriDTO;
	}

	public List<ProfessoreDTO> ordinaProfessori() {
		List<Professore> professori = dao.selectAll();
		LinkedList<ProfessoreDTO> professoriDTO = new LinkedList<ProfessoreDTO>();
		
		for (Professore prof : professori) {
			professoriDTO.add(ConversioniProf.daProfessoreAProfessoreDTO(prof));
		}
			
		
		professoriDTO.sort(Comparator.comparing(ProfessoreDTO::getCognome));

		
		return professoriDTO;
	}

	public Set<String> elencoMaterie() {

		List<Professore> professori = dao.selectAll();
		Set<String> materie = new HashSet<>();

		for(Professore prof : professori) {
			materie.add(prof.getMateria());
		}
		return materie;
	}
}
