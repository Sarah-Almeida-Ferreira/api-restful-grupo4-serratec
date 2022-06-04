package org.serratec.lojasamazonas.dto;

public class ItemPedidoDTO {
	
	private Long codigoProduto;
	private Long codigoPedido;
	private Integer quantidade;
	private String valorTotalItem;
	
	public ItemPedidoDTO() {}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getValorTotalItem() {
		return valorTotalItem;
	}

	public void setValorTotalItem(String valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
	}

	

}
