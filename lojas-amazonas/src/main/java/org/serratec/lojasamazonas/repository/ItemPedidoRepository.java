package org.serratec.lojasamazonas.repository;

import java.util.List;

import org.serratec.lojasamazonas.dto.RelatorioMaisVendidosDto;
import org.serratec.lojasamazonas.model.ItemPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoModel, Long>{
	
	@Query(value="select p.produto_tx_nome as nome_produto, qtd_total_vendida, valor_total_vendido from produto p join\r\n"
			+ "(select sum(item_pedido_tx_quantidade) qtd_total_vendida, item_cd_produto, sum(item_num_valor_item) valor_total_vendido from item_pedido group by item_cd_produto\r\n"
			+ "order by sum(item_pedido_tx_quantidade) desc limit 5) item_pedido on (p.produto_cd_produto = item_pedido.item_cd_produto)", nativeQuery=true)
	List<RelatorioMaisVendidosDto> relatorio();

}