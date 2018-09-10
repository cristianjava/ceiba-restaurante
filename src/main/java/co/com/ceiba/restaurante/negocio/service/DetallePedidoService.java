package co.com.ceiba.restaurante.negocio.service;

import java.util.List;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.model.Plato;

public interface DetallePedidoService {

	void guardarDetallePedido(List<Plato> platos, PedidoEntity pedido);
}
