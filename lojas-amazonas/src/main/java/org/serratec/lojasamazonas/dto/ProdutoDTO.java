package org.serratec.lojasamazonas.dto;

import java.util.Date;

public class ProdutoDTO {

	private Long codigoProduto;

	private String nomeProduto;

	private String descricao;

	private Double valorUnitario;

	private Date dataFabricacao;

	private Date periodoValidade;

	private Integer quantidadeEstoque;

	private Long codigoCategoria;

	private Long codigoFuncionario;

	private CategoriaDTO categoria;

	private FuncionarioDTO funcionario;

	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Long codigoProduto, String nomeProduto, String descricao, Double valorUnitario,
			Date dataFabricacao, Date periodoValidade, Integer quantidadeEstoque, Long codigoCategoria,
			Long codigoFuncionario, CategoriaDTO categoria, FuncionarioDTO funcionario) {
		super();
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.dataFabricacao = dataFabricacao;
		this.periodoValidade = periodoValidade;
		this.quantidadeEstoque = quantidadeEstoque;
		this.codigoCategoria = codigoCategoria;
		this.codigoFuncionario = codigoFuncionario;
		this.categoria = categoria;
		this.funcionario = funcionario;
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

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	public Long getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public Long getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(Long codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

}
