package org.serratec.lojasamazonas.mapper;

import java.util.ArrayList;
import java.util.List;

import org.serratec.lojasamazonas.dto.PedidoDTORequest;
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
	
	public PedidoDto toDto(PedidoModel model) {
		
		PedidoDto dto = new PedidoDto();
		
		dto.setCodigoPedido(model.getCodigoPedido());
		dto.setCliente(model.getCliente().getCodigoCliente());
		dto.setDataPedido(model.getDataPedido());
		dto.setStatus(model.getStatus());
		
		return dto;
	}
	
	public List<PedidoDto> toDto(List<PedidoModel> listModel) {
		List<PedidoDto> listDto = new ArrayList<>();
		
		
		for(PedidoModel model : listModel) {
					
			listDto.add(toDto(model));
		}
		
		return listDto;
	}
	
	public PedidoModel toModel(PedidoDTORequest dto) throws ItemNotFoundException {
		
		PedidoModel model = new PedidoModel();
		ClienteModel cliente = clienteService.getByIdModel(dto.getCliente());
		
		model.setCliente(cliente);
		model.setDataPedido(dto.getDataPedido());
		
		return model;
	}

}