package com.spring.universita.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.universita.entity.Professore;

public class DAOProfessoreMappa {
	
	private Map<Integer, Professore> mappa = new HashMap<>();

	public boolean insert(Professore professore) {
		if(mappa.containsKey(professore.getId()))
			return false;
		
		mappa.put(professore.getId(), professore);
		return true;

	}
	
	public List<Professore> selectAll(){
		return new ArrayList<>(mappa.values());
	}

	public Professore selectById(Integer idProf) {
		return mappa.get(idProf);
	}
	
	public boolean delete(Integer idProf) {
		Professore utente = mappa.remove(idProf);
		return utente!=null;
	}
}
