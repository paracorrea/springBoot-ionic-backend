package com.fernando.aulaspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.aulaspring.dominio.Produto;

// A interface repositorio instancia o banco de dados
public interface ProdutoRepository extends  JpaRepository<Produto, Integer>{

	
	

}
