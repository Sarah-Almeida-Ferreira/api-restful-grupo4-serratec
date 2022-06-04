package org.serratec.lojasamazonas.repository;

import java.util.List;

import org.serratec.lojasamazonas.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository <CategoriaModel, Long> {
	
	@Query(value ="select categoria_tx_nome_categoria from categoria c", nativeQuery = true)
	public List<String> getNomes(); 

}
