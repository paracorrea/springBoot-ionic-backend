
package com.fernando.aulaspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.aulaspring.dominio.Cliente;
import com.fernando.aulaspring.repositories.ClienteRepository;
import com.fernando.aulaspring.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository cliRepo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = cliRepo.findById(id);
		
 		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado id: "+id+", tipo: "+Cliente.class.getName()));
	}
	
	public List<Cliente> buscarAll() {
		List<Cliente> lista = cliRepo.findAll();
		
 		return lista;
	}
	
}
