package com.spring.impiegato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.impiegato.dto.ImpiegatoDTO;
import com.spring.impiegato.dto.ImpiegatoNomeCognomeDTO;
import com.spring.impiegato.service.ImpiegatoService;

@RestController
@RequestMapping(path = "/ufficio")
public class ImpiegatoController {

	@Autowired
	private ImpiegatoService service;
	
	//Assumi nuovo impiegato
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean assumi(@RequestBody ImpiegatoDTO dto) {
		
		return service.assumi(dto);
	}
	
	//Assumi nuovi impiegati
	@PostMapping(path = "/impiegati", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<ImpiegatoDTO> assumiInBlocco(@RequestBody List<ImpiegatoDTO> impiegatiDTO) {
		
		return service.assumiInBlocco(impiegatiDTO);
	}
	
	//Cerca impiegato per matricola
	@GetMapping(path = "/{matricola}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ImpiegatoDTO cerca(@PathVariable int matricola) {
		return service.cerca(matricola);
	}
	
	//Visualizza tutti gli impiegati
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ImpiegatoDTO> visualizza(){
		return service.visualizza();
	}
	
	//Cancella un impiegato tramite la matricola e ritornalo
	@DeleteMapping(path = "/{matricola}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ImpiegatoDTO licenzia(@PathVariable int matricola) {
		return service.licenzia(matricola);
	}
	
	//Modifica il salario di un impiegato esistente (passando la matricola e il nuovo salario) e ritorna l’impiegato aggiornato
	@PatchMapping(path = "/{matricola}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ImpiegatoDTO modificaSalario(@PathVariable int matricola, @RequestParam Double newSalario) {
		return service.modificaSalario(matricola, newSalario);
	}
	
	
	  ////////////////
	 ////AVANZATE////
	////////////////
	
	
	//Cancella un impiegato tramite la matricola e torna solo nome e cognome
	@DeleteMapping(path = "/{matricola}/nomecognome", produces = MediaType.APPLICATION_JSON_VALUE)
	public ImpiegatoNomeCognomeDTO licenziaNomeCognome(@PathVariable int matricola) {
		return service.licenziaNomeCognome(matricola);
	}
	//Visualizza la lista dei nominativi (nome e cognome) degli impiegati
	@GetMapping(path = "/nomecognome", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ImpiegatoNomeCognomeDTO> visualizzaNomeCOgnome(){
		return service.visualizzaNomeCognome();
	}
	
	//Visualizza tutti gli impiegati col salario maggiore di un valore specificato
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ImpiegatoDTO> visualizzaSalari(@RequestParam Double salario){
		return service.visualizzaSalari(salario);
	}
	
	//Visualizza tutti gli impiegati ordinati per cognome
	@GetMapping(path = "/cognomi", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ImpiegatoDTO> ordinaCognomi(){
		return service.ordinaCognomi();
	}
	//Visualizza tutti gli impiegati ordinati per salario
	@GetMapping(path = "/salari", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ImpiegatoDTO> ordinaSalari(){
		return service.ordinaSalari();
	}
}
