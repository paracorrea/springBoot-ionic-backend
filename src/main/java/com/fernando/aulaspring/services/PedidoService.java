package com.fernando.aulaspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.aulaspring.dominio.Pedido;

import com.fernando.aulaspring.repositories.PedidoRepository;
import com.fernando.aulaspring.services.exceptions.ObjectNotFoundException;

// A classe serviço é respónsável por fazer o elo com o repositorio
@Service
public class PedidoService {

	// aqui é instanciado em repo o banco de dados
	@Autowired
	private PedidoRepository repo;

	// busca o integer id no repositorio instanciado em repo com o método findByid.
	// Optional permite que se não encontrado retorne nulo
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto não encontrado id: " + id + ", tipo: " + Pedido.class.getName()));
	}

	public List<Pedido> findAll() {
		List<Pedido> lista = repo.findAll();
		return lista;
	}
}
