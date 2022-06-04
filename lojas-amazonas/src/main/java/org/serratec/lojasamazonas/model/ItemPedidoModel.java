package org.serratec.lojasamazonas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Item_Pedido") 
public class ItemPedidoModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_cd_item_pedido")
	private Long codigoItemPedido;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="item_cd_produto", referencedColumnName="produto_cd_produto")
	private ProdutoModel produto;
	
	@NotNull
	@ManyToOne
	@JoinColumn (name="item_cd_pedido", referencedColumnName="pedido_cd_pedido")
	private PedidoModel pedido;
	
	@NotNull
	@Column(name="item_pedido_tx_quantidade")
	private Integer quantidade;
	
	@NotNull
	@Column(name="item_num_valor_item")	
	private Double valorTotalItem;

	public ProdutoModel getProduto() {
		return produto;
	}

	public Long getCodigoItemPedido() {
		return codigoItemPedido;
	}

	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}

	public PedidoModel getPedido() {
		return pedido;
	}

	public void setPedido(PedidoModel pedido) {
		this.pedido = pedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotalItem() {
		return valorTotalItem;
	}

	public void setValorTotalItem(Double valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
	}

}
