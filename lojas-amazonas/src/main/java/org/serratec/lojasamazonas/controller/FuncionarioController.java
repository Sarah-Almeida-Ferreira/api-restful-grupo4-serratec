package org.serratec.lojasamazonas.controller;

import java.util.List;

import org.serratec.lojasamazonas.dto.FuncionarioDTO;
import org.serratec.lojasamazonas.dto.FuncionarioDTORequest;
import org.serratec.lojasamazonas.exception.ItemAlreadyExistsException;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	
	@Autowired
	FuncionarioService funcionarioService;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody FuncionarioDTORequest funcionarioDTO) throws ItemAlreadyExistsException {
		return ResponseEntity.ok(funcionarioService.create(funcionarioDTO));
	}
	
	@GetMapping
	public ResponseEntity<List<FuncionarioDTO>> get(){
		return ResponseEntity.ok(funcionarioService.getAll());
	}
	
	@GetMapping("/{codigoFuncionario}")
	public ResponseEntity<FuncionarioDTO> getByCodigo(@PathVariable Long codigoFuncionario) throws ItemNotFoundException{
		return ResponseEntity.ok(funcionarioService.getByCodigo(codigoFuncionario));
	}
	
	@PutMapping("/{codigoFuncionario}")
	public ResponseEntity<String> update(@PathVariable Long codigoFuncionario, @RequestBody FuncionarioDTORequest funcionarioDTO) throws ItemNotFoundException{
		return ResponseEntity.ok(funcionarioService.update(codigoFuncionario, funcionarioDTO));
	}
	
	@DeleteMapping("/{codigoFuncionario}")
	public ResponseEntity<String> delete(@PathVariable Long codigoFuncionario) throws ItemNotFoundException{
		return ResponseEntity.ok(funcionarioService.delete(codigoFuncionario));
	}
}
