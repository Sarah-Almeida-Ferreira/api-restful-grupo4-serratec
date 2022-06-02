package org.serratec.lojasamazonas.repository;

import java.util.List;

import org.serratec.lojasamazonas.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
	
	@Query(value ="select cliente_tx_cpf from cliente c", nativeQuery = true)
	public List<String> getCpfs(); 
	
	@Query(value ="select cliente_tx_email from cliente c", nativeQuery = true)
	public List<String> getEmails(); 
	
	@Query(value ="select cliente_tx_nome_usuario from cliente c", nativeQuery = true)
	public List<String> getUsuarios(); 

}
