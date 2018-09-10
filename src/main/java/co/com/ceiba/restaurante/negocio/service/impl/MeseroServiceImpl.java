package co.com.ceiba.restaurante.negocio.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.entity.PlatosEntity;
import co.com.ceiba.restaurante.negocio.exception.RestauranteException;
import co.com.ceiba.restaurante.negocio.model.Pedido;
import co.com.ceiba.restaurante.negocio.model.Plato;
import co.com.ceiba.restaurante.negocio.service.DetallePedidoService;
import co.com.ceiba.restaurante.negocio.service.MeseroService;
import co.com.ceiba.restaurante.negocio.service.PedidoService;
import co.com.ceiba.restaurante.negocio.service.PlatoService;
import co.com.ceiba.restaurante.negocio.util.Constantes;

@Service
public class MeseroServiceImpl implements MeseroService {

	@Autowired
	PedidoService pedidoService;

	@Autowired
	DetallePedidoService detallePedidoService;

	@Autowired
	PlatoService platoService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.ceiba.restaurante.negocio.service.MeseroService#generarPedido(java
	 * .util.List)
	 */
	@Override
	public void generarPedido(List<Plato> platos) {
		// Se calcula el total y se valida la logica del negocio
		double total = 0;
		for (Plato plato : platos) {
			if (plato.getId() == 0) {
				throw new RestauranteException(Constantes.INFORMACION_INCOMPLETA);
			}
			// Se consulta el producto en la BD
			PlatosEntity platosEntity = platoService.findById(plato.getId());
			if (platosEntity == null) {
				throw new RestauranteException(Constantes.PLATO_NO_EXISTE);
			}
			total += platosEntity.getValor();
		}

		// Se guarda en la tabla pedido y detalle pedido
		PedidoEntity pedido = new PedidoEntity();
		pedido.setFechaPedido(LocalDate.now());
		pedido.setTotal(total);
		pedido.setEnMesa(Constantes.NO);
		pedido.setPagado(Constantes.NO);
		pedido.setEntregado(Constantes.NO);

		pedidoService.guardarPedido(pedido);

		detallePedidoService.guardarDetallePedido(platos, pedido);
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.MeseroService#consultarProximoDespachoMesa()
	 */
	@Override
	public PedidoEntity consultarProximoDespachoMesa() {
		return pedidoService.consultarProximoDespachoMesa();
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.MeseroService#entregarDespachoPedido(co.com.ceiba.restaurante.negocio.model.Pedido)
	 */
	@Override
	public void entregarDespachoPedido(Pedido pedido) {
		PedidoEntity pedidoEntity = pedidoService.consultarPedidoId(pedido.getId());
		if (pedidoEntity == null) {
			throw new RestauranteException(Constantes.PEDIDO_NO_REGISTRADO);
		}
		if (pedidoEntity.getEntregado().equals(Constantes.SI) && pedidoEntity.getEnMesa().equals(Constantes.SI)) {
			throw new RestauranteException(Constantes.PEDIDO_DESPACHADO);
		}
		pedidoService.entregarDespachoPedido(pedido);
	}

}
