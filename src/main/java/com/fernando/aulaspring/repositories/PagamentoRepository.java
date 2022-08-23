package com.fernando.aulaspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.aulaspring.dominio.Pagamento;

// A interface repositorio instancia o banco de dados
public interface PagamentoRepository extends  JpaRepository<Pagamento, Integer>{

	

	
	
	
}
