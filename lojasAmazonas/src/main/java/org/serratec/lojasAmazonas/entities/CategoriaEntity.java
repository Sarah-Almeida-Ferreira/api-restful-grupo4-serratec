package org.serratec.lojasAmazonas.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class CategoriaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	
	public CategoriaEntity(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public CategoriaEntity() {
	
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}		

}
