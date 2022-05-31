package org.serratec.lojasamazonas.mapper;

import org.serratec.lojasamazonas.dto.PedidoDto;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.model.ClienteModel;
import org.serratec.lojasamazonas.model.PedidoModel;
import org.serratec.lojasamazonas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
	
	@Autowired
	ClienteService clienteService;
	
	PedidoDto fromModelToDto(PedidoModel model) {
		
		PedidoDto dto = new PedidoDto();
		
		dto.setCodigoPedido(model.getCodigoPedido());
		dto.setCliente(model.getCliente().getCodigoCliente());
		dto.setDataPedido(model.getDataPedido());
		
		return dto;
	}
	
	PedidoModel fromDtoToModel(PedidoDto dto) throws ItemNotFoundException {
		
		PedidoModel model = new PedidoModel();
		ClienteModel cliente = clienteService.getByIdModel(dto.getCodigoPedido());
		
		model.setCliente(cliente);
		model.setDataPedido(dto.getDataPedido());
		
		return model;
	}

}