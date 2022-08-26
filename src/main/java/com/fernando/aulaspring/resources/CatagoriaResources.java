package com.fernando.aulaspring.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.fernando.aulaspring.dominio.Categorias;
import com.fernando.aulaspring.dto.CategoriaDto;
import com.fernando.aulaspring.services.CategoriaService;

@RestController
//@RequestMapping(value="/categorias")
public class CatagoriaResources {

	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categorias> find(@PathVariable Integer id) {
		
		
		Categorias obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
	@RequestMapping(value="/categorias", method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDto>> findAll() {
		
		List<Categorias> lista = service.findAll();
		List<CategoriaDto> listaDto = lista
				.stream()
				.map(obj -> new CategoriaDto(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categorias obj) {
		obj = service.Insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categorias obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
