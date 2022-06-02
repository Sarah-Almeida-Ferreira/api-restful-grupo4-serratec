package org.serratec.lojasamazonas.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Pedido")
public class PedidoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pedido_cd_pedido")
	private Long codigoPedido;	
    
	@NotNull
    @ManyToOne
    @JoinColumn(name="pedido_cd_cliente")
    private ClienteModel cliente;

	@NotNull
	@Column(name="pedido_dt_pedido")
	private LocalDateTime dataPedido;
	
    @OneToMany(mappedBy="pedido")
    @Column(name="pedido_list_produto")
    private List<ItemPedidoModel> itensPedido;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    public PedidoModel() {}
    
	public PedidoModel(ClienteModel cliente, List<ItemPedidoModel> itensPedido, StatusPedido status) {
		this.cliente = cliente;
		this.itensPedido = itensPedido;
		this.status = status;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public List<ItemPedidoModel> getProdutosPedido() {
		return itensPedido;
	}

	public void setProdutosPedido(List<ItemPedidoModel> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public List<ItemPedidoModel> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedidoModel> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}    
}