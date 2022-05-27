package org.serratec.lojasamazonas.mapper;

import org.serratec.lojasamazonas.dto.FuncionarioDTO;
import org.serratec.lojasamazonas.model.FuncionarioModel;

public class FuncionarioMapper {

	public FuncionarioModel toModel(FuncionarioDTO funcionarioDTO) {
		FuncionarioModel funcionarioModel = new FuncionarioModel();

		funcionarioDTO.setNomeFuncionario(funcionarioModel.getNomeFuncionario());
		funcionarioDTO.setCpf(funcionarioModel.getCpf());

		return funcionarioModel;
	}

	public FuncionarioDTO toDTO(FuncionarioModel funcionarioModel) {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

		funcionarioModel.setNomeFuncionario(funcionarioDTO.getNomeFuncionario());
		funcionarioModel.setCpf(funcionarioDTO.getCpf());

		return funcionarioDTO;
	}
}
