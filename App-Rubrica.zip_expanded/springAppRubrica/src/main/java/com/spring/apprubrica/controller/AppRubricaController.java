package com.spring.apprubrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.apprubrica.dto.rubrica.ProprietarioCreazioneDTO;
import com.spring.apprubrica.dto.rubrica.RubricaDTO;
import com.spring.apprubrica.dto.contatto.ContattoDTO;
import com.spring.apprubrica.dto.contatto.ContattoNoIDDTO;
import com.spring.apprubrica.dto.contatto.ContattoNomeCognomeDTO;
import com.spring.apprubrica.dto.rubrica.NomiENumeroProprietariDTO;
import com.spring.apprubrica.dto.rubrica.ProprietarioRubricaDTO;
import com.spring.apprubrica.service.ContattoService;
import com.spring.apprubrica.service.RubricaService;
import com.spring.apprubrica.dto.ErroreDTO;

@RestController
@RequestMapping(path = "/rubriche")
public class AppRubricaController {
	
	@Autowired
	private RubricaService rubricaService;

	//Inserisci nuova rubrica (vuota)
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean registra(@RequestBody RubricaDTO dto) {
		
		return rubricaService.registra(dto);
	}
	
	//Visualizza una rubrica per id
	@GetMapping(path = "/{idRubrica}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RubricaDTO cercaId(@PathVariable int idRubrica) {
		
		return rubricaService.cercaPerId(idRubrica);
	}
	
	//Visualizza tutte le rubriche
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RubricaDTO> mostratutte(){
		return rubricaService.mostraTutte();
	}
	
	//Cancella una rubrica esistente
	@DeleteMapping(path = "/{idRubrica}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RubricaDTO cancellaRubrica(@PathVariable int idRubrica) {
		return rubricaService.cancella(idRubrica);
	}
	
	
	

	//Visualizza solo proprietario e anno creazione di una rubrica (passando l’ id)
	@GetMapping(path = "/{idRubrica}/proprietariocreazione", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProprietarioCreazioneDTO getProprietarioCreazione(@PathVariable int idRubrica) {
		return rubricaService.getProprietarioCreazione(idRubrica);
	}
	
	
	//Modifica anno di creazione di una rubrica esistente (torna la rubrica aggiornata)
	@PatchMapping(path = "/{idRubrica}/annocreazione", produces = MediaType.APPLICATION_JSON_VALUE)
	public RubricaDTO modificaAnnoCreazione(@PathVariable int idRubrica, int annoCreazione) {
		return rubricaService.modificaAnnoCreazione(idRubrica, annoCreazione);
	}
	
	//Modifica il nome proprietario di una rubrica esistente (torna la rubrica aggiornata)
	@PatchMapping(path = "/{idRubrica}/proprietario", produces = MediaType.APPLICATION_JSON_VALUE)
	public RubricaDTO modificaProprietario(@PathVariable int idRubrica, String proprietario) {
		return rubricaService.modificaProprietario(idRubrica, proprietario);
	}
	
	//Visualizza i nomi di tutti i proprietari delle rubriche e il loro numero totale
	@GetMapping(path = "/proprietari", produces = MediaType.APPLICATION_JSON_VALUE)
	public NomiENumeroProprietariDTO listaNomiENumeroProprietariDTO() {
		return rubricaService.listaNomiENumeroProprietariDTO();
	}
	
	//Visualizza nome proprietario e anno creazione della rubrica più vecchia
	@GetMapping(path = "/rubricapiuvecchia", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProprietarioCreazioneDTO getRubricaPiuVecchia() {
		return rubricaService.getRubricaPiuVecchia();
	}
	
	//Visualizza tutti gli anni di creazione (delle rubriche) in ordine crescente
	@GetMapping(path = "/annicreazione", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Integer> getAnniCreazione(){
		return rubricaService.getAnniCreazione();
	}
	
	//Visualizza nome proprietario e numero contatti di una rubrica
	@GetMapping(path = "/{idRubrica}/proprietariorubrica", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProprietarioRubricaDTO getProprietarioRubrica(@PathVariable int idRubrica) {
		return rubricaService.getProprietarioRubrica(idRubrica);
	}
	
	
	
	
	//Fissata una rubrica definita tramite id, eseguire:
	@Autowired
	private ContattoService contattoService;
	
	//Inserisci nuovo contatto
	@PostMapping(path = "/{idRubrica}/contatti", consumes = MediaType.APPLICATION_JSON_VALUE)
	public  boolean registraContatto(@PathVariable int idRubrica, @RequestBody ContattoDTO dto) {
		
		if((dto.getPreferito() == null)&&(dto.getGruppoDiAppartenenza() == null)) {
			ContattoDTO defaultdto = new ContattoDTO(dto.getId(), dto.getNome(), dto.getCognome(), dto.getNumero(), dto.getAnnoNascita());
			return contattoService.registraContatto(idRubrica, defaultdto);
		}else if (dto.getPreferito() == null) {
			ContattoDTO defaultdto = new ContattoDTO(dto.getId(), dto.getNome(), dto.getCognome(), dto.getNumero(), dto.getGruppoDiAppartenenza(), dto.getAnnoNascita());
			return contattoService.registraContatto(idRubrica, defaultdto);
		}else if (dto.getGruppoDiAppartenenza() == null) {
			ContattoDTO defaultdto = new ContattoDTO(dto.getId(), dto.getNome(), dto.getCognome(), dto.getNumero(), dto.getAnnoNascita(), dto.getPreferito());
			return contattoService.registraContatto(idRubrica, defaultdto);
		}
		return contattoService.registraContatto(idRubrica, dto);
	}
	
	//Visualizza un contatto per id
	@GetMapping(path = "/{idRubrica}/contatti/{idContatto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ContattoDTO cercaContatto(@PathVariable Integer idRubrica,@PathVariable Integer idContatto) {
		return contattoService.cercaContatto(idRubrica, idContatto);
	}
	
	//Visualizza il contatto con un dato numero
	@GetMapping(path = "/{idRubrica}/contatti/numero", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ContattoDTO cercaContattoNumero(@PathVariable int idRubrica, int numeroTelefono) {
		return contattoService.cercaContattoNumero(idRubrica, numeroTelefono);
	}
	
	//Modifica un contatto esistente (tutti i campi tranne la chiave primaria)
	@PutMapping(path = "/{idRubrica}/contatti/{idContatto}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ContattoDTO modificaContatto(@PathVariable int idRubrica,@PathVariable int idContatto, @RequestBody ContattoNoIDDTO dto) {
		return contattoService.modificaContatto(idRubrica, idContatto, dto);
	}
	
	//Cancella un contatto esistente
	@DeleteMapping(path = "/{idRubrica}/contatti/{idContatto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ContattoDTO eliminaContatto(@PathVariable int idRubrica,@PathVariable int idContatto) {
		return contattoService.eliminaContatto(idRubrica, idContatto);
	}
	
	//Cancella un gruppo di una rubrica (cioè tutti i contatti appartenenti ad un dato gruppo)
	@DeleteMapping(path = "/{idRubrica}/contatti", produces = MediaType.APPLICATION_JSON_VALUE)
	public  List<ContattoDTO> eliminaContattiGruppo(@PathVariable int idRubrica, String gruppo) {
		return contattoService.eliminaContattiGruppo(idRubrica, gruppo);
	}
	
	//Visualizza tutti i contatti registrati
	@GetMapping(path = "/{idRubrica}/contatti", produces = MediaType.APPLICATION_JSON_VALUE)
	public  List<ContattoDTO> mostraTuttiContatti(@PathVariable int idRubrica) {
		return contattoService.mostraTuttiContatti(idRubrica);
	}
	
	//Visualizza il numero di contatti registrati
	@GetMapping(path = "/{idRubrica}/contatti/numerocontatti", produces = MediaType.APPLICATION_JSON_VALUE)
	public  Integer numeroContatti(@PathVariable int idRubrica) {
		return contattoService.numeroContatti(idRubrica);
	}
	
	//Ricerca il nome e il cognome dei contatti di un dato gruppo 
	@GetMapping(path = "/{idRubrica}/contatti/gruppo", produces = MediaType.APPLICATION_JSON_VALUE)
	public  List<ContattoNomeCognomeDTO> mostraTuttiNomiCognomiGruppo(@PathVariable int idRubrica, String gruppo) {
		return contattoService.mostraTuttiNomiCognomiGruppo(idRubrica, gruppo);
	}
	
	//Ricerca il numero di contatti di un dato gruppo
	@GetMapping(path = "/{idRubrica}/contatti/numerocontattigruppo", produces = MediaType.APPLICATION_JSON_VALUE)
	public  Integer numeroContattiGruppo(@PathVariable int idRubrica, String gruppo) {
		return contattoService.numeroContattiGruppo(idRubrica, gruppo);
	}
	
	//Modifica un contatto da NON preferito a preferito
	@PatchMapping(path = "/{idRubrica}/contatti/{idContatto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContattoDTO contattoPreferito(@PathVariable int idRubrica,@PathVariable int idContatto) {
		return contattoService.contattoPreferito(idRubrica, idContatto);
	}
	
	//Ricerca tutti i preferiti 
	@GetMapping(path = "/{idRubrica}/contatti/preferiti", produces = MediaType.APPLICATION_JSON_VALUE)
	public  List<ContattoDTO> preferiti(@PathVariable int idRubrica) {
		return contattoService.preferiti(idRubrica);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> gestore(RuntimeException exc){
		ErroreDTO errore = new ErroreDTO(exc.getMessage());
		ResponseEntity<ErroreDTO> response = new ResponseEntity<ErroreDTO>(errore, HttpStatus.NOT_FOUND);
	
		return response;
	}
}
