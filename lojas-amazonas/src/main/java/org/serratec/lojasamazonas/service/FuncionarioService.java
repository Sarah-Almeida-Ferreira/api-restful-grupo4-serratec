package org.serratec.lojasamazonas.service;

import java.util.List;
import java.util.Optional;

import org.serratec.lojasamazonas.dto.FuncionarioDTO;
import org.serratec.lojasamazonas.dto.FuncionarioDTORequest;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.mapper.FuncionarioMapper;
import org.serratec.lojasamazonas.model.FuncionarioModel;
import org.serratec.lojasamazonas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	FuncionarioMapper funcionarioMapper;
	
	public String create(FuncionarioDTORequest funcionarioDTO) {
		FuncionarioModel funcionario =	funcionarioMapper.toModel(funcionarioDTO);
				
		funcionarioRepository.save(funcionario);
		return String.format("Funcionário CÓDIGO %d cadastrado com sucesso!", funcionario.getId());
	}
	
	public List<FuncionarioDTO> getAll(){
		List<FuncionarioDTO> funcionarioDTOs = funcionarioMapper.toDTO(funcionarioRepository.findAll());  
		return funcionarioDTOs;
	}
	
	public FuncionarioDTO getByCodigo(Long codigoFuncionario) throws ItemNotFoundException {
		Optional<FuncionarioModel> funcionario = funcionarioRepository.findById(codigoFuncionario);
		
		if(funcionario.isEmpty()) {
			throw new ItemNotFoundException("Nenhum funcionário com o CÓDIGO " + codigoFuncionario + " encontrado!");
		}
		
		return funcionarioMapper.toDTO(funcionario.get());
	}

	public FuncionarioModel getModelByCodigo(Long codigoFuncionario) throws ItemNotFoundException {
			Optional<FuncionarioModel> funcionario = funcionarioRepository.findById(codigoFuncionario);
			
			if(funcionario.isEmpty()) {
				throw new ItemNotFoundException("Nenhum funcionário com o CÓDIGO " + codigoFuncionario + " encontrado!");
			}
			
			return funcionario.get();
		}
	
	// post
	// get
//	get all
	// update
	//delete

}
