package co.com.ceiba.restaurante.negocio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.exception.RestauranteException;
import co.com.ceiba.restaurante.negocio.model.Pedido;
import co.com.ceiba.restaurante.negocio.service.CajeroService;
import co.com.ceiba.restaurante.negocio.service.PedidoService;
import co.com.ceiba.restaurante.negocio.util.Constantes;

@Service
public class CajeroServiceImpl implements CajeroService {

	@Autowired
	PedidoService pedidoService;
	
	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.CajeroService#consultarPedidoPagar(co.com.ceiba.restaurante.negocio.model.Pedido)
	 */
	@Override
	public PedidoEntity consultarPedidoPagar(Pedido pedido) {
		return pedidoService.consultarPedidoId(pedido.getId());
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.MeseroService#pagarPedido(co.com.ceiba.restaurante.negocio.model.Pedido)
	 */
	@Override
	public void pagarPedido(Pedido pedido) {
		PedidoEntity pedidoEntity = pedidoService.consultarPedidoId(pedido.getId());
		if (pedidoEntity == null) {
			throw new RestauranteException(Constantes.PEDIDO_NO_REGISTRADO);
		}
		if (pedidoEntity.getEntregado().equals(Constantes.SI) && pedidoEntity.getEnMesa().equals(Constantes.SI) && pedidoEntity.getPagado().equals(Constantes.SI)) {
			throw new RestauranteException(Constantes.PEDIDO_PAGADO);
		}
		pedidoService.pagarPedido(pedido);
	}

}
