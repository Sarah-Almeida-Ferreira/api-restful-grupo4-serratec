package org.serratec.lojasamazonas.dto;

public class PedidoEmailDTO {

	private String nomeCliente;

	private Long codigoPedido;

	private String produtoComprado;

	private String quantidadeComprada;

	private Double valorComprado;

	public PedidoEmailDTO() {
	}

	public PedidoEmailDTO(String nomeCliente, Long codigoPedido, String produtoComprado, String quantidadeComprada,
			Double valorComprado) {
		super();
		this.nomeCliente = nomeCliente;
		this.codigoPedido = codigoPedido;
		this.produtoComprado = produtoComprado;
		this.quantidadeComprada = quantidadeComprada;
		this.valorComprado = valorComprado;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getProdutoComprado() {
		return produtoComprado;
	}

	public void setProdutoComprado(String produtoComprado) {
		this.produtoComprado = produtoComprado;
	}

	public String getQuantidadeComprada() {
		return quantidadeComprada;
	}

	public void setQuantidadeComprada(String quantidadeComprada) {
		this.quantidadeComprada = quantidadeComprada;
	}

	public Double getValorComprado() {
		return valorComprado;
	}

	public void setValorComprado(Double valorComprado) {
		this.valorComprado = valorComprado;
	}

}
