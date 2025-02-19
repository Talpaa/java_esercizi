package com.spring.first.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController		//indica a spring che dovrà istanziare e gestire questa classe
@RequestMapping(path = "/calcolatrice")
public class CalcolatriceController {

	//qui ci sarebbe il costruttore di default
	@GetMapping(path = "/sum")
	public int somma(int a, int b) {
		return a + b;
	}
	
	@GetMapping(path = "/sub")
	public int sottrazione(int a, int b) {
		return a - b;
	}
	
	@GetMapping(path = "/mult")
	public int moltiplicazione(int a, int b) {
		return a * b;
	}
	
	@GetMapping(path = "/div")
	public double divisione(int a, int b) {
		return a / b;
	}
}
