package org.serratec.lojasamazonas.service;

import java.util.List;
import java.util.Optional;

import org.serratec.lojasamazonas.dto.ProdutoDTO;
import org.serratec.lojasamazonas.dto.ProdutoDTORequest;
import org.serratec.lojasamazonas.exception.ItemAlreadyExistsException;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.mapper.ProdutoMapper;
import org.serratec.lojasamazonas.model.ItemPedidoModel;
import org.serratec.lojasamazonas.model.ProdutoModel;
import org.serratec.lojasamazonas.repository.ProdutoRepository;
import org.serratec.lojasamazonas.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	@Autowired
	ProdutoMapper produtoMapper;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	Validation validation;

	
	public ProdutoDTO getById(Long codigoProduto) throws ItemNotFoundException {
		return produtoMapper.toDTO(getModelById(codigoProduto));	
	}
	
	public ProdutoModel getModelById(Long codigoProduto) throws ItemNotFoundException {
		Optional<ProdutoModel> produtoModel = produtoRepository.findById(codigoProduto);
		if(produtoModel.isEmpty()) {
			throw new ItemNotFoundException("Nenhum produto com o codigo "+codigoProduto+" encontrado");
		}
		return produtoModel.get();	
	}
	
	public List<ProdutoDTO> getAll() throws ItemNotFoundException {
		return produtoMapper.toDTO(produtoRepository.findAll());
	}

	public String create(ProdutoDTORequest produtoDTO) throws ItemNotFoundException, ItemAlreadyExistsException {
		validation.verificarSeProdutoJáFoiCadastrado(produtoDTO.getNomeProduto());
		ProdutoModel produtoModel = produtoMapper.toModel(produtoDTO);
		produtoRepository.save(produtoModel);

		return String.format("Produto CÓDIGO %d criado com sucesso! ", produtoModel.getCodigoProduto());
	}
	
	public void atualizarEstoque(List<ItemPedidoModel> itens) {
		for (ItemPedidoModel item : itens) {
			ProdutoModel produto = item.getProduto();
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque()-item.getQuantidade());
			produtoRepository.save(produto);
		}
	}	
	
}
