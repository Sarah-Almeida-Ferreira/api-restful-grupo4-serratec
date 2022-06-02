package org.serratec.lojasamazonas.dto;

import java.time.LocalDateTime;

import org.serratec.lojasamazonas.model.StatusPedido;

public class PedidoDtoUpdate {
	
	private Long cliente;
	private LocalDateTime dataPedido;
	private StatusPedido status;
	
	public PedidoDtoUpdate() {}

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

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}	
	
}
