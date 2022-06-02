package org.serratec.lojasamazonas.controller;

import java.util.List;

import org.serratec.lojasamazonas.dto.ClienteDTO;
import org.serratec.lojasamazonas.dto.ClienteDTORequest;
import org.serratec.lojasamazonas.exception.ItemAlreadyExistsException;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	ClienteService clienteService;
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getAll(){
		return ResponseEntity.ok(clienteService.getAll());
	}
	@PostMapping
	public ResponseEntity<String> create(@RequestBody ClienteDTORequest clienteDTO) throws ItemAlreadyExistsException{
		return ResponseEntity.ok(clienteService.create(clienteDTO));
		
	}
	@GetMapping("/{codigoCliente}")
	public ResponseEntity<ClienteDTO> getById(@PathVariable Long codigoCliente) throws ItemNotFoundException{
		return ResponseEntity.ok(clienteService.getById(codigoCliente));
	}
	
	@PutMapping("/{codigoCliente}")
	public ResponseEntity<String> update(@PathVariable Long codigoCliente, @RequestBody ClienteDTORequest clienteDTO) throws ItemNotFoundException{
		return ResponseEntity.ok(clienteService.update(codigoCliente, clienteDTO));
	}
	
	@DeleteMapping("/{codigoCliente}")
	public ResponseEntity<String> delete(@PathVariable Long codigoCliente) throws ItemNotFoundException{
		return ResponseEntity.ok(clienteService.delete(codigoCliente));
	}
	
}