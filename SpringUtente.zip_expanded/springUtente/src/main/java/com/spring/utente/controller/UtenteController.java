package com.spring.utente.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.utente.dto.ErroreDTO;
import com.spring.utente.dto.NomeCognomeDTO;
import com.spring.utente.dto.UtenteDTO;
import com.spring.utente.service.UtenteService;

@RestController
@RequestMapping(path="/utenti")
public class UtenteController {
	
	@Autowired
	private UtenteService service;

	@PostMapping(path="", consumes = "application/json")
	public boolean registra(@RequestBody  UtenteDTO dto) {
		// fake
		//System.out.println("ho registrato l'utente: "  + utente);
		//return true;
		
		return service.registra(dto);
		
	}
		
	@GetMapping(path="/{id}", produces = "application/json")
	public UtenteDTO cercaPerId(@PathVariable  int id) {
		// fake
		//return new Utente(id, "mario", "rossi", "mario", "red");
		
		return service.cercaPerId(id);
	}
	
	@GetMapping(path="", produces = "application/json")
	public List<UtenteDTO> mostraTutti(){
		return service.mostraTutti();
	}
	
	@PatchMapping(path="/{idUtente}", produces = "application/json")
	public UtenteDTO modificaMail(@PathVariable int idUtente, String password) {
		return service.updatePassword(idUtente, password);
	}
	
	@DeleteMapping(path="/{idUtente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UtenteDTO cancellaUtente(@PathVariable int idUtente) {
		return service.cancella(idUtente);
	}

	@GetMapping(path="/{idUtente}/nomeCognome", produces = MediaType.APPLICATION_JSON_VALUE)
	public NomeCognomeDTO getNomeCognome(@PathVariable int idUtente) {
		return service.getNomeCognome(idUtente);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> gestore(RuntimeException exc){
		ErroreDTO errore = new ErroreDTO(exc.getMessage());
		ResponseEntity<ErroreDTO> response = new ResponseEntity<ErroreDTO>(errore, HttpStatus.NOT_FOUND);
	
		return response;
	}
	
}
