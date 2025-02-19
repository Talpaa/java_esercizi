package com.spring.universita.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.universita.dto.studente.CognomeAnnoIscrizioneDTO;
import com.spring.universita.dto.studente.CognomeAnnoNascitaDTO;
import com.spring.universita.dto.studente.StudenteDTO;
import com.spring.universita.entity.Studente;
import com.spring.universita.service.StudenteService;


@RestController
@RequestMapping(path = "/universita/studente")
public class StudenteController {

	private StudenteService service = new StudenteService();
	
	@RequestMapping(path = "/carica", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean caricaStud(@RequestBody StudenteDTO stud) {
		return service.carica(stud);
	}
	
	@RequestMapping(path = "/cerca/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudenteDTO cercaStud(@PathVariable int id) {
		return service.cerca(id);
	}
	
	@GetMapping(path = "/mostra/tutti", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudenteDTO> mostraStud(){
		return service.mostraStudenti();
	}
	
	@RequestMapping(path = "/elimina/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudenteDTO eliminaStud(@PathVariable int id) {
		return service.elimina(id);
	}
	
	@RequestMapping(path = "/modifica/indirizzo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudenteDTO modIndStud(@PathVariable int id, String indirizzo) {
		return service.modificaIndStud(id, indirizzo);
	}
	
	@RequestMapping(path = "/elenco/nomi", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> elencoNomi(){
		return service.elencoNomi();
	}
	
	@RequestMapping(path = "/giovane", produces = MediaType.APPLICATION_JSON_VALUE)
	public CognomeAnnoNascitaDTO giovaneStud() {
		return service.giovaneStud();
	}
	
	@RequestMapping(path = "/primo/iscritto", produces = MediaType.APPLICATION_JSON_VALUE)
	public CognomeAnnoIscrizioneDTO primoStud() {
		return service.primoStud();
	}
}
