package com.spring.universita.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.universita.utility.ConversioniStudente;
import com.spring.universita.dao.DAOStudenteMappa;
import com.spring.universita.dto.studente.CognomeAnnoIscrizioneDTO;
import com.spring.universita.dto.studente.CognomeAnnoNascitaDTO;
import com.spring.universita.dto.studente.StudenteDTO;
import com.spring.universita.entity.Studente;

@Service
public class StudenteServiceImpl implements StudenteService {
	
	@Autowired
	private DAOStudenteMappa dao;

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
		
		Studente stud = dao.selectById(id);
		
		if(stud != null) {
		
			StudenteDTO ris = ConversioniStudente.daStudenteAStudenteDTO(stud);
			Boolean test = dao.delete(id);
			
			if(test) {return ris;}
		}
		return null;
	}

	public StudenteDTO modificaIndStud(int id, String newIndirizzo) {
		
		Studente stud = dao.selectById(id);
		
		if(stud != null) {
			stud.setIndirizzo(newIndirizzo);
			
			StudenteDTO studDTO = ConversioniStudente.daStudenteAStudenteDTO(dao.selectById(id));
			
			return studDTO;
		}
		return null;
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

		if( !(studenti.isEmpty()) ) {
		
			Studente min = studenti.get(0);
			
			for(Studente studente : studenti) {
				
				if(studente.getAnnoNascita() > min.getAnnoNascita()) {
					min = studente;
				}
			}
			
			return ConversioniStudente.daStudenteACognomeAnnoNascitaDTO(min);
		}
		
		return null;
	}

	public CognomeAnnoIscrizioneDTO primoStud() {
		List<Studente> studenti = dao.selectAll();

		if( !(studenti.isEmpty()) ) {
		
			Studente min = studenti.get(0);
			
			for(Studente studente : studenti) {
				
				if(studente.getAnnoImmatricolazione() < min.getAnnoImmatricolazione()) {
					min = studente;
				}
			}
			
			return ConversioniStudente.daStudenteACognomeAnnoIscrizioneDTO(min);
		}
		
		return null;
	}

}
