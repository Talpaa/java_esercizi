package com.spring.apprubrica.service;

import java.util.List;

import com.spring.apprubrica.dto.rubrica.ProprietarioCreazioneDTO;
import com.spring.apprubrica.dto.rubrica.RubricaDTO;
import com.spring.apprubrica.dto.rubrica.NomiENumeroProprietariDTO;
import com.spring.apprubrica.dto.rubrica.ProprietarioRubricaDTO;

public interface RubricaService {

	//Inserisci nuova rubrica (vuota)
	public boolean registra(RubricaDTO dto);
	
	//Visualizza una rubrica per id
	public RubricaDTO cercaPerId(int idRubrica);
	
	//Visualizza tutte le rubriche
	public List<RubricaDTO> mostraTutte();
	
	//Cancella una rubrica esistente
	public RubricaDTO cancella(int idRubrica);
	
	//Visualizza solo proprietario e anno creazione di una rubrica (passando l’ id)
	public ProprietarioCreazioneDTO getProprietarioCreazione(int idRubrica);
	
	//Modifica anno di creazione di una rubrica esistente (torna la rubrica aggiornata)
	public RubricaDTO modificaAnnoCreazione(int idRubrica, int annoCreazione);
	
	//Modifica il nome proprietario di una rubrica esistente (torna la rubrica aggiornata)
	public RubricaDTO modificaProprietario(int idRubrica, String proprietario);
	
	//Visualizza i nomi di tutti i proprietari delle rubriche e il loro numero totale
	public NomiENumeroProprietariDTO listaNomiENumeroProprietariDTO();
	
	//Visualizza nome proprietario e anno creazione della rubrica più vecchia
	public ProprietarioCreazioneDTO getRubricaPiuVecchia();
	
	//Visualizza tutti gli anni di creazione (delle rubriche) in ordine crescente
	public List<Integer> getAnniCreazione();
	
	//Visualizza nome proprietario e numero contatti di una rubrica
	public ProprietarioRubricaDTO getProprietarioRubrica(int idRubrica);
}
