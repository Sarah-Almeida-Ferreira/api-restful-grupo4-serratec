package org.serratec.lojasamazonas.mapper;

import java.util.Optional;
import org.serratec.lojasamazonas.dto.PedidoResponseDto;
import org.serratec.lojasamazonas.model.ClienteModel;
import org.serratec.lojasamazonas.model.PedidoModel;
import org.serratec.lojasamazonas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	PedidoResponseDto fromModelToDto(PedidoModel model) {
		
		PedidoResponseDto dto = new PedidoResponseDto();
		
		dto.setCodigoPedido(model.getCodigoPedido());
		dto.setCliente(model.getCliente().getCodigoCliente());
		dto.setDataPedido(model.getDataPedido());
		
		return dto;
	}
	
	PedidoModel fromDtoToModel(PedidoResponseDto dto) {
		
		PedidoModel model = new PedidoModel();		
		Optional<ClienteModel> cliente = clienteRepository.findById(dto.getCliente());
		
		model.setCliente(cliente.get());
		model.setDataPedido(dto.getDataPedido());
		
		return model;
	}

}