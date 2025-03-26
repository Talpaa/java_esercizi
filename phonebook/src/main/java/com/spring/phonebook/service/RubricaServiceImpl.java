package com.spring.phonebook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.phonebook.dao.DAORubrica;
import com.spring.phonebook.dto.ContattoDTO;
import com.spring.phonebook.dto.RubricaDTO;
import com.spring.phonebook.entity.Rubrica;
import com.spring.phonebook.utility.Conversioni;


@Service
@Transactional
public class RubricaServiceImpl implements RubricaService {
	
	@Autowired
	private DAORubrica dao;

	@Override
	public boolean creaRubrica(RubricaDTO dto) {
		
		Optional<Rubrica> opt = dao.findById(dto.getIdRubrica());
		
		if(opt.isEmpty()) {
			
			Rubrica rubrica = Conversioni.daRubricaDtoARubrica(dto);
			dao.save(rubrica);
			return true;
		}
		
		return false;
	}

	@Override
	public RubricaDTO cercaPerId(Integer idRubrica) {
		
		Optional<Rubrica> opt = dao.findById(idRubrica);
		if(opt.isPresent()) {
			Rubrica trovata = opt.get();
			return Conversioni.daRubricaARubricaDto(trovata);
		}
		return null;
	}

	@Override
	public boolean aggiungiContatto(Integer idRubrica, ContattoDTO dto) {
		
		Optional<Rubrica> opt = dao.findById(idRubrica);
		
		if(opt.isPresent()) {
			
			Rubrica trovata = opt.get();
			
			trovata.addContatto(Conversioni.daContattoDtoAContatto(dto));
			return true;
		}
		return false;
	}
}
