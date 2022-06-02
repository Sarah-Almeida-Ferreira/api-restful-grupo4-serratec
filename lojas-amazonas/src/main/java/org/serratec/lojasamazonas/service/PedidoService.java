package org.serratec.lojasamazonas.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.serratec.lojasamazonas.dto.PedidoDTORequest;
import org.serratec.lojasamazonas.dto.PedidoDto;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.mapper.PedidoMapper;
import org.serratec.lojasamazonas.model.PedidoModel;
import org.serratec.lojasamazonas.model.StatusPedido;
import org.serratec.lojasamazonas.repository.PedidoRepository;
import org.serratec.lojasamazonas.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ClienteService clienteService;

	@Autowired
	PedidoMapper pedidoMapper;

	public String create(PedidoDTORequest pedidoDto) throws ItemNotFoundException {
		PedidoModel pedidoModel = pedidoMapper.toModel(pedidoDto);

		pedidoModel.setStatus(StatusPedido.PENDENTE);
		pedidoModel.setDataPedido(LocalDateTime.now());
		pedidoRepository.save(pedidoModel);

		return String.format("Pedido código %d criado com sucesso!", pedidoModel.getCodigoPedido());
	}

	public PedidoDto getByCodigo(Long codigoPedido) throws ItemNotFoundException {

		return pedidoMapper.toDto(getModelByCodigo(codigoPedido));
	}

	public PedidoModel getModelByCodigo(Long codigoPedido) throws ItemNotFoundException {
		Optional<PedidoModel> pedidoModel = pedidoRepository.findById(codigoPedido);

		if (pedidoModel.isEmpty()) {
			throw new ItemNotFoundException("Não foi possível encontrar nenhum pedido com o código informado!");
		}

		return pedidoModel.get();

	}

	public List<PedidoDto> getAll() {
		List<PedidoDto> listaDto = pedidoMapper.toDto(pedidoRepository.findAll());

		return listaDto;
	}

	public String update(Long codigoPedido, PedidoDto dto) throws ItemNotFoundException {
		PedidoModel model = getModelByCodigo(codigoPedido);

		if (dto.getCliente() != null) {
			model.setCliente(clienteService.getByIdModel(dto.getCliente()));
		}
		if (dto.getDataPedido() != null) {
			model.setDataPedido(dto.getDataPedido());
		}

		pedidoRepository.save(model);
		return String.format("Pedido código %d atualizado com sucesso!", codigoPedido);
	}

	public String finalizar(Long codigoPedido) throws ItemNotFoundException {
		PedidoModel pedido = getModelByCodigo(codigoPedido);

		if (Validation.naoPodeSerFinalizada(pedido)) {

		}

		pedido.setStatus(StatusPedido.FINALIZADO);
		pedido.setDataPedido(LocalDateTime.now());
		pedidoRepository.save(pedido);
		return String.format("Pedido código %d finalizado com sucesso!", codigoPedido);
	}

	public String delete(Long codigoPedido) throws ItemNotFoundException {
		PedidoModel model = getModelByCodigo(codigoPedido);

		return String.format("Pedido código %d deletado com sucesso!", model.getCodigoPedido());
	}

}