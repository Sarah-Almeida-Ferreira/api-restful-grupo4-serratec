package org.serratec.lojasamazonas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoCategoria;
	
	@NotNull
	@Column(name="categoria_tx_nome_categoria", unique = true)
	private String nomeCategoria;
	
	@OneToMany(mappedBy="categoria")
	@Column(name="categoria_list_produto")
	private List<ProdutoModel> produtos;

	public CategoriaModel() {}
	
	public CategoriaModel(String nomeCategoria) {
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

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}	

}