package org.serratec.lojasamazonas.repository;

import java.util.List;

import org.serratec.lojasamazonas.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long>{
	
	@Query(value ="select cpf from funcionario f", nativeQuery = true)
	public List<String> getCpfs();

}
