package com.fernando.aulaspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fernando.aulaspring.dominio.Categorias;
import com.fernando.aulaspring.repositories.CategoriaRepository;
import com.fernando.aulaspring.services.exceptions.DataIntegrityException;
import com.fernando.aulaspring.services.exceptions.ObjectNotFoundException;


// A classe serviço é respónsável por fazer o elo com o repositorio
@Service
public class CategoriaService {
	
	// aqui é instanciado em repo o banco de dados
	@Autowired
	private CategoriaRepository repo;
	
	// busca o integer id no repositorio instanciado em repo com o método findByid. Optional permite que se não encontrado retorne nulo
	public Categorias find(Integer id) {
		Optional<Categorias> obj = repo.findById(id);
		
 		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado id: "+id+", tipo: "+Categorias.class.getName()));
	}
	
	public List<Categorias> findAll() {
		List<Categorias> lista = repo.findAll();
		return lista;
	}
	
	public Categorias Insert(Categorias obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categorias update(Categorias obj) {
		
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {

		find(id);
	
		try {
			repo.deleteById(id);
		} 
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que já possua produtos associados");
		}
	}
} 

