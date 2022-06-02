package org.serratec.lojasamazonas.service;

import java.util.List;
import java.util.Optional;

import org.serratec.lojasamazonas.dto.FuncionarioDTO;
import org.serratec.lojasamazonas.dto.FuncionarioDTORequest;
import org.serratec.lojasamazonas.exception.ItemAlreadyExistsException;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.mapper.FuncionarioMapper;
import org.serratec.lojasamazonas.model.FuncionarioModel;
import org.serratec.lojasamazonas.repository.FuncionarioRepository;
import org.serratec.lojasamazonas.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Autowired
	FuncionarioMapper funcionarioMapper;
	
	@Autowired
	Validation validation;
	
	public FuncionarioModel getModelByCodigo(Long codigoFuncionario) throws ItemNotFoundException {
		Optional<FuncionarioModel> funcionario = funcionarioRepository.findById(codigoFuncionario);

		if (funcionario.isEmpty()) {
			throw new ItemNotFoundException("Nenhum funcionário com o CÓDIGO " + codigoFuncionario + " encontrado!");
		}

		return funcionario.get();
	}

	public String create(FuncionarioDTORequest funcionarioDTO) throws ItemAlreadyExistsException {
		validation.verificarSeCpfJáFoiCadastrado(funcionarioDTO.getCpf());
		
		FuncionarioModel funcionario = funcionarioMapper.toModel(funcionarioDTO);

		funcionarioRepository.save(funcionario);
		return String.format("Funcionário CÓDIGO %d cadastrado com sucesso!", funcionario.getId());
	}

	public List<FuncionarioDTO> getAll() {
		List<FuncionarioDTO> funcionarioDTOs = funcionarioMapper.toDTO(funcionarioRepository.findAll());
		return funcionarioDTOs;
	}

	public FuncionarioDTO getByCodigo(Long codigoFuncionario) throws ItemNotFoundException {
		FuncionarioModel funcionario = getModelByCodigo(codigoFuncionario);

		return funcionarioMapper.toDTO(funcionario);
	}

	public String update(Long codigoFuncionario, FuncionarioDTORequest funcionarioDTO) throws ItemNotFoundException {
		FuncionarioModel funcionario = getModelByCodigo(codigoFuncionario);

		if (funcionarioDTO.getNomeFuncionario() != null) {
			funcionario.setNomeFuncionario(funcionarioDTO.getNomeFuncionario());
		}
		if (funcionarioDTO.getCpf() != null) {
			funcionario.setCpf(funcionarioDTO.getCpf());

		}
		
		funcionarioRepository.save(funcionario);
		
		return String.format("Funcionário CÓDIGO %d atualizado com sucesso!", funcionario.getId());
	}

	public String delete(Long codigoFuncionario) throws ItemNotFoundException {
		FuncionarioModel funcionario = getModelByCodigo(codigoFuncionario);

		funcionarioRepository.deleteById(codigoFuncionario);
		return String.format("Funcionário CÓDIGO %d deletado com sucesso!", funcionario.getId());
	}

}
