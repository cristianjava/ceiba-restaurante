package co.com.ceiba.restaurante.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.entity.builder.PedidoBuilder;
import co.com.ceiba.restaurante.negocio.exception.RestauranteException;
import co.com.ceiba.restaurante.negocio.model.Pedido;
import co.com.ceiba.restaurante.negocio.model.Plato;
import co.com.ceiba.restaurante.negocio.service.MeseroService;
import co.com.ceiba.restaurante.negocio.util.Constantes;

@RestController
@RequestMapping("/mesero")
public class MeseroRest {

	@Autowired
	MeseroService meseroService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/generarPedido")
	public void generarPedido(@RequestBody List<Plato> platos) {
		meseroService.generarPedido(platos);
	}
	
	@RequestMapping(value = "/consultarProximoDespachoMesa")
	public Pedido consultarProximoDespachoMesa() {
		PedidoEntity pedidoEntity = meseroService.consultarProximoDespachoMesa();
		if (pedidoEntity == null) {
			throw new RestauranteException(Constantes.NO_HAY_PEDIDO_DESPACHAR);
		}
		return PedidoBuilder.convertirAObjeto(pedidoEntity);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/entregarDespachoPedido")
	public void entregarDespachoPedido(@RequestBody Pedido pedido) {
		meseroService.entregarDespachoPedido(pedido);
	}
	
}
