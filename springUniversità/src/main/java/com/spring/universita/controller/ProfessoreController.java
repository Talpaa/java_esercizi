package com.spring.universita.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.universita.dto.professore.ProfessoreDTO;
import com.spring.universita.dto.studente.CognomeAnnoIscrizioneDTO;
import com.spring.universita.dto.studente.CognomeAnnoNascitaDTO;
import com.spring.universita.service.ProfessoreService;

/*
Avanzato:
Visualizza tutti i professori che insegnano una materia specificata
Visualizza i professori ordinati per cognome
Visualizza tutte le materie insegnate.
 */

@RestController
@RequestMapping(path = "/universita/professore")
public class ProfessoreController {

private ProfessoreService service = new ProfessoreService();
	
	@RequestMapping(path = "/carica", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean caricaStud(@RequestBody ProfessoreDTO stud) {
		return service.carica(stud);
	}
	
	@RequestMapping(path = "/cerca/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfessoreDTO cercaStud(@PathVariable int id) {
		return service.cerca(id);
	}
	
	@GetMapping(path = "/mostra/tutti", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProfessoreDTO> mostraStud(){
		return service.mostraProfessori();
	}
	
	@RequestMapping(path = "/elimina/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfessoreDTO eliminaProf(@PathVariable int id) {
		return service.elimina(id);
	}
	
	@RequestMapping(path = "/modifica/materia/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfessoreDTO modProfMateria(@PathVariable int id, String materia) {
		return service.modificaProfMateria(id, materia);
	}
	
//	@RequestMapping(path = "/elenco/nomi", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<String> elencoNomi(){
//		return service.elencoNomi();
//	}
//	
//	@RequestMapping(path = "/giovane", produces = MediaType.APPLICATION_JSON_VALUE)
//	public CognomeAnnoNascitaDTO giovaneStud() {
//		return service.giovaneStud();
//	}
//	
//	@RequestMapping(path = "/primo/iscritto", produces = MediaType.APPLICATION_JSON_VALUE)
//	public CognomeAnnoIscrizioneDTO primoStud() {
//		return service.primoStud();
//	}
}
