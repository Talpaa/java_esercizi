package com.spring.first.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/lotto")
public class EstrazioniLottoController {

	@GetMapping(path = "/5num")
	public int[] Lotto5Num() {
		
		//int[] numeri = {-1, -1, -1, -1, -1};
		int[] numeri = new int[50];
		
		numeri[0] = (int) (Math.random() * 100);
		
		for (int i=1; i<numeri.length ; i++) {
			
			Boolean ris = true;
			int n = 0;
			
			while(ris) {
				n = (int) (Math.random() * 100);
				ris = false;
				for(int num: numeri) {
					if (num == n) {
						ris = true;
					}
				}
			}
			numeri[i] = n;
		}
		return numeri;
	}
}
