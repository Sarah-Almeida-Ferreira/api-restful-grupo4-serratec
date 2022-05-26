package org.serratec.lojasamazonas.repository;

import org.serratec.lojasamazonas.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
		
	

}
