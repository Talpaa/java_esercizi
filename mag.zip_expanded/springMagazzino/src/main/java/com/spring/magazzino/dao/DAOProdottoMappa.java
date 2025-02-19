package com.spring.magazzino.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.magazzino.entity.Prodotto;

public class DAOProdottoMappa {

	private Map<Integer, Prodotto> mappa = new HashMap<>();

	public boolean insert(Prodotto prodotto) {
		if(mappa.containsKey(prodotto.getId()))
			return false;
		
		mappa.put(prodotto.getId(), prodotto);
		return true;

	}
	public List<Prodotto> selectAll(){
		return new ArrayList<>(mappa.values());
	}

	public Prodotto selectById(Integer idProdotto) {
		return mappa.get(idProdotto);
	}
	
	public boolean delete(Integer idProdotto) {
		Prodotto utente = mappa.remove(idProdotto);
		return utente!=null;
	}
}
