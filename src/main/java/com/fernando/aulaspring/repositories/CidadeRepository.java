package com.fernando.aulaspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.aulaspring.dominio.Cidade;

// A interface repositorio instancia o banco de dados
public interface CidadeRepository extends  JpaRepository<Cidade, Integer>{

	

	
	
	
}
