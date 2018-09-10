package co.com.ceiba.restaurante.negocio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurante.negocio.entity.DetallePedidoEntity;
import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.entity.builder.PlatosBuilder;
import co.com.ceiba.restaurante.negocio.model.Plato;
import co.com.ceiba.restaurante.negocio.repository.DetallePedidoRepository;
import co.com.ceiba.restaurante.negocio.service.DetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

	@Autowired
	DetallePedidoRepository detallePedidoRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.ceiba.restaurante.negocio.service.DetallePedidoService#
	 * guardarDetallePedido(java.util.List)
	 */
	@Override
	public void guardarDetallePedido(List<Plato> platos, PedidoEntity pedido) {
		// Se guarda en Detalle Pedido
		for (Plato plato : platos) {
			DetallePedidoEntity platoPedido = new DetallePedidoEntity();
			platoPedido.setPlato(PlatosBuilder.convertirAEntity(plato));
			platoPedido.setPedido(pedido);
			detallePedidoRepository.save(platoPedido);
		}
	}
}
