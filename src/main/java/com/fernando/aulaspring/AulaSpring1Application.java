package com.fernando.aulaspring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fernando.aulaspring.dominio.Categorias;
import com.fernando.aulaspring.dominio.Cidade;
import com.fernando.aulaspring.dominio.Estado;
import com.fernando.aulaspring.dominio.Produto;
import com.fernando.aulaspring.repositories.CategoriaRepository;
import com.fernando.aulaspring.repositories.CidadeRepository;
import com.fernando.aulaspring.repositories.EstadoRepository;
import com.fernando.aulaspring.repositories.ProdutoRepository;

@SpringBootApplication
public class AulaSpring1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AulaSpring1Application.class, args);
	}
	
	@Autowired
	private CategoriaRepository categoriaRepoisitory ;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categorias cat1 = new Categorias(null, "Informática");
		Categorias cat2 = new Categorias(null, "Escritório");
		
		
		
		Produto p1 = new Produto(null,"Computador",2000.0);
		Produto p2 = new Produto(null,"Impressora",800.0);
		Produto p3 = new Produto(null,"Mouse",45.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		categoriaRepoisitory.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "São Paulo", est2);
		Cidade c2 = new Cidade(null, "Uberlândia", est1);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c2));
		est2.getCidades().addAll(Arrays.asList(c1,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
	}

}
