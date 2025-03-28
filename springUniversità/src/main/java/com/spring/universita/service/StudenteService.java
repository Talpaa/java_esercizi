package com.spring.universita.service;

import java.util.LinkedList;
import java.util.List;

import com.spring.universita.utility.ConversioniStudente;
import com.spring.universita.dao.DAOStudenteMappa;
import com.spring.universita.dto.studente.CognomeAnnoIscrizioneDTO;
import com.spring.universita.dto.studente.CognomeAnnoNascitaDTO;
import com.spring.universita.dto.studente.StudenteDTO;
import com.spring.universita.entity.Studente;

public class StudenteService {
	
	private DAOStudenteMappa dao = new DAOStudenteMappa();

	public Boolean carica(StudenteDTO dto) {
		Studente entity = ConversioniStudente.daStudenteDTOAStudente(dto);
		return dao.insert(entity);
	}

	public StudenteDTO cerca(int id) {
		Studente studente = dao.selectById(id);
		if(studente != null) {
			return ConversioniStudente.daStudenteAStudenteDTO(studente);
		}
		return null;
	}

	public List<StudenteDTO> mostraStudenti() {
		
		List<StudenteDTO> studentiDTO = new LinkedList<>();
		
		List<Studente> studenti = dao.selectAll();
		
		for(Studente studente: studenti) {
			studentiDTO.add(ConversioniStudente.daStudenteAStudenteDTO(studente));
		}
		
		return studentiDTO;
	}

	public StudenteDTO elimina(int id) {
		
		StudenteDTO ris = ConversioniStudente.daStudenteAStudenteDTO(dao.selectById(id));
		Boolean test = dao.delete(id);
		
		if(test) {
			return ris;
		}else {
			return null;
		}
		
	}

	public StudenteDTO modificaIndStud(int id, String newIndirizzo) {
		
		dao.selectById(id).setIndirizzo(newIndirizzo);
		
		StudenteDTO studDTO = ConversioniStudente.daStudenteAStudenteDTO(dao.selectById(id));
		
		return studDTO;
	}

	public List<String> elencoNomi() {
		
		List<String> elencoNomi = new LinkedList<>();
		
		List<Studente> studenti = dao.selectAll();
		
		for(Studente studente : studenti) {
			elencoNomi.add(studente.getNome());
		}
		
		return elencoNomi;
	}

	public CognomeAnnoNascitaDTO giovaneStud() {
		
		List<Studente> studenti = dao.selectAll();

		Studente min = studenti.get(0);
		
		for(Studente studente : studenti) {
			
			if(studente.getAnnoNascita() > min.getAnnoNascita()) {
				min = studente;
			}
		}
		
		return ConversioniStudente.daStudenteACognomeAnnoNascitaDTO(min);
	}

	public CognomeAnnoIscrizioneDTO primoStud() {
		List<Studente> studenti = dao.selectAll();

		Studente min = studenti.get(0);
		
		for(Studente studente : studenti) {
			
			if(studente.getAnnoImmatricolazione() < min.getAnnoImmatricolazione()) {
				min = studente;
			}
		}
		
		return ConversioniStudente.daStudenteACognomeAnnoIscrizioneDTO(min);
	}

}
