package org.serratec.lojasamazonas.service;

import java.util.List;
import java.util.Optional;
import org.serratec.lojasamazonas.dto.ItemPedidoDTO;
import org.serratec.lojasamazonas.dto.ItemPedidoDTORequest;
import org.serratec.lojasamazonas.exception.CannotBeChangedException;
import org.serratec.lojasamazonas.exception.InsufficientStockException;
import org.serratec.lojasamazonas.exception.ItemAlreadyExistsException;
import org.serratec.lojasamazonas.dto.RelatorioMaisVendidosDto;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.mapper.ItemPedidoMapper;
import org.serratec.lojasamazonas.model.ItemPedidoModel;
import org.serratec.lojasamazonas.model.PedidoModel;
import org.serratec.lojasamazonas.repository.ItemPedidoRepository;
import org.serratec.lojasamazonas.util.Validation;
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
	
	@Autowired
	ProdutoService produtoService;
	
	public String create(ItemPedidoDTORequest itemPedido) throws ItemNotFoundException, ItemAlreadyExistsException, InsufficientStockException, CannotBeChangedException {
		
		ItemPedidoModel item = mapper.toModel(itemPedido);		
		Validation.VerificarSePodeSerAlterado(item.getPedido());
		Validation.verificarSeHaEstoqueSuficiente(item);
		
		item.setValorTotalItem(item.getProduto().getValorUnitario() * item.getQuantidade());
		
		repository.save(item);
		
		return ("Item de pedido incluído com sucesso!");
	}
	
	public String create(List<ItemPedidoDTORequest> itensPedidoDTO) throws ItemNotFoundException, ItemAlreadyExistsException, InsufficientStockException, CannotBeChangedException {
		
		List<ItemPedidoModel> itensPedidoModels = mapper.toModel(itensPedidoDTO); 
		
		Validation.VerificarSePodeSerAlterado(itensPedidoModels);
		Validation.verificarSeHaEstoqueSuficiente(itensPedidoModels);
		
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
	
	public ItemPedidoModel getModelByCodigoItem(Long codigoItem) throws ItemNotFoundException {
		Optional<ItemPedidoModel> item = repository.findById(codigoItem);
		
		if (item.isEmpty()) {
			throw new ItemNotFoundException("Nenhum item com o CÓDIGO " + codigoItem + " encontrado!");
		}
		
		return item.get();
	}
	
	public ItemPedidoDTO getByCodigoItem(Long codigoItem) throws ItemNotFoundException {
		return mapper.toDTO(getModelByCodigoItem(codigoItem));
	}
	
	public String update(Long codigoItem, ItemPedidoDTORequest itemDTO) throws ItemNotFoundException {
		
		ItemPedidoModel item = getModelByCodigoItem(codigoItem);
		
		if (itemDTO.getCodigoPedido() != null) {

			item.setPedido(pedidoService.getModelByCodigo(itemDTO.getCodigoPedido()));
			
		}
		
		if(itemDTO.getCodigoProduto() != null) {
			
			item.setProduto(produtoService.getModelById(itemDTO.getCodigoProduto()));

		}

		if (itemDTO.getQuantidade() != null) {
		
			item.setQuantidade(itemDTO.getQuantidade());
		
		}
		
		repository.save(item);
		
		return String.format("Item CÓDIGO %d atualizado com sucesso!", codigoItem);
	}
	
	public String delete(Long codigoItem) throws ItemNotFoundException {
		
		ItemPedidoModel item = getModelByCodigoItem(codigoItem);
		
		repository.delete(item);
		
		return String.format("Item CÓDIGO %d excluída com sucesso!", codigoItem);
	}
	
	public List<RelatorioMaisVendidosDto> relatorio() {
		return repository.relatorio();
	}
	
}