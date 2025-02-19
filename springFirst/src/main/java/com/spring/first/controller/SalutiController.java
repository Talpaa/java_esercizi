package com.spring.first.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/saluto")
public class SalutiController {

	public SalutiController() {
		System.out.println("Spring istanzia SalutiController...");
	}
	
	@GetMapping(path = "/generico")
	public String salutoGenerico() {
		return "Hello World";
	}
	
	@GetMapping(path = "/pers")
	public String salutoPers(String nome) {
		return "Hello " + nome;
	}
}
