package com.fernando.aulaspring.dto;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fernando.aulaspring.dominio.Categorias;

public class CategoriaDto 

	implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Integer id;
		String nome;
		
		
		public CategoriaDto() {
		}

		public CategoriaDto(Categorias obj) {
			this.id=obj.getId();
			this.nome=obj.getNome();
		}

		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
}
