package org.serratec.lojasamazonas.service;

import java.util.List;
import java.util.Optional;

import org.serratec.lojasamazonas.dto.ProdutoDTO;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.mapper.ProdutoMapper;
import org.serratec.lojasamazonas.model.ProdutoModel;
import org.serratec.lojasamazonas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	@Autowired
	ProdutoMapper produtoMapper;
	@Autowired
	ProdutoRepository produtoRepository;

	
	public ProdutoDTO getById(Long codigoProduto) throws ItemNotFoundException {
		Optional<ProdutoModel> produtoModel = produtoRepository.findById(codigoProduto);
		if(produtoModel.isEmpty()) {
			throw new ItemNotFoundException("Nenhum produto com o codigo "+codigoProduto+" encontrado");
		}
		return produtoMapper.toDTO(produtoModel.get());
		
	}
	
	public List<ProdutoDTO> getAll() throws ItemNotFoundException {
		return produtoMapper.listToDTO(produtoRepository.findAll());
	}

	public String create(ProdutoDTO produtoDTO) throws ItemNotFoundException {
		ProdutoModel produtoModel = produtoMapper.toModel(produtoDTO);
		produtoRepository.save(produtoModel);

		return String.format("Produto CÓDIGO %d criado com sucesso! ", produtoModel.getCodigoProduto());
	}
	
	
	
}
