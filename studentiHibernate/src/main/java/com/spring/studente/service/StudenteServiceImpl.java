package com.spring.studente.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.studente.dao.DaoStudente;
import com.spring.studente.dto.StudenteDTO;
import com.spring.studente.entity.Studente;

@Service
@Transactional
public class StudenteServiceImpl implements StudenteService {

	@Autowired
	private DaoStudente dao;
	
	@Override
	public boolean immatricola(StudenteDTO dto) {
		
		Studente st = new Studente(dto.getMatricola(), dto.getNome(), dto.getCognome(), dto.getAnnoImm());
		
		Optional<Studente> opt = dao.findById(dto.getMatricola());
		
		if(opt.isPresent()) {
			return false;
		}else {
			dao.save(st);
			return true;
		}
	}
	


	@Override
	public List<StudenteDTO> immatricolaStudenti(List<StudenteDTO> studentiDTO) {
		
		List<StudenteDTO> studDTO = new LinkedList<StudenteDTO>();
		
		for(StudenteDTO dto : studentiDTO) {
			Studente st = new Studente(dto.getMatricola(), dto.getNome(), dto.getCognome(), dto.getAnnoImm());
			
			Optional<Studente> opt = dao.findById(dto.getMatricola());
			
			if(!(opt.isPresent())) {
				dao.save(st);
				studDTO.add(dto);
			}
		}
		return studDTO;
	}

	@Override
	public StudenteDTO cerca(Integer matricola) {
		
		Optional<Studente> opt = dao.findById(matricola);
		
		if(opt.isPresent()) {
			Studente st = opt.get();
			return new StudenteDTO(st.getMatricola(), st.getNome(), st.getCognome(), st.getAnnoImm());
		}
		return null;
	}

	@Override
	public List<StudenteDTO> mostra() {
		
		List<Studente> studenti = new LinkedList<Studente>();
		List<StudenteDTO> studentiDTO = new LinkedList<StudenteDTO>();
		
		studenti = dao.findAll();
		
		for(Studente stud : studenti) {
			
			studentiDTO.add(new StudenteDTO(stud.getMatricola(), stud.getNome(), stud.getCognome(), stud.getAnnoImm()));
		}
		
		return studentiDTO;
	}

	@Override
	public StudenteDTO elimina(Integer matricola) {
		
		Optional<Studente> opt = dao.findById(matricola);
		
		if(opt.isPresent()) {
			
			Studente st = opt.get();
			
			dao.delete(st);
			
			return new StudenteDTO(st.getMatricola(), st.getNome(), st.getCognome(), st.getAnnoImm());
		}
		return null;
	}

	@Override
	public StudenteDTO modifica(Integer matricola, StudenteDTO dto) {
		
		Optional<Studente> opt = dao.findById(matricola);
		
		if(opt.isPresent()) {
			
			Studente st = opt.get();
			
			if(dto.getNome() != null) {
				st.setNome(dto.getNome());
			}
			
			if(dto.getCognome() != null) {
				st.setCognome(dto.getCognome());
			}
			
			if((Integer)dto.getAnnoImm() != null) {
				st.setAnnoImm(dto.getAnnoImm());
			}
			
			return new StudenteDTO(st.getMatricola(), st.getNome(), st.getCognome(), st.getAnnoImm());
		}
		return null;
	}
	
	@Override
	public List<StudenteDTO> getGiovani(int annoImm) {
		List<Studente> studenti = dao.getGiovani(annoImm);
		
		List<StudenteDTO> studentiDTO = new LinkedList<StudenteDTO>();
		
		for(Studente stud : studenti) {
			studentiDTO.add(new StudenteDTO(stud.getMatricola(), stud.getNome(), stud.getCognome(), stud.getAnnoImm()));
		}
		
		return studentiDTO;
	}
}
