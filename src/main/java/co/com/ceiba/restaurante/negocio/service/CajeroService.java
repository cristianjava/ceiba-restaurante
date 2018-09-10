package co.com.ceiba.restaurante.negocio.service;

import org.springframework.stereotype.Service;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.model.Pedido;

@Service
public interface CajeroService {

	/**
	 * Metodo para consultar un pedido que se va a pagar
	 * 
	 * @param pedido
	 * @return
	 */
	PedidoEntity consultarPedidoPagar(Pedido pedido);

	/**
	 * Metodo para pagar un pedido 
	 * 
	 * @param pedido
	 */
	void pagarPedido(Pedido pedido);

}
