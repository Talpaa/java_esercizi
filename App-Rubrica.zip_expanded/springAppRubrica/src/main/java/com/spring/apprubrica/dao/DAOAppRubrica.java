package com.spring.apprubrica.dao;

import java.util.List;

import com.spring.apprubrica.entity.Contatto;
import com.spring.apprubrica.entity.Rubrica;

public interface DAOAppRubrica {

	//Rubrica
	public boolean insert(Rubrica rubrica);
	public List<Rubrica> selectAll();
	public Rubrica selectById(Integer idRubrica);
	public boolean delete(Integer idRubrica);
	public boolean update(Rubrica rubrica);
	
	//Contatto
	public boolean insert(Integer idRubrica, Contatto contatto);
}
