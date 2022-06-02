package org.serratec.lojasamazonas.util;

import org.serratec.lojasamazonas.model.PedidoModel;
import org.serratec.lojasamazonas.model.StatusPedido;

public class Validation {

	public static boolean podeSerFinalizada(PedidoModel pedido) {
		return StatusPedido.PENDENTE.equals(pedido.getStatus());
	}

	public static boolean naoPodeSerFinalizada(PedidoModel pedido) {
		return !podeSerFinalizada(pedido);
	}
	
}
