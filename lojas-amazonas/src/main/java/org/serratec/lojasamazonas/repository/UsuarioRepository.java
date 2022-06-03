package org.serratec.lojasamazonas.repository;

import java.util.Optional;

import org.serratec.lojasamazonas.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

	@Query(value="FROM UsuarioModel u WHERE u.username = ?1")
    Optional<UsuarioModel> buscarPorLogin(String login);
	
}
