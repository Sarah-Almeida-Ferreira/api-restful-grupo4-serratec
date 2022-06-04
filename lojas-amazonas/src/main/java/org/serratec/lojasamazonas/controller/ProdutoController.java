package org.serratec.lojasamazonas.controller;

import java.util.List;

import org.serratec.lojasamazonas.dto.ProdutoDTO;
import org.serratec.lojasamazonas.dto.ProdutoDTORequest;
import org.serratec.lojasamazonas.exception.ItemAlreadyExistsException;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.service.ProdutoService;
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
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	ProdutoService produtoService;
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> getAll() throws ItemNotFoundException{
		return ResponseEntity.ok(produtoService.getAll());
	}
	@GetMapping("/{codigoProduto}")
	public ResponseEntity<ProdutoDTO> getById(@PathVariable long codigoProduto) throws ItemNotFoundException{
		return ResponseEntity.ok(produtoService.getById(codigoProduto));
	}
	@PostMapping
	public ResponseEntity<String> create(@RequestBody ProdutoDTORequest produtoDTO) throws ItemNotFoundException, ItemAlreadyExistsException{
		return ResponseEntity.ok(produtoService.create(produtoDTO));
	}
	@PutMapping("/{codigoProduto}")
	public ResponseEntity<String> update(@RequestBody ProdutoDTORequest produtoDTO,@PathVariable long codigoProduto) throws ItemNotFoundException{
		return ResponseEntity.ok(produtoService.update(codigoProduto,produtoDTO));
	}
	@DeleteMapping("/{codigoProduto}")
	public ResponseEntity<String> delete(@PathVariable long codigoProduto) throws ItemNotFoundException{
		return ResponseEntity.ok(produtoService.delete(codigoProduto));
	}
}
