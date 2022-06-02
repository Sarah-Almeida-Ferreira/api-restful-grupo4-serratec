package org.serratec.lojasamazonas.controller;

import java.util.List;

import org.serratec.lojasamazonas.dto.CategoriaDTO;
import org.serratec.lojasamazonas.dto.CategoriaDTORequest;
import org.serratec.lojasamazonas.exception.ItemAlreadyExistsException;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.exception.MayNotBeNullException;
import org.serratec.lojasamazonas.service.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService service;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody CategoriaDTORequest categoria) throws ItemAlreadyExistsException {
		return ResponseEntity.ok(service.crate(categoria));
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{codigoCategoria}")
	public ResponseEntity<CategoriaDTO> getByCodigol(@PathVariable Long codigoCategoria) throws ItemNotFoundException {
		return ResponseEntity.ok(service.getByCodigo(codigoCategoria));
	}
	
	@PutMapping("/{codigoCategoria}")
	public ResponseEntity<String> update(@PathVariable Long codigoCategoria, @RequestBody CategoriaDTORequest categoriaDTO) throws MayNotBeNullException, ItemNotFoundException {
		return ResponseEntity.ok(service.update(codigoCategoria, categoriaDTO));
	}
	
	@DeleteMapping("/{codigoCategoria}")
	public ResponseEntity<String> delete(@PathVariable Long codigoCategoria) throws ItemNotFoundException {
		return ResponseEntity.ok(service.delete(codigoCategoria));
	}
}
