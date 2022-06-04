
package org.serratec.lojasamazonas.mapper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.serratec.lojasamazonas.dto.ItemPedidoDTO;
import org.serratec.lojasamazonas.dto.ItemPedidoDTORequest;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.model.ItemPedidoModel;
import org.serratec.lojasamazonas.model.PedidoModel;
import org.serratec.lojasamazonas.model.ProdutoModel;
import org.serratec.lojasamazonas.service.PedidoService;
import org.serratec.lojasamazonas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoMapper {
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	ProdutoService produtoService;
	
	public ItemPedidoModel toModel(ItemPedidoDTORequest dto) throws ItemNotFoundException {
		
		ItemPedidoModel model = new ItemPedidoModel();
		
		PedidoModel pedido = pedidoService.getModelByCodigo(dto.getCodigoPedido());
		ProdutoModel produto = produtoService.getModelById(dto.getCodigoProduto());
		
		model.setPedido(pedido);
		model.setProduto(produto);
		model.setQuantidade(dto.getQuantidade());		
		
		return model;
		
	}
	
	public ItemPedidoDTO toDTO(ItemPedidoModel model) {
		
		ItemPedidoDTO dto = new ItemPedidoDTO();
		
		DecimalFormat formato = new DecimalFormat("#.00"); 
		String valor = formato.format(model.getValorTotalItem());
		
		dto.setCodigoPedido(model.getPedido().getCodigoPedido());
		dto.setCodigoProduto(model.getProduto().getCodigoProduto());
		dto.setQuantidade(model.getQuantidade());
		dto.setValorTotalItem(valor);
		
		return dto;
	}
	
	public List<ItemPedidoDTO> toDTO(List<ItemPedidoModel> models) {
		
		List<ItemPedidoDTO> dtos = new ArrayList<>();
		
		for (ItemPedidoModel model : models) {
			
			dtos.add(toDTO(model));
			
		}
		
		return dtos;
	}
	
	public List<ItemPedidoModel> toModel(List<ItemPedidoDTORequest> dtos) throws ItemNotFoundException {
		
		List<ItemPedidoModel> models = new ArrayList<>();
		
		for (ItemPedidoDTORequest dto : dtos) {
			models.add(toModel(dto));
		}
		
		return models;
	}
	
}
