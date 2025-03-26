package com.spring.impiegato.conversioni;

import com.spring.impiegato.dto.ImpiegatoDTO;
import com.spring.impiegato.entity.Impiegato;

public class Conversione {

	public static Impiegato daImpiegatoDTOAImpiegato(ImpiegatoDTO dto) {
		return new Impiegato(dto.getMatricola(), dto.getNome(), dto.getCognome(), dto.getSalario());
	}

	public static ImpiegatoDTO daImpiegatoAImpiegatoDTO(Impiegato entity) {
		return new ImpiegatoDTO(entity.getMatricola(), entity.getNome(), entity.getCognome(), entity.getSalario());
	}
}
