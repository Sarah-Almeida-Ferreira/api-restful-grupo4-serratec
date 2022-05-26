package org.serratec.lojasamazonas.repository;

import org.serratec.lojasamazonas.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
