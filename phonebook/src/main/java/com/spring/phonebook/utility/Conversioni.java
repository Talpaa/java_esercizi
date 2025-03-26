package com.spring.phonebook.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.phonebook.dto.ContattoDTO;
import com.spring.phonebook.dto.RubricaDTO;
import com.spring.phonebook.entity.Contatto;
import com.spring.phonebook.entity.Rubrica;

public class Conversioni {

	public static Contatto daContattoDtoAContatto(ContattoDTO dto) {
        return new Contatto(dto.getIdContatto(), dto.getNome(), dto.getCognome(), dto.getNumero());
    }

    public static ContattoDTO daContattoAContattoDto(Contatto contatto) {
        return new ContattoDTO(contatto.getIdContatto(), contatto.getNome(), contatto.getCognome(), contatto.getNumero());
    }

    public static Rubrica daRubricaDtoARubrica(RubricaDTO dto) {
        Rubrica rubrica = new Rubrica(dto.getIdRubrica(), dto.getProprietario(), dto.getAnnoCreazione());

        // converto la lista
        List<ContattoDTO> listaD = dto.getContatti();

        List<Contatto> lista = listaD.stream()
                .map(contattoD -> Conversioni.daContattoDtoAContatto(contattoD))
                .collect(Collectors.toList());

        rubrica.setContatti(lista);
        return rubrica;

    }

    public static RubricaDTO daRubricaARubricaDto(Rubrica rubrica) {
        RubricaDTO rubricaD = new RubricaDTO(rubrica.getIdRubrica(), rubrica.getProprietario(), rubrica.getAnnoCreazione());

        // converto la lista
        List<Contatto> lista = rubrica.getContatti();

        List<ContattoDTO> listaD = lista.stream()
                .map(contatto -> Conversioni.daContattoAContattoDto(contatto))
                .collect(Collectors.toList());

        rubricaD.setContatti(listaD);
        return rubricaD;

    }
}