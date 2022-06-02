package org.serratec.lojasamazonas.service;

import java.util.List;
import java.util.Optional;

import org.serratec.lojasamazonas.dto.CategoriaDTO;
import org.serratec.lojasamazonas.dto.CategoriaDTORequest;
import org.serratec.lojasamazonas.exception.ItemAlreadyExistsException;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.exception.MayNotBeNullException;
import org.serratec.lojasamazonas.mapper.CategoriaMapper;
import org.serratec.lojasamazonas.model.CategoriaModel;
import org.serratec.lojasamazonas.repository.CategoriaRepository;
import org.serratec.lojasamazonas.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repository;
	
	@Autowired
	CategoriaMapper mapper;

	@Autowired
	Validation validation;
	
	public String crate(CategoriaDTORequest categoriaDto) throws ItemAlreadyExistsException {
		
		validation.verificarSeCategoriaJáFoiCadastrada(categoriaDto.getNomeCategoria());
		
		CategoriaModel categoria = mapper.toModel(categoriaDto);
		
		repository.save(categoria);
		
		return String.format("Categoria CÓDIGO %d cadastrado com sucesso!", categoria.getCodigoCategoria());
	}
	
	public List<CategoriaDTO> getAll() {
		
		return mapper.toDTO(repository.findAll());
	}
	
	public CategoriaDTO getByCodigo(Long codigoCategoria) throws ItemNotFoundException {
		
		Optional<CategoriaModel> categoria = repository.findById(codigoCategoria);
		
		if (categoria.isEmpty()) {
			throw new ItemNotFoundException("Nenhuma categoria com CÓDIGO " + codigoCategoria + " encontrada!");
		}
		
		return mapper.toDTO(categoria.get());
	}

	public CategoriaModel getModelByCodigo(Long codigoCategoria) throws ItemNotFoundException {
		Optional<CategoriaModel> categoria = repository.findById(codigoCategoria);
		
		if (categoria.isEmpty()) {
			throw new ItemNotFoundException("Nenhuma categoria com CÓDIGO " + codigoCategoria + " encontrada!");
		}
		
		return categoria.get();
	}
	
	public String update(Long codigoCategoria, CategoriaDTORequest categoriaDTO) throws MayNotBeNullException, ItemNotFoundException {
		
		CategoriaModel categoria = getModelByCodigo(codigoCategoria);
		
		if (categoriaDTO.getNomeCategoria().equals("")) {
			throw new MayNotBeNullException("O nome da categoria não pode ser nulo!");
		}
		
		categoria.setNomeCategoria(categoriaDTO.getNomeCategoria());
		
		repository.save(categoria);
		
		return String.format("Categoria CÓDIGO %d atualizada com sucesso!", codigoCategoria);
	}
	
	public String delete(Long codigoCategoria) throws ItemNotFoundException {
		
		CategoriaModel categoria = getModelByCodigo(codigoCategoria);
		
		repository.delete(categoria);
		
		return String.format("Categoria CÓDIGO %d excluída com sucesso!", codigoCategoria);
	}
	

}
