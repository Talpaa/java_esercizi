package com.spring.magazzino.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.magazzino.dto.ProdottoDTO;
import com.spring.magazzino.dto.ProdottoNoIdDTO;
import com.spring.magazzino.dto.ReportDTO;
import com.spring.magazzino.service.ProdottoService;

@RestController
@RequestMapping(path = "/magazzino")
public class MagazzinoController {

	private ProdottoService service = new ProdottoService();

	@GetMapping(path = "/carica/prodotto", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean caricaProdotto(@RequestBody ProdottoDTO dto) {
		return service.carica(dto);
	}
	
	@GetMapping(path = "/carica/prodotti", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Boolean> caricaProdotti(@RequestBody LinkedList<ProdottoDTO> prodottiDTO) {
		return service.caricaTutti(prodottiDTO);
	}
	
	@GetMapping(path = "/cerca/prodotto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProdottoNoIdDTO ricercaProdottoId(@PathVariable int id) {
		
		return service.cercaPerId(id);
	}
	
	@GetMapping(path = "/mostra/prodotti", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProdottoNoIdDTO> mostraProdotti(){
		return service.mostraProdotti();
	}
	
	
	
	@GetMapping(path = "/report/prodotti", produces = MediaType.APPLICATION_JSON_VALUE)
	public ReportDTO report() {
		return service.report();
	}
}
