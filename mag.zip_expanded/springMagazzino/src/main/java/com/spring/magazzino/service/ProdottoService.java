package com.spring.magazzino.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.spring.magazzino.dao.DAOProdottoMappa;
import com.spring.magazzino.dto.ProdottoDTO;
import com.spring.magazzino.dto.ProdottoNoIdDTO;
import com.spring.magazzino.dto.ReportDTO;
import com.spring.magazzino.entity.Prodotto;
import com.spring.magazzino.utility.Conversioni;

public class ProdottoService {

	private DAOProdottoMappa dao = new DAOProdottoMappa();
	
	public boolean carica(ProdottoDTO dto) {
		
		Prodotto entity = Conversioni.daProdottoDTOAProdotto(dto);
		return dao.insert(entity);
	}
	
	public List<Boolean> caricaTutti(LinkedList<ProdottoDTO> prodottiDTO) {
		
		List<Boolean> risposte = new LinkedList<Boolean>(); 
		
		for(ProdottoDTO dto: prodottiDTO) {
			
			Prodotto entity = Conversioni.daProdottoDTOAProdotto(dto);
			risposte.add(dao.insert(entity));
		}
		
		return risposte;
	}
	
	public LinkedList<ProdottoNoIdDTO> mostraProdotti(){
		
		List<Prodotto> prodotti = dao.selectAll();
		LinkedList<ProdottoNoIdDTO> prodottiNoId = new LinkedList<ProdottoNoIdDTO>();
		
		for(Prodotto prodotto: prodotti) {
			prodottiNoId.add(Conversioni.daProdottoAProdottoNoIdDTO(prodotto));
		}
		
		return prodottiNoId;
	}
	
	public ProdottoNoIdDTO cercaPerId(int id) {
		
		Prodotto prodotto = dao.selectById(id);
		if(prodotto != null) {
			return Conversioni.daProdottoAProdottoNoIdDTO(prodotto);
		}
		return null;
	}
	
	public ReportDTO report() {
		
		LinkedList<String> descrizioni = new LinkedList<String>();
		int pezziTotaliMagazzino = 0;
		int prodottiNonDisponibili = 0;
		LinkedList<String> marcheModelli = new LinkedList<String>();
		double mediaPrezzi = 0;
		LinkedList<String> nomiProdottiNonDisponibili = new LinkedList<String>();
		
		Map<String, LinkedList<Integer>> elencoCategorie = new HashMap<>();
        // Adding a key-value pair
        //myMap.put("numbers", new LinkedList<Integer>());
		
		
		List<Prodotto> prodotti = dao.selectAll();
		
		for(Prodotto prodotto: prodotti) {
			
			pezziTotaliMagazzino += 1;
			descrizioni.add(prodotto.getDescrizione());
			
			if(prodotto.getQuantità() <= 0) {
				prodottiNonDisponibili += 1;
				nomiProdottiNonDisponibili.add(prodotto.getMarca() + " " + prodotto.getModello());
			}
			
			
			String marcaModello = prodotto.getMarca() + " " + prodotto.getModello();
			
			if( !(marcheModelli.contains(marcaModello)) ) {
				marcheModelli.add(marcaModello);
				mediaPrezzi += prodotto.getPrezzoConsigliato();
			}
			
			if ( !(elencoCategorie.containsKey(prodotto.getCategoria())) ) {
				
				elencoCategorie.put(prodotto.getCategoria(), new LinkedList<Integer>());
				elencoCategorie.get(prodotto.getCategoria()).add(prodotto.getId());
			}else {
				
				elencoCategorie.get(prodotto.getCategoria()).add(prodotto.getId());
			}
			
		}
		
		mediaPrezzi = mediaPrezzi / marcheModelli.size();
		
		return new ReportDTO(descrizioni, pezziTotaliMagazzino, prodottiNonDisponibili, mediaPrezzi, nomiProdottiNonDisponibili, elencoCategorie);
	}
}
