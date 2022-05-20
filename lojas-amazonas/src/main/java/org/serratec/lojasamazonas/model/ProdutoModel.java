package org.serratec.lojasamazonas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Produto")
public class ProdutoModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigoProduto;
	
	private String nomeProduto;
	
	private String descricao;
	
	private Double valorUnitario;
	
	private Date dataFabricacao;
	
	private Date periodoValidade;
	
	private Integer quantidadeEstoque;
	
	@ManyToOne
	@JoinColumn(name="codigo_categoria")
	private CategoriaModel categoria;

	public ProdutoModel() {
	}

	public ProdutoModel(Long codigoProduto, String nomeProduto, String descricao, Double valorUnitario,
			Date dataFabricacao, Date periodoValidade, Integer quantidadeEstoque) {
		super();
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.dataFabricacao = dataFabricacao;
		this.periodoValidade = periodoValidade;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Date getPeriodoValidade() {
		return periodoValidade;
	}

	public void setPeriodoValidade(Date periodoValidade) {
		this.periodoValidade = periodoValidade;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

}
