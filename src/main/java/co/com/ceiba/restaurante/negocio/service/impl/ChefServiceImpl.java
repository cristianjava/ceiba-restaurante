package co.com.ceiba.restaurante.negocio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.exception.RestauranteException;
import co.com.ceiba.restaurante.negocio.model.Pedido;
import co.com.ceiba.restaurante.negocio.service.ChefService;
import co.com.ceiba.restaurante.negocio.service.PedidoService;
import co.com.ceiba.restaurante.negocio.util.Constantes;

@Service
public class ChefServiceImpl implements ChefService {

	@Autowired
	PedidoService pedidoService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.ceiba.restaurante.negocio.service.ChefService# consultarPrimerPlatoPreparar()
	 */
	@Override
	public PedidoEntity findPrimerPlatoPreparar() {
		// se hacen las validaciones de negocio

		// se cosnulta el primer pedido que falte por preparar
		return pedidoService.consultarUltimoPedidoPreparar();
		
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.ChefService#entregarPedido(co.com.ceiba.restaurante.negocio.model.Pedido)
	 */
	@Override
	public void entregarPedido(Pedido pedido) {
		PedidoEntity pedidoEntity = pedidoService.consultarPedidoId(pedido.getId());
		if (pedidoEntity == null) {
			throw new RestauranteException(Constantes.PEDIDO_NO_REGISTRADO);
		}
		if (pedidoEntity.getEntregado().equals(Constantes.SI)) {
			throw new RestauranteException(Constantes.PEDIDO_PREPARADO);
		}
		pedidoService.entregarPedido(pedido);
	}
}
