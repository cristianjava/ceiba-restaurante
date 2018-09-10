package co.com.ceiba.restaurante.negocio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.model.Pedido;

@Service
public interface PedidoService {

	/**
	 * Metodo para guadar un pedido
	 * 
	 * @param pedido
	 */
	void guardarPedido(PedidoEntity pedido);

	/**
	 * Metodo para consultar los pedidos
	 * 
	 * @return
	 */
	List<PedidoEntity> findAll();

	/**
	 * Metodo para consultar el primer pedido que se encuentre pendiente por
	 * prepara
	 * 
	 * @return
	 */
	PedidoEntity consultarUltimoPedidoPreparar();

	/**
	 * Metodo para cambiar entregado de N a S
	 * 
	 * @param pedido
	 */
	void entregarPedido(Pedido pedido);

	/**
	 * Metodo para consultar por el pedido por el id
	 * 
	 * @param id
	 * @return
	 */
	PedidoEntity consultarPedidoId(long id);

	/**
	 * Metodo para consultar en la BD el proximo pedido a ser despachado por el mesero
	 * 
	 * @return 
	 */
	PedidoEntity consultarProximoDespachoMesa();

	/**
	 * Metodo para validar que el pedido se coloco en la mesa del cliente
	 * 
	 * @param pedido
	 */
	void entregarDespachoPedido(Pedido pedido);

	/**
	 * Metodo para pagar un pedido
	 * 
	 * @param pedido
	 */
	void pagarPedido(Pedido pedido);
}
