package org.serratec.lojasamazonas.mapper;

import java.util.ArrayList;
import java.util.List;

import org.serratec.lojasamazonas.dto.ProdutoDTO;
import org.serratec.lojasamazonas.dto.ProdutoDTORequest;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.model.ProdutoModel;
import org.serratec.lojasamazonas.service.CategoriaService;
import org.serratec.lojasamazonas.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	FuncionarioService funcionarioService;
	
	public ProdutoDTO toDTO(ProdutoModel produtoModel) throws ItemNotFoundException {

		ProdutoDTO produtoDTO = new ProdutoDTO();
		
		produtoDTO.setCodigoProduto(produtoModel.getCodigoProduto());
		produtoDTO.setDataFabricacao(produtoModel.getDataFabricacao());
		produtoDTO.setDescricao(produtoModel.getDescricao());
		produtoDTO.setNomeProduto(produtoModel.getNomeProduto());
		produtoDTO.setPeriodoValidade(produtoModel.getPeriodoValidade());
		produtoDTO.setQuantidadeEstoque(produtoModel.getQuantidadeEstoque());
		produtoDTO.setValorUnitario(produtoModel.getValorUnitario());
		produtoDTO.setCodigoCategoria(produtoModel.getCategoria().getCodigoCategoria());
		produtoDTO.setCodigoFuncionario(produtoModel.getFuncionario().getId());

		return produtoDTO;
	}
	public ProdutoModel toModel(ProdutoDTORequest produtoDTO) throws ItemNotFoundException {
		ProdutoModel produtoModel = new ProdutoModel();
		produtoModel.setFuncionario(funcionarioService.getModelByCodigo(produtoDTO.getCodigoFuncionario()));
		produtoModel.setCategoria(categoriaService.getModelByCodigo(produtoDTO.getCodigoCategoria()));
		produtoModel.setDataFabricacao(produtoDTO.getDataFabricacao());
		produtoModel.setDescricao(produtoDTO.getDescricao());
		produtoModel.setNomeProduto(produtoDTO.getNomeProduto());
		produtoModel.setPeriodoValidade(produtoDTO.getPeriodoValidade());
		produtoModel.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
		produtoModel.setValorUnitario(produtoDTO.getValorUnitario());
		
		return produtoModel;
	}
	
	public List<ProdutoDTO> toDTO(List<ProdutoModel> listaModel) throws ItemNotFoundException {
		List<ProdutoDTO> listaProdutoDTO = new ArrayList<>();
		
		for(ProdutoModel produtoModel : listaModel) {
			listaProdutoDTO.add(toDTO(produtoModel));
		}
		
		return listaProdutoDTO;
	}
	
}
