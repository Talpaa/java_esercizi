package com.spring.apprubrica.service;

import java.util.List;

import com.spring.apprubrica.dto.contatto.ContattoDTO;
import com.spring.apprubrica.dto.contatto.ContattoNoIDDTO;
import com.spring.apprubrica.dto.contatto.ContattoNomeCognomeDTO;

public interface ContattoService {

	//Inserisci nuovo contatto
	public boolean registraContatto(Integer idRubrica, ContattoDTO dto);
	
	//Visualizza un contatto per id
	public ContattoDTO cercaContatto(Integer idRubrica, Integer idContatto);
	
	//Visualizza il contatto con un dato numero
	public ContattoDTO cercaContattoNumero(int idRubrica, int numeroTelefono);
	
	//Modifica un contatto esistente (tutti i campi tranne la chiave primaria)
	public ContattoDTO modificaContatto(int idRubrica, int idContatto, ContattoNoIDDTO dto);
	
	//Cancella un contatto esistente
	public ContattoDTO eliminaContatto(int idRubrica, int idContatto);
	
	//Cancella un gruppo di una rubrica (cioè tutti i contatti appartenenti ad un dato gruppo)
	public List<ContattoDTO> eliminaContattiGruppo(int idRubrica, String gruppo);
	
	//Visualizza tutti i contatti registrati
	public List<ContattoDTO> mostraTuttiContatti(int idRubrica);
	
	//Ricerca il nome e il cognome dei contatti di un dato gruppo 
	public List<ContattoNomeCognomeDTO> mostraTuttiNomiCognomiGruppo(int idRubrica, String gruppo);
	
	//Visualizza il numero di contatti registrati
	public Integer numeroContatti(int idRubrica);
	
	////Ricerca il numero di contatti di un dato gruppo
	public Integer numeroContattiGruppo(int idRubrica, String gruppo);
	
	//Modifica un contatto da NON preferito a preferito
	public ContattoDTO contattoPreferito(int idRubrica, int idContatto);
	
	//Ricerca tutti i preferiti 
	public List<ContattoDTO> preferiti(int idRubrica);
}
