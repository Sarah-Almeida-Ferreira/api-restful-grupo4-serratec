package org.serratec.lojasamazonas.controller;

import java.util.List;

import org.serratec.lojasamazonas.dto.ItemPedidoDTO;
import org.serratec.lojasamazonas.dto.ItemPedidoDTORequest;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemPedido")
public class ItemPedidoController {
	
	@Autowired
	ItemPedidoService service;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody ItemPedidoDTORequest itemPedido) throws ItemNotFoundException {
		return ResponseEntity.ok(service.create(itemPedido));
	}
	
	@PostMapping("/criarMuitos")
	public ResponseEntity<String> createMany(@RequestBody List<ItemPedidoDTORequest> itensPedido) throws ItemNotFoundException {
		return ResponseEntity.ok(service.create(itensPedido));
	}
	
	@GetMapping("/{codigoPedido}")
	public ResponseEntity<List<ItemPedidoDTO>> getByCodigoPedido(@PathVariable Long codigoPedido) throws ItemNotFoundException {
		return ResponseEntity.ok(service.getItensByCodigoPedido(codigoPedido));
	}
	
}
