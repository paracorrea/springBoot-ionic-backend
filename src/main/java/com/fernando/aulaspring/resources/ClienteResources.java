package com.fernando.aulaspring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.aulaspring.dominio.Cliente;
import com.fernando.aulaspring.services.ClienteService;

@RestController
//@RequestMapping(value = "/clientes")
public class ClienteResources {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/cliente/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		
		Cliente obj = clienteService.find(id);
		return ResponseEntity.ok().body(obj);	}
	
	@RequestMapping(value="/cliente/todos", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		
		List<Cliente> obj = clienteService.buscarAll();
		return ResponseEntity.ok().body(obj)	;
				}
}
