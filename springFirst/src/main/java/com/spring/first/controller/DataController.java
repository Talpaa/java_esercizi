package com.spring.first.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data")
public class DataController {

	@GetMapping(path = "/corrente")
	public String DataCorrente() {
		Date d = new Date();
		
		return d.toString();
	}
}
