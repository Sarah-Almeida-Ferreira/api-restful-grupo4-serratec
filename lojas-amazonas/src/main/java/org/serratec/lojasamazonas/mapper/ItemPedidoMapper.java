package org.serratec.lojasamazonas.mapper;

import org.serratec.lojasamazonas.dto.ItemPedidoRequestDto;
import org.serratec.lojasamazonas.model.ItemPedidoModel;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoMapper {
	
	public ItemPedidoModel fromRequestDtoToModel(ItemPedidoRequestDto dto) {
		
		ItemPedidoModel model = new ItemPedidoModel();
		
		model.setPedido(null); //TODO Incluir getPedidoById 
		model.setProduto(null); //TODO Incluir getProdutoById
		model.setQuantidade(dto.getQuantidade());		
		
		return model;
		
	}
	
}
