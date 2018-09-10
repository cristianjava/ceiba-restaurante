package co.com.ceiba.restaurante.negocio.entity.builder;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.model.Pedido;

public class PedidoBuilder {

	private PedidoBuilder() {

	}

	public static PedidoEntity convertirAEntity(Pedido pedido) {
		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setFechaPedido(pedido.getFechaPedido());
		pedidoEntity.setTotal(pedido.getTotal());
		pedidoEntity.setEnMesa(pedido.getEnMesa());
		pedidoEntity.setEntregado(pedido.getEntregado());
		return pedidoEntity;
	}
	
	public static Pedido convertirAObjeto(PedidoEntity pedidoEntity) {
		Pedido pedido = new Pedido();
		pedido.setId(pedidoEntity.getId());
		pedido.setFechaPedido(pedidoEntity.getFechaPedido());
		pedido.setTotal(pedidoEntity.getTotal());
		pedido.setEnMesa(pedidoEntity.getEnMesa());
		pedido.setEntregado(pedidoEntity.getEntregado());
		pedido.setPagado(pedidoEntity.getPagado());
		pedido.setDetallePedido(DetallePedidoBuilder.convertirAObjeto(pedidoEntity.getDetallePedido()));
		return pedido;
	}

}
