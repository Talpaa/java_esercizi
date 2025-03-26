package com.spring.impiegato.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.impiegato.dto.ImpiegatoDTO;
import com.spring.impiegato.dto.ImpiegatoNomeCognomeDTO;
import com.spring.impiegato.entity.Impiegato;
import com.spring.impiegato.dao.DaoImpiegato;

import com.spring.impiegato.conversioni.Conversione;

@Service
@Transactional
public class ImpiegatoServiceImpl implements ImpiegatoService{
	
	@Autowired
	private DaoImpiegato dao;

	//Assumi nuovo impiegato
	@Override
	public boolean assumi(ImpiegatoDTO dto) {
		
		Optional<Impiegato> opt = dao.findById(dto.getMatricola());
		
		if(opt.isPresent()) {
			return false;
		}
		
		dao.save(Conversione.daImpiegatoDTOAImpiegato(dto));
		return true;
	}

	//Assumi nuovi impiegati
	@Override
	public List<ImpiegatoDTO> assumiInBlocco(List<ImpiegatoDTO> impiegatiDTO) {
		
		List<ImpiegatoDTO> impDTO = new LinkedList<ImpiegatoDTO>();
		
		for (ImpiegatoDTO dto : impiegatiDTO) {
			
			Optional<Impiegato> opt = dao.findById(dto.getMatricola());
			
			if(opt.isEmpty()) {
				
				dao.save(Conversione.daImpiegatoDTOAImpiegato(dto));
				impDTO.add(dto);
			}
		}
		return impDTO;
	}

	//Cerca impiegato per matricola
	@Override
	public ImpiegatoDTO cerca(int matricola) {
		
		Optional<Impiegato> opt = dao.findById(matricola);
		
		if(opt.isPresent()) {
			return Conversione.daImpiegatoAImpiegatoDTO(opt.get());
		}
		return null;
	}

	//Visualizza tutti gli impiegati
	@Override
	public List<ImpiegatoDTO> visualizza() {
		
		List<ImpiegatoDTO> impiegatiDTO = new LinkedList<ImpiegatoDTO>();
		
		List<Impiegato> impiegati = dao.findAll();
		
		for (Impiegato imp : impiegati) {
			impiegatiDTO.add(Conversione.daImpiegatoAImpiegatoDTO(imp));
		}
		
		return impiegatiDTO;
	}

	//Cancella un impiegato tramite la matricola e ritornalo
	@Override
	public ImpiegatoDTO licenzia(int matricola) {
		
		Optional<Impiegato> opt = dao.findById(matricola);
		
		if(opt.isPresent()) {
			
			Impiegato imp = opt.get();
			
			dao.delete(imp);
			
			return Conversione.daImpiegatoAImpiegatoDTO(imp);
		}
		return null;
	}

	//Modifica il salario di un impiegato esistente (passando la matricola e il nuovo salario) e ritorna l’impiegato aggiornato
	@Override
	public ImpiegatoDTO modificaSalario(int matricola, Double newSalario) {
		
		Optional<Impiegato> opt = dao.findById(matricola);
		
		if(opt.isPresent()) {
			
			Impiegato imp = opt.get();
			
			imp.setSalario(newSalario);
			
			return Conversione.daImpiegatoAImpiegatoDTO(imp);
		}
		return null;
	}


	
	  ////////////////
	 ////AVANZATE////
	////////////////
	
	
	//Cancella un impiegato tramite la matricola e torna solo nome e cognome
	@Override
	public ImpiegatoNomeCognomeDTO licenziaNomeCognome(int matricola) {
		
		Optional<Impiegato> opt = dao.findById(matricola);
		
		if(opt.isPresent()) {
			
			Impiegato imp = opt.get();
			
			dao.delete(imp);
			
			return new ImpiegatoNomeCognomeDTO(imp.getNome(), imp.getCognome());
		}
		return null;
	}

	//Visualizza la lista dei nominativi (nome e cognome) degli impiegati
	@Override
	public List<ImpiegatoNomeCognomeDTO> visualizzaNomeCognome() {
		
		List<ImpiegatoNomeCognomeDTO> impiegatiNomeCognomeDTO = new LinkedList<ImpiegatoNomeCognomeDTO>();
		
		List<Impiegato> impiegati = dao.findAll();
		
		for (Impiegato imp : impiegati) {
			impiegatiNomeCognomeDTO.add(new ImpiegatoNomeCognomeDTO(imp.getNome(), imp.getCognome()));
		}
		return impiegatiNomeCognomeDTO;
	}

	//Visualizza tutti gli impiegati col salario maggiore di un valore specificato
	@Override
	public List<ImpiegatoDTO> visualizzaSalari(Double salario) {
		List<Impiegato> impiegati = dao.getSalari(salario);
		
		List<ImpiegatoDTO> impiegatiDTO = new LinkedList<ImpiegatoDTO>();
		
		for (Impiegato imp : impiegati) {
			impiegatiDTO.add(Conversione.daImpiegatoAImpiegatoDTO(imp));
		}
		
		return impiegatiDTO;
	}
	
	//Visualizza tutti gli impiegati ordinati per cognome
	@Override
	public List<ImpiegatoDTO> ordinaCognomi() {
		
		List<Impiegato> impiegati = dao.ordinaCognomi();
		
		List<ImpiegatoDTO> impiegatiDTO = new LinkedList<ImpiegatoDTO>();
		
		for (Impiegato imp : impiegati) {
			impiegatiDTO.add(Conversione.daImpiegatoAImpiegatoDTO(imp));
		}
		
		return impiegatiDTO;
	}
	
	//Visualizza tutti gli impiegati ordinati per salario
	@Override
	public List<ImpiegatoDTO> ordinaSalari() {
		
		List<Impiegato> impiegati = dao.ordinaSalari();
		
		List<ImpiegatoDTO> impiegatiDTO = new LinkedList<ImpiegatoDTO>();
		
		for (Impiegato imp : impiegati) {
			impiegatiDTO.add(Conversione.daImpiegatoAImpiegatoDTO(imp));
		}
		
		return impiegatiDTO;
	}
}
