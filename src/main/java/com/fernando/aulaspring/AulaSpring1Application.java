package com.fernando.aulaspring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fernando.aulaspring.dominio.Categorias;
import com.fernando.aulaspring.repositories.CategoriaRepository;

@SpringBootApplication
public class AulaSpring1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AulaSpring1Application.class, args);
	}
	
	@Autowired
	private CategoriaRepository categoriaRepoisitory ;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categorias cat1 = new Categorias(null, "Informática");
		Categorias cat2 = new Categorias(null, "Escritório");
		
		categoriaRepoisitory.saveAll(Arrays.asList(cat1,cat2));
		
		
	}

}
