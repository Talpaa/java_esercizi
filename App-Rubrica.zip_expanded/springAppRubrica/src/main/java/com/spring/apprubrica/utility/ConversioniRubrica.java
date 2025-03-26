package com.spring.apprubrica.utility;

import java.util.HashMap;
import java.util.Map;

import com.spring.apprubrica.dto.contatto.ContattoDTO;
import com.spring.apprubrica.dto.rubrica.ProprietarioCreazioneDTO;
import com.spring.apprubrica.dto.rubrica.RubricaDTO;
import com.spring.apprubrica.entity.Contatto;
import com.spring.apprubrica.entity.Rubrica;

public class ConversioniRubrica {

	public static Rubrica daRubricaDTOARubrica(RubricaDTO dto) {
		
		Map<Integer, Contatto> contatti = new HashMap<>();
		
		Map<Integer, ContattoDTO> contattiDTO = dto.getContatti();
		
		for (Map.Entry<Integer, ContattoDTO> entry : contattiDTO.entrySet()) {
			
			Contatto contatto = ConversioniContatto.daContattoDTOAContatto(entry.getValue());
			
			contatti.put(entry.getKey(), contatto);
        }
		
		return new Rubrica(dto.getId(), dto.getProprietario(), dto.getAnno(), contatti);
		
	}

	public static RubricaDTO daRubricaARubricaDTO(Rubrica entity) {
		
		Map<Integer, Contatto> contatti = entity.getContatti();
		
		Map<Integer, ContattoDTO> contattiDTO = new HashMap<>();
		
		for (Map.Entry<Integer, Contatto> entry : contatti.entrySet()) {
			
			ContattoDTO contattoDTO = ConversioniContatto.daContattoAContattoDTO(entry.getValue());
			
			contattiDTO.put(entry.getKey(), contattoDTO);
        }
		
		return new RubricaDTO(entity.getId(), entity.getProprietario(), entity.getAnno(), contattiDTO);
	}

	public static ProprietarioCreazioneDTO daRubricaAProprietarioCreazioneDTO(Rubrica entity) {

		return new ProprietarioCreazioneDTO(entity.getProprietario(), entity.getAnno());
	}

}
