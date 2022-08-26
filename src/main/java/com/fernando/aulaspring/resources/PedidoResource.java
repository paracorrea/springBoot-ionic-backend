package com.fernando.aulaspring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fernando.aulaspring.dominio.Pedido;
import com.fernando.aulaspring.services.PedidoService;

@RestController
//@RequestMapping(value = "/clientes")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value="/pedido/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Pedido obj = pedidoService.buscar(id);
		return ResponseEntity.ok().body(obj);	}
	
	@RequestMapping(value="/pedido/todos", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		
		List<Pedido> obj = pedidoService.findAll();
		return ResponseEntity.ok().body(obj)	;
				}
}
