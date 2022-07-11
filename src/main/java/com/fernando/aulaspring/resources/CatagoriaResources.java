package com.fernando.aulaspring.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.aulaspring.dominio.Categorias;

@RestController
@RequestMapping(value="/categories")
public class CatagoriaResources {

	@RequestMapping(method=RequestMethod.GET)
	public List<Categorias> listar() {
		
		Categorias cat1 = new Categorias(1,"Informatica");
		Categorias cat2 = new Categorias(2, "Escritório");
		
		List<Categorias> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		
		return lista;
		
	}
	
}
