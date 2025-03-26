package com.spring.apprubrica.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.apprubrica.dao.DAOAppRubrica;
import com.spring.apprubrica.dto.contatto.ContattoDTO;
import com.spring.apprubrica.dto.contatto.ContattoNoIDDTO;
import com.spring.apprubrica.dto.contatto.ContattoNomeCognomeDTO;
import com.spring.apprubrica.entity.Contatto;
import com.spring.apprubrica.entity.Rubrica;
import com.spring.apprubrica.utility.ConversioniContatto;

@Service
public class ContattoServiceImpl implements ContattoService{
	
	@Autowired
	private DAOAppRubrica dao;

	//Inserisci nuovo contatto
	public boolean registraContatto(Integer idRubrica, ContattoDTO dto) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if(rubrica != null) {
			
			//Contatto contatto = dao.selectById(idRubrica, dto.getId);
			if (true) {
				
				Contatto contatto = ConversioniContatto.daContattoDTOAContatto(dto);
				return dao.insert(idRubrica, contatto);
			}
		}
		throw new RuntimeException("Id già presente impossibile aggiungere il nuovo contatto");
	}

	//Visualizza un contatto per id
	public ContattoDTO cercaContatto(Integer idRubrica, Integer idContatto) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if(rubrica != null) {
			
			if (rubrica.getContatti().containsKey(idContatto)) {
				
				Contatto contatto = rubrica.getContatti().get(idContatto);
				
				return ConversioniContatto.daContattoAContattoDTO(contatto);
			}
		}
		throw new RuntimeException("Id non presente impossibile trovare il contatto");
	}

	//Visualizza il contatto con un dato numero
	public ContattoDTO cercaContattoNumero(int idRubrica, int numeroTelefono) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if(rubrica != null) {
			
			for (Map.Entry<Integer, Contatto> entry : rubrica.getContatti().entrySet()) {
			    
				if(entry.getValue().getNumero() == numeroTelefono) {
					return ConversioniContatto.daContattoAContattoDTO(entry.getValue());
				}
			}
		}
		throw new RuntimeException("Il numero di telefono cercato non è presente");
	}

	//Modifica un contatto esistente (tutti i campi tranne la chiave primaria)
	public ContattoDTO modificaContatto(int idRubrica, int idContatto, ContattoNoIDDTO dto) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if(rubrica != null) {
			
			if (rubrica.getContatti().containsKey(idContatto)) {
				
				if (dto.getNome() != null) {					
					rubrica.getContatti().get(idContatto).setNome(dto.getNome());
				}
				
				if (dto.getCognome() != null) {					
					rubrica.getContatti().get(idContatto).setCognome(dto.getCognome());
				}
				
				if (dto.getNumero() != null) {					
					rubrica.getContatti().get(idContatto).setNumero(dto.getNumero());
				}
				
				if (dto.getGruppoDiAppartenenza() != null) {					
					rubrica.getContatti().get(idContatto).setGruppoDiAppartenenza(dto.getGruppoDiAppartenenza());
				}
				
				if (dto.getAnnoNascita() != null) {					
					rubrica.getContatti().get(idContatto).setAnnoNascita(dto.getAnnoNascita());
				}
				
				if (dto.getPreferito() != null) {					
					rubrica.getContatti().get(idContatto).setPreferito(dto.getPreferito());
				}
				
				
				
				
				return ConversioniContatto.daContattoAContattoDTO(rubrica.getContatti().get(idContatto));
			}
		}
		throw new RuntimeException("Id non trovato impossibile apportare le modifiche inviate");
	}

	//Cancella un contatto esistente
	public ContattoDTO eliminaContatto(int idRubrica, int idContatto) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if(rubrica != null) {
			
			if (rubrica.getContatti().containsKey(idContatto)) {
				
				ContattoDTO contattoDTO = ConversioniContatto.daContattoAContattoDTO(rubrica.getContatti().get(idContatto));
				rubrica.getContatti().remove(idContatto);
				return contattoDTO;
			}
		}
		throw new RuntimeException("Id non trovato impossibile eliminare il contatto");
	}
	
	//Cancella un gruppo di una rubrica (cioè tutti i contatti appartenenti ad un dato gruppo)
	public List<ContattoDTO> eliminaContattiGruppo(int idRubrica, String gruppo) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		List<ContattoDTO> contattiDTO = new LinkedList<ContattoDTO>();
		
		if(rubrica != null) {
			
			 Set<Entry<Integer, Contatto>> entries = rubrica.getContatti().entrySet();
			 
			 Iterator<Entry<Integer, Contatto>> iter = entries.iterator();
			 
			 while(iter.hasNext()) {
				 Entry<Integer, Contatto> entry = iter.next();
			
			
			    
				if(entry.getValue().getGruppoDiAppartenenza().equals(gruppo)) {
					
					contattiDTO.add(ConversioniContatto.daContattoAContattoDTO(entry.getValue()));
					iter.remove();
				}
			}
			
			if (contattiDTO.size() <= 0) {
				
				String error = "Non è stato eliminato nessun contatto del gruppo '" + gruppo + "' perchè nessun contatto faceva parte del gruppo";
				throw new RuntimeException(error);
			}
		}
		for (ContattoDTO contattoDTO : contattiDTO) {
			System.out.println(contattoDTO.getId());
		}
		return contattiDTO;
	}

	//Visualizza tutti i contatti registrati
	public List<ContattoDTO> mostraTuttiContatti(int idRubrica) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if(rubrica != null) {
			
			List<ContattoDTO> contattiDTO = new LinkedList<ContattoDTO>();

			for (Map.Entry<Integer, Contatto> entry : rubrica.getContatti().entrySet()) {
				
				contattiDTO.add(ConversioniContatto.daContattoAContattoDTO(entry.getValue()));
			}
			
			if (contattiDTO.size() <= 0) {
				
				String error = "Non è presente nessun contatto in rubrica ";
				throw new RuntimeException(error);
			}
			
			return contattiDTO;
		}
		return null;
	}

	//Ricerca il nome e il cognome dei contatti di un dato gruppo 
	public List<ContattoNomeCognomeDTO> mostraTuttiNomiCognomiGruppo(int idRubrica, String gruppo) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if(rubrica != null) {
			
			List<ContattoNomeCognomeDTO> contattiDTO = new LinkedList<ContattoNomeCognomeDTO>();

			for (Map.Entry<Integer, Contatto> entry : rubrica.getContatti().entrySet()) {
				
				if(entry.getValue().getGruppoDiAppartenenza().equals(gruppo)) {
				
					contattiDTO.add(ConversioniContatto.daContattoAContattoNomeCognomeDTO(entry.getValue()));
				}
			}
			
			if (contattiDTO.size() <= 0) {
				
				String error = "Non è presente nessun contatto in rubrica che faccia parte del gruppo '" + gruppo + "'";
				throw new RuntimeException(error);
			}
			
			return contattiDTO;
		}
		return null;
	}

	//Visualizza il numero di contatti registrati
	public Integer numeroContatti(int idRubrica) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if(rubrica != null) {
			
			return rubrica.getContatti().size();
		}
		return null;
	}

	//Ricerca il numero di contatti di un dato gruppo
	public Integer numeroContattiGruppo(int idRubrica, String gruppo) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if(rubrica != null) {
			
			List<Contatto> rubricaGruppo = new LinkedList<Contatto>();
			
			for (Map.Entry<Integer, Contatto> entry : rubrica.getContatti().entrySet()) {
				
				if(entry.getValue().getGruppoDiAppartenenza().equals(gruppo)) {
					
					rubricaGruppo.add(entry.getValue());
				}
			}
			return rubricaGruppo.size();
		}
		return null;
	}

	//Modifica un contatto da NON preferito a preferito
	public ContattoDTO contattoPreferito(int idRubrica, int idContatto) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if(rubrica != null) {
			
			if (rubrica.getContatti().containsKey(idContatto)) {
				
				rubrica.getContatti().get(idContatto).setPreferito(true);
				
				Contatto contatto = rubrica.getContatti().get(idContatto);
				
				return ConversioniContatto.daContattoAContattoDTO(contatto);
			}
			
			throw new RuntimeException("Id non trovato impossibile rendere il contatto preferito");
		}
		return null;
	}

	//Ricerca tutti i preferiti 
	public List<ContattoDTO> preferiti(int idRubrica) {
		
		Rubrica rubrica = dao.selectById(idRubrica);
		
		if(rubrica != null) {
			
			List<ContattoDTO> rubricaGruppo = new LinkedList<ContattoDTO>();
			
			for (Map.Entry<Integer, Contatto> entry : rubrica.getContatti().entrySet()) {
				
				if(entry.getValue().getPreferito()) {
					
					rubricaGruppo.add(ConversioniContatto.daContattoAContattoDTO(entry.getValue()));
				}
			}
			
			if (rubricaGruppo.size() <= 0) {
				
				String error = "Non è presente nessun contatto in rubrica che sia un contatto preferito";
				throw new RuntimeException(error);
			}
			
			return rubricaGruppo;
		}
		return null;
	}

}