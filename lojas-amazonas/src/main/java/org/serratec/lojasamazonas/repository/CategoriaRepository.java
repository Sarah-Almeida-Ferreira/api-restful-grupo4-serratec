package org.serratec.lojasamazonas.repository;

import org.serratec.lojasamazonas.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository <CategoriaModel, Long> {

}
