package org.serratec.lojasamazonas.mapper;

import java.util.ArrayList;
import java.util.List;

import org.serratec.lojasamazonas.dto.CategoriaResponseDto;
import org.serratec.lojasamazonas.model.CategoriaModel;
import org.serratec.lojasamazonas.model.ProdutoModel;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {
	
	public CategoriaResponseDto fromModelToDto(CategoriaModel model) {
		
		CategoriaResponseDto dto = new CategoriaResponseDto();
		List<ProdutoModel> listaPodutos = model.getProdutos();
		List<Long> codigosProdutos = new ArrayList<Long>();
		
		for (ProdutoModel produto : listaPodutos) {
			
			Long codigoProduto = produto.getCodigoProduto();
			
			codigosProdutos.add(codigoProduto);
		}
		
		dto.setCodigoCategoria(model.getCodigoCategoria());		
		dto.setNomeCategoria(model.getNomeCategoria());
		dto.setCodigosProdutos(codigosProdutos);
		
		return dto;
		
	}
	
}
