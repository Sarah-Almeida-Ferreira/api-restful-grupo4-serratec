package org.serratec.lojasamazonas.util;

import java.util.ArrayList;
import java.util.List;

import org.serratec.lojasamazonas.exception.CannotBeChangedException;
import org.serratec.lojasamazonas.exception.InsufficientStockException;
import org.serratec.lojasamazonas.exception.ItemAlreadyExistsException;
import org.serratec.lojasamazonas.model.ItemPedidoModel;
import org.serratec.lojasamazonas.model.PedidoModel;
import org.serratec.lojasamazonas.model.ProdutoModel;
import org.serratec.lojasamazonas.model.StatusPedido;
import org.serratec.lojasamazonas.repository.CategoriaRepository;
import org.serratec.lojasamazonas.repository.ClienteRepository;
import org.serratec.lojasamazonas.repository.FuncionarioRepository;
import org.serratec.lojasamazonas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validation {
	
	@Autowired
	private ClienteRepository clienteInjected;
	
	@Autowired
	private FuncionarioRepository funcionarioInjected;
	
	@Autowired
	private CategoriaRepository categoriaInjected;
	
	@Autowired
	private ProdutoRepository produtoInjected;
	
	public void verificarSeCpfJáFoiCadastrado(String cpf) throws ItemAlreadyExistsException {
		
		List<String> cpfs = new ArrayList<>();
		
		cpfs.addAll(clienteInjected.getCpfs());
		cpfs.addAll(funcionarioInjected.getCpfs());
		
		for(String cpfCadastrado : cpfs) {
			if (cpfCadastrado.equals(cpf)) {
				throw new ItemAlreadyExistsException("Já existe cadastro com este CPF!");
			}
		}		
	}
	
	public void verificarSeEmailJáFoiCadastrado(String email) throws ItemAlreadyExistsException {
		
		List<String> emails = clienteInjected.getEmails();
		
		for(String emailCadastrado : emails) {
			if (emailCadastrado.equals(email)) {
				throw new ItemAlreadyExistsException("Já existe cadastro com este e-mail!");
			}
		}		
	}
	
	public void verificarSeUsuarioJáFoiCadastrado(String usuario) throws ItemAlreadyExistsException {
		
		List<String> usuarios = clienteInjected.getUsuarios();
		
		for(String usuarioCadastrado : usuarios) {
			if (usuarioCadastrado.equals(usuario)) {
				throw new ItemAlreadyExistsException("Já existe cadastro com este nome de usuário!");
			}
		}		
	}
	
	public void verificarSeCategoriaJáFoiCadastrada(String nomeCategoria) throws ItemAlreadyExistsException {
		
		List<String> categorias = categoriaInjected.getNomes();
		
		for(String categoriaCadastrada : categorias) {
			if (categoriaCadastrada.equals(nomeCategoria)) {
				throw new ItemAlreadyExistsException("Já existe categoria cadastrada com este nome!");
			}
		}		
	}
	
	public ProdutoModel verificarSeProdutoJáFoiCadastrado(String nomeProduto) throws ItemAlreadyExistsException {
		
		List<ProdutoModel> produtos = produtoInjected.findAll();
		
		for(ProdutoModel produtoCadastrado : produtos) {
			if (produtoCadastrado.getNomeProduto().equals(nomeProduto)) {
				return produtoCadastrado;
			}
		}
		return null;
	}
	
	public static void verificarSeHaEstoqueSuficiente(ItemPedidoModel item) throws InsufficientStockException {
		
		if(item.getProduto().getQuantidadeEstoque() < item.getQuantidade()) {
			throw new InsufficientStockException("Não há estoque suficiente do produto código " 
					+ item.getProduto().getCodigoProduto() + "Para comprar a quantidade desejada!");
		}
	}
	
	public static void verificarSeHaEstoqueSuficiente(List<ItemPedidoModel> itens) throws InsufficientStockException {
		
		List<Long> itensSemEstoqueIds = new ArrayList<>();
		
		for(ItemPedidoModel item : itens) {
			
			if(item.getProduto().getQuantidadeEstoque() < item.getQuantidade()) {
				itensSemEstoqueIds.add(item.getProduto().getCodigoProduto());
			}
		}
		
		if(itensSemEstoqueIds.size() > 0) {
			throw new InsufficientStockException("Não há estoque suficiente dos produtos om os seguintes códigos: " 
					+ String.valueOf(itensSemEstoqueIds));
		}
		
	}
	
	public static void VerificarSePodeSerAlterado(PedidoModel pedido) throws InsufficientStockException, CannotBeChangedException {
		
		if(StatusPedido.FINALIZADO.equals(pedido.getStatus())) {
			throw new CannotBeChangedException("Não é possível alterar o pedido código " 
					+ pedido.getCodigoPedido() + ", pois ele já foi finalizado!");
		}
		if(StatusPedido.CANCELADO.equals(pedido.getStatus())) {
			throw new CannotBeChangedException("Não é possível alterar o pedido código " 
					+ pedido.getCodigoPedido() + ", pois ele foi cancelado!");
		}
	}
	
	public static void VerificarSePodeSerAlterado(List<ItemPedidoModel> itens) throws InsufficientStockException, CannotBeChangedException {
		
		List<Long> pedidosFinalizadosIds = new ArrayList<>();
		
		for (ItemPedidoModel item : itens) {
			if(StatusPedido.FINALIZADO.equals(item.getPedido().getStatus())) {
				pedidosFinalizadosIds.add(item.getPedido().getCodigoPedido());
			}
		}
		
		if(pedidosFinalizadosIds.size() > 0) {			
			throw new CannotBeChangedException("Não é possível alterar os pedidos com os códigos a seguir, "
					+ "pois já foram finalizados! " + String.valueOf(pedidosFinalizadosIds));
		}	
	}
	
	public static void VerificarSePodeSerFinalizado(PedidoModel pedido) throws InsufficientStockException, CannotBeChangedException {
		VerificarSePodeSerAlterado(pedido);
		verificarSeHaEstoqueSuficiente(pedido.getItensPedido()); 
	
	}
	
}
