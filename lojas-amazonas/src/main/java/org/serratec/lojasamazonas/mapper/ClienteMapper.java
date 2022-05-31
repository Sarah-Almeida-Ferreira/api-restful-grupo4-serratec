package org.serratec.lojasamazonas.mapper;

import org.serratec.lojasamazonas.dto.ClienteDTO;
import org.serratec.lojasamazonas.model.ClienteModel;

public class ClienteMapper {
	
	
	public ClienteModel toModel (ClienteDTO clienteDTO) {
		ClienteModel clienteModel = new ClienteModel();
		clienteModel.setCpf(clienteDTO.getCpf());
		clienteModel.setDataNascimento(clienteDTO.getDataNascimento());
		clienteModel.setEmail(clienteDTO.getEmail());
		clienteModel.setEndereco(clienteDTO.getEndereco());
		clienteModel.setNomeCompleto(clienteDTO.getNomeCompleto());
		clienteModel.setNomeUsuario(clienteDTO.getNomeUsuario());
		clienteModel.setTelefone(clienteDTO.getTelefone());
		
		
		return clienteModel;
		
	}
	
	public ClienteDTO toDTO(ClienteModel clienteModel) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCodigoCliente(clienteDTO.getCodigoCliente());
		clienteDTO.setCpf(clienteDTO.getCpf());
		clienteDTO.setDataNascimento(clienteDTO.getDataNascimento());
		clienteDTO.setEmail(clienteDTO.getEmail());
		clienteDTO.setEndereco(clienteDTO.getEndereco());
		clienteDTO.setNomeCompleto(clienteDTO.getNomeCompleto());
		clienteDTO.setNomeUsuario(clienteDTO.getNomeUsuario());
		clienteDTO.setTelefone(clienteDTO.getTelefone());
		
		return clienteDTO;
	}

}
