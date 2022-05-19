package org.serratec.lojasAmazonas.controllers;

import org.serratec.lojasAmazonas.entities.ClienteEntity;
import org.serratec.lojasAmazonas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteEntity> getById(@PathVariable Long id){
		ClienteEntity cliente = service.getById(id);
		
		if(cliente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ClienteEntity>(cliente, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody ClienteEntity cliente) {
		service.create(cliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
