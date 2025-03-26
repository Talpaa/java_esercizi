package com.spring.studente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.studente.dto.StudenteDTO;
import com.spring.studente.service.StudenteService;


@RestController
@RequestMapping(path = "/universita")
public class StudenteController {
	
	@Autowired
	private StudenteService service;
	
		//Immatricola un nuovo studente
		@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
		public boolean registra(@RequestBody StudenteDTO dto) {
			
			return service.immatricola(dto);
		}
		
		//Immatricola un nuovi studenti
		@PostMapping(path = "/studenti", consumes = MediaType.APPLICATION_JSON_VALUE)
		public List<StudenteDTO> registraStudenti(@RequestBody List<StudenteDTO> studentiDTO) {
			
			return service.immatricolaStudenti(studentiDTO);
		}
		
		//Visualizza uno studente per id
		@GetMapping(path = "/{matricola}", produces = MediaType.APPLICATION_JSON_VALUE)
		public StudenteDTO cerca(@PathVariable int matricola) {
			
			return service.cerca(matricola);
		}
		
		//Visualizza tutti gli studenti
		@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<StudenteDTO> cercaId() {
			
			return service.mostra();
		}
		
		//Elimina studete per ID
		@DeleteMapping(path = "/{matricola}", produces = MediaType.APPLICATION_JSON_VALUE)
		public StudenteDTO elimina(@PathVariable Integer matricola) {
			return service.elimina(matricola);
		}
		
		//Modifica studente per ID
		@PutMapping(path = "/{matricola}", produces = MediaType.APPLICATION_JSON_VALUE)
		public StudenteDTO modifica(@PathVariable Integer matricola, @RequestBody StudenteDTO dto) {
			
			return service.modifica(matricola, dto);
		}
		
		//Visualizza una lista di studenti che hanno l'anno di immatricolazione più grande di quello inserito
		@GetMapping(path = "/giovani", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<StudenteDTO> getGiovani(@RequestParam int annoImm){
			return service.getGiovani(annoImm);
		}
}
