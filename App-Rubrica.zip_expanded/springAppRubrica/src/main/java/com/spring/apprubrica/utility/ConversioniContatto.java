package com.spring.apprubrica.utility;

import com.spring.apprubrica.dto.contatto.ContattoDTO;
import com.spring.apprubrica.dto.contatto.ContattoNomeCognomeDTO;
import com.spring.apprubrica.entity.Contatto;

public class ConversioniContatto {

	public static Contatto daContattoDTOAContatto(ContattoDTO value) {
		
		return new Contatto(value.getId(), value.getNome(), value.getCognome(), 
				value.getNumero(), value.getGruppoDiAppartenenza(), value.getAnnoNascita(), value.getPreferito());
	}

	public static ContattoDTO daContattoAContattoDTO(Contatto contatto) {
		
		return new ContattoDTO(contatto.getId(), contatto.getNome(), contatto.getCognome(), 
				contatto.getNumero(), contatto.getGruppoDiAppartenenza(), contatto.getAnnoNascita(), contatto.getPreferito());
	}

	public static ContattoNomeCognomeDTO daContattoAContattoNomeCognomeDTO(Contatto value) {
		
		return new ContattoNomeCognomeDTO(value.getNome(), value.getCognome());
	}

}
