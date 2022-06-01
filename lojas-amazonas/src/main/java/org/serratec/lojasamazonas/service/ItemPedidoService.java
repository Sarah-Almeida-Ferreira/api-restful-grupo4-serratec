package org.serratec.lojasamazonas.service;

import java.util.List;

import org.serratec.lojasamazonas.dto.ItemPedidoDTO;
import org.serratec.lojasamazonas.dto.ItemPedidoDTORequest;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.mapper.ItemPedidoMapper;
import org.serratec.lojasamazonas.model.ItemPedidoModel;
import org.serratec.lojasamazonas.model.PedidoModel;
import org.serratec.lojasamazonas.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {
	
	@Autowired
	ItemPedidoRepository repository;
	
	@Autowired
	ItemPedidoMapper mapper;
	
	@Autowired
	PedidoService pedidoService;
	
	public String create(ItemPedidoDTORequest itemPedido) throws ItemNotFoundException {
		
		ItemPedidoModel item = mapper.toModel(itemPedido);
		
		item.setValorTotalItem(item.getProduto().getValorUnitario() * item.getQuantidade());
		
		repository.save(item);
		
		return ("Item de pedido incluído com sucesso!");
	}
	
	public String create(List<ItemPedidoDTORequest> itensPedidoDTO) throws ItemNotFoundException {
		
		List<ItemPedidoModel> itensPedidoModels = mapper.toModel(itensPedidoDTO); 
		
		for (ItemPedidoModel item : itensPedidoModels) {
			item.setValorTotalItem(item.getProduto().getValorUnitario() * item.getQuantidade());
			repository.save(item);
		}
		
		return ("Itens de pedido incluídos com sucesso!");
		
	}
	
	public List<ItemPedidoDTO> getItensByCodigoPedido(Long codigoPedido) throws ItemNotFoundException {
		
		PedidoModel pedido = pedidoService.getModelByCodigo(codigoPedido);
		
		return mapper.toDTO(pedido.getProdutosPedido());
		
	}
}
