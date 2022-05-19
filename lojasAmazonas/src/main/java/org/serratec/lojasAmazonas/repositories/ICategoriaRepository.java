package org.serratec.lojasAmazonas.repositories;

import org.serratec.lojasAmazonas.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
	
}
