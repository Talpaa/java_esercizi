package com.spring.universita.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(path = "/universita/professore")
public class ProfessoreController {

	@Autowired
	private ProfessoreService service;
	
	@RequestMapping(path = "/carica", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean caricaProf(@RequestBody ProfessoreDTO stud) {
		return service.carica(stud);
	}
	
	@GetMapping(path = "/carica/tutti", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Boolean> caricaProfessori(@RequestBody LinkedList<ProfessoreDTO> professoriDTO) {
		return service.caricaProfessori(professoriDTO);
	}
	
	@RequestMapping(path = "/cerca/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfessoreDTO cercaProf(@PathVariable int id) {
		return service.cerca(id);
	}
	
	@GetMapping(path = "/mostra/tutti", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProfessoreDTO> mostraProf(){
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
	
	@GetMapping(path = "/cerca/{materia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProfessoreDTO> cercaProfPerMateria(@PathVariable String materia){
		return service.cercaProfPerMateria(materia);
	}

	@RequestMapping(path = "/ordina", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProfessoreDTO> ordinaProfessori() {
		return service.ordinaProfessori();
	}
	
	@RequestMapping(path = "/elenco/materie", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<String> elencoMaterie() {
		return service.elencoMaterie();
	}
}



