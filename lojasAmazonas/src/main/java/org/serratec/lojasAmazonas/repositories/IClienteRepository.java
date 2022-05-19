package org.serratec.lojasAmazonas.repositories;

import org.serratec.lojasAmazonas.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
