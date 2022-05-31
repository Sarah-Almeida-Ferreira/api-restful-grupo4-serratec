package org.serratec.lojasamazonas.dto;

import java.time.LocalDateTime;

public class PedidoDto {

	private Long codigoPedido;
	private Long cliente;
	private LocalDateTime dataPedido;
	
	public PedidoDto() {}
	
	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

}