package org.serratec.lojasamazonas.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Produto")
public class ProdutoModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "produto_cd_produto")
	private Long codigoProduto;

	@NotNull
	@Column(name = "produto_tx_nome", unique = true)
	private String nomeProduto;

	@Column(name = "produto_tx_descricao")
	private String descricao;

	@NotNull
	@Column(name = "produto_num_valor_unitario")
	private Double valorUnitario;

	@NotNull
	@Column(name = "produto_dt_fabricacao")
	private Date dataFabricacao;

	@NotNull
	@Column(name = "produto_dt_periodo_validade")
	private Date periodoValidade;

	@NotNull
	@Column(name = "produto_tx_qtd_estoque")
	private Integer quantidadeEstoque;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "produto_cd_categoria")
	private CategoriaModel categoria;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "produto_cd_funcionario")
	private FuncionarioModel funcionario;

	@JsonIgnore
    @OneToMany(mappedBy = "produto")
    @Column(name = "produto_list_pedido")
    private List<ItemPedidoModel> itensPedido;

	public ProdutoModel() {}

	public ProdutoModel(String nomeProduto, String descricao, Double valorUnitario,
			Date dataFabricacao, Date periodoValidade, Integer quantidadeEstoque, CategoriaModel categoria, FuncionarioModel funcionario) {	
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.dataFabricacao = dataFabricacao;
		this.periodoValidade = periodoValidade;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoria = categoria;
		this.funcionario = funcionario;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
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

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public FuncionarioModel getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioModel funcionario) {
		this.funcionario = funcionario;
	}

}
