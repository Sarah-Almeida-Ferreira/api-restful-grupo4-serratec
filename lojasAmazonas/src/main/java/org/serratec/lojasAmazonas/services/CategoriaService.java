package org.serratec.lojasAmazonas.services;

import java.util.Optional;

import org.serratec.lojasAmazonas.entities.CategoriaEntity;
import org.serratec.lojasAmazonas.repositories.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	
	@Autowired
	ICategoriaRepository categoriaRepository;
	
	public CategoriaEntity getById(Long id) {
		Optional<CategoriaEntity> categoria = categoriaRepository.findById(id);

		if (categoria.isEmpty()) {
			return null;
		}

		return categoria.get();
	}
	
	public CategoriaEntity create(CategoriaEntity entity) {

		return categoriaRepository.save(entity);
	}
}
