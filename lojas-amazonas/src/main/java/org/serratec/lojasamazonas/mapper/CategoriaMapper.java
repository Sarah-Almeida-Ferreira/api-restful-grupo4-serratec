package org.serratec.lojasamazonas.mapper;

import java.util.ArrayList;
import java.util.List;

import org.serratec.lojasamazonas.dto.CategoriaDTO;
import org.serratec.lojasamazonas.dto.CategoriaDTORequest;
import org.serratec.lojasamazonas.model.CategoriaModel;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {
	
	public CategoriaDTO toDTO(CategoriaModel model) {
		
		CategoriaDTO dto = new CategoriaDTO();
		
		dto.setCodigoCategoria(model.getCodigoCategoria());		
		dto.setNomeCategoria(model.getNomeCategoria());
		
		return dto;
		
	}
	
	public CategoriaModel toModel(CategoriaDTORequest dto) {
		
		CategoriaModel model = new CategoriaModel();
		
		model.setNomeCategoria(dto.getNomeCategoria());
		
		return model;
		
	}
	
	public List<CategoriaDTO> toDTO(List<CategoriaModel> models) {
		
		List<CategoriaDTO> dtos = new ArrayList<>();
		
		for(CategoriaModel model : models) {
			dtos.add(toDTO(model));
		}
		
		return dtos;
		
	}
}
