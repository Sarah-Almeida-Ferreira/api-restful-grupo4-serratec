package org.serratec.lojasamazonas.service;

import java.util.List;
import java.util.Optional;

import org.serratec.lojasamazonas.dto.ClienteDTO;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.mapper.ClienteMapper;
import org.serratec.lojasamazonas.model.ClienteModel;
import org.serratec.lojasamazonas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ClienteMapper clienteMapper;
	
	public List<ClienteDTO> getAll(){
		List<ClienteDTO> clienteDTOs = clienteMapper.toDTO(clienteRepository.findAll());  
		return clienteDTOs;		
	}	
	
	public String create(ClienteDTO clienteDTO) {
		ClienteModel cliente = clienteMapper.toModel(clienteDTO); 
		clienteRepository.save(cliente);
		return String.format("Cliente com código %d criado.",cliente.getCodigoCliente());
	}
	
	public ClienteDTO getById(long codigoCliente) throws ItemNotFoundException {
		Optional<ClienteModel> cliente = clienteRepository.findById(codigoCliente);
		if (cliente.isEmpty()) {
			throw new ItemNotFoundException("Nenhum cliente com código "+ codigoCliente +" encontrado.");
		}
		return clienteMapper.toDTO(cliente.get());		
	}
	
	public ClienteModel getByIdModel(long codigoCliente) throws ItemNotFoundException {
		Optional<ClienteModel> cliente = clienteRepository.findById(codigoCliente);
		if (cliente.isEmpty()) {
			throw new ItemNotFoundException("Nenhum cliente com código "+ codigoCliente +" encontrado.");
		}
		return cliente.get();
	}

}