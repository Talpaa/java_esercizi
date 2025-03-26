package com.spring.phonebook.service;

import com.spring.phonebook.dto.ContattoDTO;
import com.spring.phonebook.dto.RubricaDTO;

public interface RubricaService {

	public boolean creaRubrica(RubricaDTO dto);
	
	public RubricaDTO cercaPerId(Integer idRubrica);
	
	public boolean aggiungiContatto(Integer idRubrica, ContattoDTO dto);
}
