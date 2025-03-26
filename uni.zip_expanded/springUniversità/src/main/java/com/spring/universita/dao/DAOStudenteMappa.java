package com.spring.universita.dao;

import java.util.List;

import com.spring.universita.entity.Studente;

public interface DAOStudenteMappa {

	public boolean insert(Studente studente);
	public List<Studente> selectAll();
	public Studente selectById(Integer idStudente);
	public boolean delete(Integer idStudente);
}
