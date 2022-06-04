package org.serratec.lojasamazonas.mapper;

import java.util.ArrayList;
import java.util.List;

import org.serratec.lojasamazonas.dto.FuncionarioDTO;
import org.serratec.lojasamazonas.dto.FuncionarioDTORequest;
import org.serratec.lojasamazonas.model.FuncionarioModel;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

	public FuncionarioModel toModel(FuncionarioDTORequest funcionarioDTORequest) {
		FuncionarioModel funcionarioModel = new FuncionarioModel();

		funcionarioModel.setNomeFuncionario(funcionarioDTORequest.getNomeFuncionario());
		funcionarioModel.setCpf(funcionarioDTORequest.getCpf());

		return funcionarioModel;
	}

	public FuncionarioDTO toDTO(FuncionarioModel funcionarioModel) {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

		funcionarioDTO.setCodigoFuncionario(funcionarioModel.getId());
		funcionarioDTO.setNomeFuncionario(funcionarioModel.getNomeFuncionario());
		funcionarioDTO.setCpf(funcionarioModel.getCpf());

		return funcionarioDTO;
	}
	
	public List<FuncionarioDTO> toDTO(List<FuncionarioModel> models){
		List<FuncionarioDTO> dtos = new ArrayList<>();
		
		for (FuncionarioModel model : models) {
			dtos.add(toDTO(model));
		}
		
		return dtos;
	}
}
