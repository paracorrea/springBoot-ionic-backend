package com.fernando.aulaspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.aulaspring.dominio.Cliente;

// A interface repositorio instancia o banco de dados
public interface ClienteRepository extends  JpaRepository<Cliente, Integer>{

	

	
	
	
}
