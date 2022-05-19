package org.serratec.lojasAmazonas.controllers;

import org.serratec.lojasAmazonas.entities.CategoriaEntity;
import org.serratec.lojasAmazonas.services.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaEntity> getById(@PathVariable Long id){
		CategoriaEntity categoria = service.getById(id);
		
		if(categoria == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<CategoriaEntity>(categoria, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody CategoriaEntity categoria) {
		service.create(categoria);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
