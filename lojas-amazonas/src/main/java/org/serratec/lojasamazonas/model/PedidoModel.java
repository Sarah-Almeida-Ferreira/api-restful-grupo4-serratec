package org.serratec.lojasamazonas.model;

import java.time.LocalDateTime;
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

@Entity
@Table(name = "Pedido")
public class PedidoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_cod_pedido")
	private Long codigoPedido;	
    
	@NotNull
    @ManyToOne
    @JoinColumn(name = "pedido_cd_cliente")
    private ClienteModel cliente;

	@NotNull
	@Column(name= "pedido_dt_pedido")
	private LocalDateTime dataPedido;
	
	@NotNull
    @OneToMany
    @JoinColumn(name = "pedido_list_produto")
    private List<ProdutoModel> produtosPedido;
    
    public PedidoModel() {}
    
	public PedidoModel(ClienteModel cliente, List<ProdutoModel> produtosPedido) {
		this.cliente = cliente;
		this.produtosPedido = produtosPedido;
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

	public List<ProdutoModel> getProdutosPedido() {
		return produtosPedido;
	}

	public void setProdutosPedido(List<ProdutoModel> produtosPedido) {
		this.produtosPedido = produtosPedido;
	}
    
}