package com.spring.impiegato.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.impiegato.entity.Impiegato;

public interface DaoImpiegato extends JpaRepository<Impiegato, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM impiegato WHERE salario > :sal;")
	public List<Impiegato> getSalari(Double sal);
	
	@Query(nativeQuery = true, value = "SELECT * FROM impiegato ORDER BY impiegato.cognome;")
	public List<Impiegato> ordinaCognomi();
	
	@Query(nativeQuery = true, value = "SELECT * FROM impiegato ORDER BY impiegato.salario;")
	public List<Impiegato> ordinaSalari();
}
