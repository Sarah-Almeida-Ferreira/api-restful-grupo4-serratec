package org.serratec.lojasamazonas.repository;

import java.util.List;

import org.serratec.lojasamazonas.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
	@Query(value ="select produto_tx_nome from produto p", nativeQuery = true)
	public List<String> getNomes(); 
	
	public ProdutoModel findByNomeProduto(String nomeProduto);
}
