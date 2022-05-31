package org.serratec.lojasamazonas.mapper;

import java.util.ArrayList;
import java.util.List;

import org.serratec.lojasamazonas.dto.ProdutoDTO;
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
		produtoDTO.setCategoria(categoriaService.getByCodigo(produtoModel.getCategoria().getCodigoCategoria()));
		produtoDTO.setCodigoProduto(produtoModel.getCodigoProduto());
		produtoDTO.setDataFabricacao(produtoModel.getDataFabricacao());
		produtoDTO.setDescricao(produtoModel.getDescricao());
		produtoDTO.setFuncionario(funcionarioService.getByCodigo(produtoModel.getFuncionario().getId()));
		produtoDTO.setNomeProduto(produtoModel.getNomeProduto());
		produtoDTO.setPeriodoValidade(produtoModel.getPeriodoValidade());
		produtoDTO.setQuantidadeEstoque(produtoModel.getQuantidadeEstoque());
		produtoDTO.setValorUnitario(produtoModel.getValorUnitario());

		return produtoDTO;
	}
	public ProdutoModel toModel(ProdutoDTO produtoDTO) throws ItemNotFoundException {
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
	
	public List<ProdutoDTO> listToDTO(List<ProdutoModel> listaModel) throws ItemNotFoundException {
		List<ProdutoDTO> listaProdutoDTO = new ArrayList<>();
		ProdutoDTO produtoDTO = new ProdutoDTO();
		
		for(ProdutoModel produtoModel : listaModel) {
			produtoDTO.setCategoria(categoriaService.getByCodigo(produtoModel.getCategoria().getCodigoCategoria()));
			produtoDTO.setCodigoProduto(produtoModel.getCodigoProduto());
			produtoDTO.setDataFabricacao(produtoModel.getDataFabricacao());
			produtoDTO.setDescricao(produtoModel.getDescricao());
			produtoDTO.setFuncionario(funcionarioService.getByCodigo(produtoModel.getFuncionario().getId()));
			produtoDTO.setNomeProduto(produtoModel.getNomeProduto());
			produtoDTO.setPeriodoValidade(produtoModel.getPeriodoValidade());
			produtoDTO.setQuantidadeEstoque(produtoModel.getQuantidadeEstoque());
			produtoDTO.setValorUnitario(produtoModel.getValorUnitario());
			
			listaProdutoDTO.add(produtoDTO);
		}
		
		return listaProdutoDTO;
	}
	
}
