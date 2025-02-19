package com.spring.universita.service;

import java.util.LinkedList;
import java.util.List;

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

	public List<ProfessoreDTO> mostraProfessori() {
		
		List<Professore> professori = dao.selectAll();
		LinkedList<ProfessoreDTO> professoriDTO = new LinkedList<ProfessoreDTO>();
		
		for (Professore prof : professori) {
			professoriDTO.add(ConversioniProf.daProfessoreAProfessoreDTO(prof));
		}
		
		return professoriDTO;
	}

	public ProfessoreDTO elimina(int id) {
		
		ProfessoreDTO ris = ConversioniProf.daProfessoreAProfessoreDTO(dao.selectById(id));
		Boolean test = dao.delete(id);
		
		if(test) {
			return ris;
		}else {
			return null;
		}
	}

	public ProfessoreDTO modificaProfMateria(int id, String newMateria) {
		
		Professore prof = dao.selectById(id);
		
		
		if (prof != null) {
			ProfessoreDTO profDTO = ConversioniProf.daProfessoreAProfessoreDTO(prof);
			profDTO.setMateria(newMateria);
			
			return profDTO;
		}
		
		return null;
		
	}
}
