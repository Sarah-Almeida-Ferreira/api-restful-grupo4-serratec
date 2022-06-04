package org.serratec.lojasamazonas.repository;

import org.serratec.lojasamazonas.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {

}
