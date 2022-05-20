package org.serratec.lojasamazonas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoCategoria;
	
	private String nomeCategoria;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
	private List<ProdutoModel> produtos;

	public CategoriaModel() {
	}
	
	public CategoriaModel(Long codigoCategoria, String nomeCategoria) {
		this.codigoCategoria = codigoCategoria;
		this.nomeCategoria = nomeCategoria;
	}

	public Long getCodigoCategoria() {
		return codigoCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}
	
	public List<ProdutoModel> getProdutos(){
		return produtos;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	

}
