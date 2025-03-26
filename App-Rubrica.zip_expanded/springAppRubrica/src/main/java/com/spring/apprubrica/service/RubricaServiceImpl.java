package com.spring.apprubrica.service;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.apprubrica.dao.DAOAppRubrica;
import com.spring.apprubrica.dto.rubrica.ProprietarioCreazioneDTO;
import com.spring.apprubrica.dto.rubrica.RubricaDTO;
import com.spring.apprubrica.dto.rubrica.NomiENumeroProprietariDTO;
import com.spring.apprubrica.dto.rubrica.ProprietarioRubricaDTO;
import com.spring.apprubrica.entity.Rubrica;
import com.spring.apprubrica.utility.ConversioniRubrica;

@Service
public class RubricaServiceImpl implements RubricaService {

	@Autowired
	private DAOAppRubrica dao;
	
	//Inserisci nuova rubrica (vuota)
	public boolean registra(RubricaDTO dto) {
		
		Rubrica entity = dao.selectById(dto.getId());
		if (entity == null) {
			entity = ConversioniRubrica.daRubricaDTOARubrica(dto);
			return dao.insert(entity);
	    }
		throw new RuntimeException("Rubrica già presente.");
	}

	//Visualizza una rubrica per id
	public RubricaDTO cercaPerId(int idRubrica) {
		
		Rubrica entity = dao.selectById(idRubrica);
		
		if(entity != null) {
			return ConversioniRubrica.daRubricaARubricaDTO(entity);
		}
		throw new RuntimeException("Rubrica non presente.");
	}

	//Visualizza tutte le rubriche
	public List<RubricaDTO> mostraTutte() {
		
		List<Rubrica> rubriche = dao.selectAll();
		List<RubricaDTO> rubricheDTO = new LinkedList<RubricaDTO>();
		
		for (Rubrica rubrica : rubriche) {
			
//			if(rubrica.getContatti() != null) {
//				System.out.println(rubrica.getContatti().get(1).getAnnoNascita().getDate());
//			}
			
			rubricheDTO.add(ConversioniRubrica.daRubricaARubricaDTO(rubrica));
		}
		if (rubricheDTO.size() > 0) {
			return rubricheDTO;
		}
		
		throw new RuntimeException("Nessuna rubrica presente.");
		
	}

	//Cancella una rubrica esistente
	public RubricaDTO cancella(int idRubrica) {
		
	
		Rubrica entity;
		try {
			entity = dao.selectById(idRubrica);
		} catch (Exception e) {
			throw new RuntimeException("Impossibile eliminare la rubrica");
		}
		
		dao.delete(idRubrica);
		return ConversioniRubrica.daRubricaARubricaDTO(entity);
	}

	//Visualizza solo proprietario e anno creazione di una rubrica (passando l’ id)
	public ProprietarioCreazioneDTO getProprietarioCreazione(int idRubrica) {
		
		Rubrica entity = dao.selectById(idRubrica);
		
		if(entity != null) {
			return ConversioniRubrica.daRubricaAProprietarioCreazioneDTO(entity);
		}
		
		return null;
	}

	//Modifica anno di creazione di una rubrica esistente (torna la rubrica aggiornata)
	public RubricaDTO modificaAnnoCreazione(int idRubrica, int newAnnoCreazione) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if (rubrica != null) {
			
			rubrica.setAnno(newAnnoCreazione);
			dao.update(rubrica);
			return ConversioniRubrica.daRubricaARubricaDTO(rubrica);
		}
		return null;
	}

	//Modifica il nome proprietario di una rubrica esistente (torna la rubrica aggiornata)
	public RubricaDTO modificaProprietario(int idRubrica, String newProprietario) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if (rubrica != null) {
			rubrica.setProprietario(newProprietario);
			dao.update(rubrica);
			return ConversioniRubrica.daRubricaARubricaDTO(rubrica);
		}
		return null;
	}

	//Visualizza i nomi di tutti i proprietari delle rubriche e il loro numero totale
	public NomiENumeroProprietariDTO listaNomiENumeroProprietariDTO() {
		
		List<Rubrica> rubriche = dao.selectAll();

		List<String> proprietari = new LinkedList<String>();
		
		for(Rubrica rubrica : rubriche) {
			
			proprietari.add(rubrica.getProprietario());
		}
		
		return new NomiENumeroProprietariDTO(proprietari);
	}

	//Visualizza nome proprietario e anno creazione della rubrica più vecchia
	public ProprietarioCreazioneDTO getRubricaPiuVecchia() {
		
		List<Rubrica> rubriche = dao.selectAll();
		
		if(rubriche.size() > 0) {
		
			ProprietarioCreazioneDTO vecchio = new ProprietarioCreazioneDTO(rubriche.get(0).getProprietario(), rubriche.get(0).getAnno());
			
			for(Rubrica rubrica : rubriche) {
				
				if (vecchio.getAnno() > rubrica.getAnno()) {
					
					vecchio.setAnno(rubrica.getAnno());
					vecchio.setProprietario(rubrica.getProprietario());
				}
			}
			return vecchio;
		}
		return null;
	}

	//Visualizza tutti gli anni di creazione (delle rubriche) in ordine crescente
	public List<Integer> getAnniCreazione() {
		
		List<Rubrica> rubriche = dao.selectAll();
		
		if(rubriche.size() > 0) {
		
			LinkedList<Integer> anni = new LinkedList<Integer>();
			
			for(Rubrica rubrica : rubriche) {
				
				anni.add(rubrica.getAnno());
			}
			Collections.sort(anni);
			return anni;
		}
		return null;
	}

	//Visualizza nome proprietario e numero contatti di una rubrica
	public ProprietarioRubricaDTO getProprietarioRubrica(int idRubrica) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if (rubrica != null) {
			return new ProprietarioRubricaDTO(rubrica.getProprietario(), rubrica.getContatti().size());
		}
		
		return null;
	}
}
