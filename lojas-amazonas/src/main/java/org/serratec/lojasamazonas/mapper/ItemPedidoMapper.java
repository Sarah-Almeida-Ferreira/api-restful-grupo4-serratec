package org.serratec.lojasamazonas.mapper;

import java.util.ArrayList;
import java.util.List;

import org.serratec.lojasamazonas.dto.ItemPedidoDTO;
import org.serratec.lojasamazonas.dto.ItemPedidoDTORequest;
import org.serratec.lojasamazonas.dto.PedidoDto;
import org.serratec.lojasamazonas.dto.ProdutoDTO;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.model.ItemPedidoModel;
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
	
	@Autowired
	PedidoMapper pedidoMapper;
	
	@Autowired
	ProdutoMapper produtoMapper;
	
	public ItemPedidoModel toModel(ItemPedidoDTORequest dto) throws ItemNotFoundException {
		
		ItemPedidoModel model = new ItemPedidoModel();
		
		PedidoDto pedido = pedidoService.getByCodigo(dto.getCodigoPedido());
		ProdutoDTO produto = produtoService.getById(dto.getCodigoProduto());
		
		model.setPedido(pedidoMapper.toModel(pedido));
		model.setProduto(produtoMapper.toModel(produto));
		model.setQuantidade(dto.getQuantidade());		
		
		return model;
		
	}
	
	public ItemPedidoDTO toDTO(ItemPedidoModel model) {
		
		ItemPedidoDTO dto = new ItemPedidoDTO();
		
		dto.setCodigoPedido(model.getCodigoItemPedido());
		dto.setCodigoProduto(model.getPedido().getCodigoPedido());
		dto.setQuantidade(model.getQuantidade());
		dto.setValorTotalItem(model.getValorTotalItem());
		
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
