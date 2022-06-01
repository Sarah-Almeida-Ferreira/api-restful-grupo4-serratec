package org.serratec.lojasamazonas.controller;

import java.util.List;

import org.serratec.lojasamazonas.dto.PedidoDTORequest;
import org.serratec.lojasamazonas.dto.PedidoDto;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.service.PedidoService;
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
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@PostMapping
<<<<<<< Updated upstream
	public ResponseEntity<String> create(@RequestBody PedidoDto pedidoDto)
			throws ItemNotFoundException {
=======
	public ResponseEntity<String> create(@RequestBody PedidoDTORequest pedidoDto) throws ItemNotFoundException {
>>>>>>> Stashed changes
		return ResponseEntity.ok(pedidoService.create(pedidoDto));
	}
	
	@GetMapping("/{codigoPedido}")
	public ResponseEntity<PedidoDto> getByCodigo(@PathVariable Long codigoPedido)
			throws ItemNotFoundException {
		return ResponseEntity.ok(pedidoService.getByCodigo(codigoPedido));
	}
	
	@GetMapping
	public ResponseEntity<List<PedidoDto>> getAll() {
		return ResponseEntity.ok(pedidoService.getAll());
	}
	
	@PutMapping("/{codigoPedido}")
	public ResponseEntity<String> update(@PathVariable Long codigoPedido, @RequestBody PedidoDto dto)
			throws ItemNotFoundException {
		return ResponseEntity.ok(pedidoService.update(codigoPedido, dto));
	}
	
	@DeleteMapping("/{codigoPedido}")
	public ResponseEntity<String> delete(@PathVariable Long codigoPedido)
			throws ItemNotFoundException {
		return ResponseEntity.ok(pedidoService.delete(codigoPedido));
	}

}