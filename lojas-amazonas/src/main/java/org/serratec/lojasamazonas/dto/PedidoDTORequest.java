package org.serratec.lojasamazonas.dto;

import java.time.LocalDateTime;

public class PedidoDTORequest {
	
	private Long cliente;
	private LocalDateTime dataPedido;
//	private List<ItemPedidoDTORequest> itensPedido;
	
	public PedidoDTORequest() {}

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

//	public List<ItemPedidoDTORequest> getItensPedido() {
//		return itensPedido;
//	}
//
//	public void setItensPedido(List<ItemPedidoDTORequest> itensPedido) {
//		this.itensPedido = itensPedido;
//	}

}
