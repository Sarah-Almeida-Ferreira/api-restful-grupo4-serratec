package org.serratec.lojasamazonas.mapper;

import java.util.ArrayList;
import java.util.List;

import org.serratec.lojasamazonas.dto.ClienteDTO;
import org.serratec.lojasamazonas.dto.ClienteDTORequest;
import org.serratec.lojasamazonas.model.ClienteModel;
import org.springframework.stereotype.Component;
@Component
public class ClienteMapper {
	
	
	public ClienteModel toModel (ClienteDTORequest clienteDTO) {
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
		
		clienteDTO.setCodigoCliente(clienteModel.getCodigoCliente());
		clienteDTO.setCpf(clienteModel.getCpf());
		clienteDTO.setDataNascimento(clienteModel.getDataNascimento());
		clienteDTO.setEmail(clienteModel.getEmail());
		clienteDTO.setEndereco(clienteModel.getEndereco());
		clienteDTO.setNomeCompleto(clienteModel.getNomeCompleto());
		clienteDTO.setNomeUsuario(clienteModel.getNomeUsuario());
		clienteDTO.setTelefone(clienteModel.getTelefone());
		
		return clienteDTO;
	}
	
	public List<ClienteDTO> toDTO(List<ClienteModel> models){
		List<ClienteDTO> dtos = new ArrayList<>();
		
		for (ClienteModel model : models) {
			dtos.add(toDTO(model));
		}
		
		return dtos;
	}

}
