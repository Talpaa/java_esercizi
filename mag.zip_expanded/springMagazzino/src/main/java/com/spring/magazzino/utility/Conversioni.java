package com.spring.magazzino.utility;

import com.spring.magazzino.dto.ProdottoDTO;
import com.spring.magazzino.dto.ProdottoNoIdDTO;
import com.spring.magazzino.entity.Prodotto;

public class Conversioni {

	public static Prodotto daProdottoDTOAProdotto(ProdottoDTO dto) {
		
		int id = dto.getId();
		String marca = dto.getMarca();
		String modello = dto.getModello();
		String descrizione = dto.getDescrizione();
		Double prezzoConsigliato = dto.getPrezzoConsigliato();
		Double prezzoMax = dto.getPrezzoMax();
		int quantità = dto.getQuantità();
		String categoria = dto.getCategoria();
		
		return new Prodotto(id, marca, modello, descrizione, prezzoConsigliato, prezzoMax, quantità, categoria);
	}

	public static ProdottoNoIdDTO daProdottoAProdottoNoIdDTO(Prodotto prodotto) {
		
		String marca = prodotto.getMarca();
		String modello = prodotto.getModello();
		String descrizione = prodotto.getDescrizione();
		Double prezzoConsigliato = prodotto.getPrezzoConsigliato();
		Double prezzoMax = prodotto.getPrezzoMax();
		int quantità = prodotto.getQuantità();
		String categoria = prodotto.getCategoria();
		return new ProdottoNoIdDTO(marca, modello, descrizione, prezzoConsigliato, prezzoMax, quantità, categoria);
	}

}
