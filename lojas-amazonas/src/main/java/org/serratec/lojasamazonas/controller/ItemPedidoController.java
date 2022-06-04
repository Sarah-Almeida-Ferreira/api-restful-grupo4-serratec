package org.serratec.lojasamazonas.controller;

import java.util.List;
import org.serratec.lojasamazonas.dto.ItemPedidoDTO;
import org.serratec.lojasamazonas.dto.ItemPedidoDTORequest;
import org.serratec.lojasamazonas.exception.CannotBeChangedException;
import org.serratec.lojasamazonas.exception.InsufficientStockException;
import org.serratec.lojasamazonas.exception.ItemAlreadyExistsException;
import org.serratec.lojasamazonas.dto.RelatorioMaisVendidosDto;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.service.ItemPedidoService;
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
@RequestMapping("/itemPedido")
public class ItemPedidoController {
	
	@Autowired
	ItemPedidoService service;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody ItemPedidoDTORequest itemPedido) throws ItemNotFoundException, ItemAlreadyExistsException, InsufficientStockException, CannotBeChangedException {
		return ResponseEntity.ok(service.create(itemPedido));
	}
	
	@PostMapping("/criarMuitos")
	public ResponseEntity<String> createMany(@RequestBody List<ItemPedidoDTORequest> itensPedido) throws ItemNotFoundException, ItemAlreadyExistsException, InsufficientStockException, CannotBeChangedException {
		return ResponseEntity.ok(service.create(itensPedido));
	}
	
	@GetMapping("/listarItensPedido/{codigoPedido}")
	public ResponseEntity<List<ItemPedidoDTO>> getByCodigoPedido(@PathVariable Long codigoPedido) throws ItemNotFoundException {
		return ResponseEntity.ok(service.getItensByCodigoPedido(codigoPedido));
	}
	
	@GetMapping("/{codigoItem}")
	public ResponseEntity<ItemPedidoDTO> getByCodigoItem(@PathVariable Long codigoItem) throws ItemNotFoundException {
		return ResponseEntity.ok(service.getByCodigoItem(codigoItem));
	}
	
	@PutMapping("/{codigoItem}")
	public ResponseEntity<String> update(@PathVariable Long codigoItem, @RequestBody ItemPedidoDTORequest item) throws ItemNotFoundException {
		return ResponseEntity.ok(service.update(codigoItem, item));
	}
	
	@DeleteMapping("/{codigoItem}")
	public ResponseEntity<String> delete(@PathVariable Long codigoItem) throws ItemNotFoundException {
		return ResponseEntity.ok(service.delete(codigoItem));
	}
	
	@GetMapping("/relatorio-mais-vendidos")
	public ResponseEntity<List<RelatorioMaisVendidosDto>> relatorio() {
		return ResponseEntity.ok(service.relatorio());
	}
	
}