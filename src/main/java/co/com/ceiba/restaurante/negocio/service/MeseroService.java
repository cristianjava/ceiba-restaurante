package co.com.ceiba.restaurante.negocio.service;

import java.util.List;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.model.Pedido;
import co.com.ceiba.restaurante.negocio.model.Plato;

public interface MeseroService {

	/**
	 * Metodo para guardar en la tabla pedido
	 * 
	 * @param platos
	 */
	void generarPedido(List<Plato> platos);

	/**
	 * Metodo para consultar el pedido que el mesero debe llevar a la mesa porque ya esta listo
	 * 
	 * @return 
	 */
	PedidoEntity consultarProximoDespachoMesa();

	/**
	 *Metodo para que el mesero valide que se entrego en la mesa del cliente su pedido 
	 * 
	 * @param pedido
	 */
	void entregarDespachoPedido(Pedido pedido);

}
