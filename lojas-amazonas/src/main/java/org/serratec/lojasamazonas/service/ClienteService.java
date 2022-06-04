package org.serratec.lojasamazonas.service;

import java.util.List;
import java.util.Optional;

import org.serratec.lojasamazonas.dto.ClienteDTO;
import org.serratec.lojasamazonas.dto.ClienteDTORequest;
import org.serratec.lojasamazonas.exception.ItemAlreadyExistsException;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.mapper.ClienteMapper;
import org.serratec.lojasamazonas.model.ClienteModel;
import org.serratec.lojasamazonas.repository.ClienteRepository;
import org.serratec.lojasamazonas.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ClienteMapper clienteMapper;
	@Autowired
	Validation validation;
	
	public List<ClienteDTO> getAll(){
		List<ClienteDTO> clienteDTOs = clienteMapper.toDTO(clienteRepository.findAll());  
		return clienteDTOs;		
	}	
	
	
	public ClienteDTO getById(long codigoCliente) throws ItemNotFoundException {
		ClienteModel cliente = getByIdModel(codigoCliente);
		
		return clienteMapper.toDTO(cliente);		
	}
	
	public ClienteModel getByIdModel(long codigoCliente) throws ItemNotFoundException {
		Optional<ClienteModel> cliente = clienteRepository.findById(codigoCliente);
		if (cliente.isEmpty()) {
			throw new ItemNotFoundException("Nenhum cliente com código "+ codigoCliente +" encontrado.");
		}
		return cliente.get();
	}

	public String create(ClienteDTORequest clienteDTO) throws ItemAlreadyExistsException {
		validation.verificarSeCpfJáFoiCadastrado(clienteDTO.getCpf());
		validation.verificarSeEmailJáFoiCadastrado(clienteDTO.getEmail());
		validation.verificarSeUsuarioJáFoiCadastrado(clienteDTO.getNomeUsuario());
		
		ClienteModel cliente = clienteMapper.toModel(clienteDTO);

		clienteRepository.save(cliente);
		return String.format("Cliente CÓDIGO %d cadastrado com sucesso!", cliente.getCodigoCliente());
	}


	public ClienteDTO getByCodigo(Long codigoCliente) throws ItemNotFoundException {
		ClienteModel cliente = getByIdModel(codigoCliente);

		return clienteMapper.toDTO(cliente);
	}

	public String update(Long codigoCliente, ClienteDTORequest clienteDTO) throws ItemNotFoundException {
		ClienteModel cliente = getByIdModel(codigoCliente);

		if (clienteDTO.getNomeCompleto() != null) {
			cliente.setNomeCompleto(clienteDTO.getNomeCompleto());
		}
		if (clienteDTO.getCpf() != null) {
			cliente.setCpf(clienteDTO.getCpf());

		}
		if (clienteDTO.getDataNascimento() != null) { 
			cliente.setDataNascimento(clienteDTO.getDataNascimento());
		}
		if (clienteDTO.getEmail() != null) {
			cliente.setEmail(clienteDTO.getEmail());
		}
		if (clienteDTO.getEndereco()!= null) {
			cliente.setEndereco(clienteDTO.getEndereco());
		}
		if (clienteDTO.getNomeUsuario() != null) {
			cliente.setNomeUsuario(clienteDTO.getNomeUsuario());
		}
		if (clienteDTO.getTelefone()!= null) {
			cliente.setTelefone(clienteDTO.getTelefone());
		}
		clienteRepository.save(cliente);
		
		return String.format("Cliente CÓDIGO %d atualizado com sucesso!", cliente.getCodigoCliente());
	}

	public String delete(Long codigoCliente) throws ItemNotFoundException {
		clienteRepository.deleteById(codigoCliente);
		return String.format("Cliente CÓDIGO %d deletado com sucesso!", codigoCliente);
	}

}
