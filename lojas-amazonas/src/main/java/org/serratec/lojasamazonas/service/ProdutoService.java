package org.serratec.lojasamazonas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.serratec.lojasamazonas.dto.ProdutoDTO;
import org.serratec.lojasamazonas.dto.ProdutoDTORequest;
import org.serratec.lojasamazonas.exception.EmailException;
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
	@Autowired
	EmailService emailService;

	public ProdutoDTO getById(Long codigoProduto) throws ItemNotFoundException {
		return produtoMapper.toDTO(getModelById(codigoProduto));
	}

	public ProdutoModel getModelById(Long codigoProduto) throws ItemNotFoundException {
		Optional<ProdutoModel> produtoModel = produtoRepository.findById(codigoProduto);
		if (produtoModel.isEmpty()) {
			throw new ItemNotFoundException("Nenhum produto com o codigo " + codigoProduto + " encontrado");
		}
		return produtoModel.get();
	}

	public List<ProdutoDTO> getAll() throws ItemNotFoundException {
		return produtoMapper.toDTO(produtoRepository.findAll());
	}

	public String create(ProdutoDTORequest produtoDTO) throws ItemNotFoundException, ItemAlreadyExistsException {
		
		ProdutoModel produtoModel = validation
							.verificarSeProdutoJáFoiCadastrado(produtoDTO.getNomeProduto());
		
		if(produtoModel != null) {
			produtoModel.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
			produtoRepository.save(produtoModel);
			return String.format("Já existe produto cadastrado com esse nome sob o código %d,"
						+ " portanto apenas seu estoque foi atualizado!", produtoModel.getCodigoProduto());
		}
		
		produtoModel = produtoMapper.toModel(produtoDTO);			
		produtoRepository.save(produtoModel);

		return String.format("Produto CÓDIGO %d criado com sucesso! ", produtoModel.getCodigoProduto());
	}
	
	public void atualizarEstoque(List<ItemPedidoModel> itens) throws MessagingException, EmailException {
		
		List<ProdutoModel> listaEstoqueBaixo = new ArrayList<>();
		
		for (ItemPedidoModel item : itens) {
			ProdutoModel produto = item.getProduto();
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque()-item.getQuantidade());
			produtoRepository.save(produto);
			
			if(produto.getQuantidadeEstoque() <= 5) {
				listaEstoqueBaixo.add(produto);
			}
		}
		
		if(!listaEstoqueBaixo.isEmpty()) {
			emailService.emailEstoqueBaixo(listaEstoqueBaixo);
		}
	}
	

	public String update(Long codigoProduto, ProdutoDTORequest produtoDTO) throws ItemNotFoundException {
		ProdutoModel produto = getModelById(codigoProduto);

		if (produtoDTO.getDataFabricacao() != null) {
			produto.setDataFabricacao(produtoDTO.getDataFabricacao());
		}
		if (produtoDTO.getDescricao() != null) {
			produto.setDescricao(produtoDTO.getDescricao());
		}
		if (produtoDTO.getNomeProduto() != null) {
			produto.setNomeProduto(produtoDTO.getNomeProduto());
		}
		if (produtoDTO.getPeriodoValidade() != null) {
			produto.setPeriodoValidade(produtoDTO.getPeriodoValidade());
		}
		if (produtoDTO.getQuantidadeEstoque() != null) {
			produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
		}
		if(produtoDTO.getValorUnitario() != null) {
			produto.setValorUnitario(produtoDTO.getValorUnitario());
		}
			produtoRepository.save(produto);
			return String.format("Produto CODIGO %d Atualizado com sucesso!", codigoProduto);
	}
	public String delete(Long codigoProduto) throws ItemNotFoundException	{
		getModelById(codigoProduto);	
		produtoRepository.deleteById(codigoProduto);
		return String.format("Produto CODIGO %d Deletado com sucesso!", codigoProduto);
	}
}