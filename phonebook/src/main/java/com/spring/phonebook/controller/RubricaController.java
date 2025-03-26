package com.spring.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.phonebook.dto.ContattoDTO;
import com.spring.phonebook.dto.RubricaDTO;
import com.spring.phonebook.service.RubricaService;

@RestController
@RequestMapping(path = "/rubriche")
public class RubricaController {

	
	@Autowired
	private RubricaService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean crea(@RequestBody RubricaDTO dto) {
		return service.creaRubrica(dto);
	}
	
	@GetMapping(path = "/{idRubrica}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RubricaDTO cerca(@PathVariable Integer idRubrica) {
		return service.cercaPerId(idRubrica);
	}
	
	@PostMapping(path = "/{idRubrica}/contatti", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean aggiungi(@PathVariable Integer idRubrica, @RequestBody ContattoDTO dto) {
		return service.aggiungiContatto(idRubrica, dto);
	}
}
