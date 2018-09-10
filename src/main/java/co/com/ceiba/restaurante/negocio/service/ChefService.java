package co.com.ceiba.restaurante.negocio.service;

import org.springframework.stereotype.Service;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.model.Pedido;

@Service
public interface ChefService {

	/**
	 * Metodo para consultar el primer plato por preparar
	 * 
	 * @return
	 */
	PedidoEntity findPrimerPlatoPreparar();

	/**
	 * Metodo para entregar un pedido al mesero
	 * 
	 * @param pedido
	 * @return
	 */
	void entregarPedido(Pedido pedido);
}
