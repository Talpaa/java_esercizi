package com.spring.universita.dao;

import java.util.List;

import com.spring.universita.entity.Professore;

public interface DAOProfessoreMappa {

	public boolean insert(Professore professore);
	public List<Professore> selectAll();
	public Professore selectById(Integer idProf);
	public boolean delete(Integer idProf);
}
