package org.serratec.lojasamazonas.dto;

public class ItemPedidoRequestDto {
	
	private Long codigoPedido;
	private Long codigoProduto;
	private Integer quantidade;
	
	public ItemPedidoRequestDto() {

	}
	
	public ItemPedidoRequestDto(Long codigoPedido, Long codigoProduto, Integer quantidade) {
		this.codigoPedido = codigoPedido;
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
	}
	
	public Long getCodigoPedido() {
		return codigoPedido;
	}
	
	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	
	public Long getCodigoProduto() {
		return codigoProduto;
	}
	
	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
