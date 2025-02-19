package com.spring.universita.utility;

import com.spring.universita.dto.professore.ProfessoreDTO;
import com.spring.universita.entity.Professore;

public class ConversioniProf {

	public static Professore daProfessoreDTOAProfessore(ProfessoreDTO prof) {
		
		int id = prof.getId();
		String nome = prof.getNome();
		String cognome = prof.getCognome();
		String materia = prof.getMateria();
		
		return new Professore(id, nome, cognome, materia);
	}
	
	public static ProfessoreDTO daProfessoreAProfessoreDTO(Professore prof) {
		
		int id = prof.getId();
		String nome = prof.getNome();
		String cognome = prof.getCognome();
		String materia = prof.getMateria();
		
		return new ProfessoreDTO(id, nome, cognome, materia);
	}

}
