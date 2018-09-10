package co.com.ceiba.restaurante.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.entity.builder.PedidoBuilder;
import co.com.ceiba.restaurante.negocio.exception.RestauranteException;
import co.com.ceiba.restaurante.negocio.model.Pedido;
import co.com.ceiba.restaurante.negocio.service.ChefService;
import co.com.ceiba.restaurante.negocio.util.Constantes;

@RestController
@RequestMapping("/chef")
public class ChefRest {

	@Autowired
	ChefService chefService;

	@RequestMapping(value = "/prepararPedido")
	public Pedido prepararPedido() {
		PedidoEntity pedidoEntity = chefService.findPrimerPlatoPreparar();
		if (pedidoEntity == null) {
			throw new RestauranteException(Constantes.NO_HAY_PEDIDO_PREPARAR);
		}
		return PedidoBuilder.convertirAObjeto(pedidoEntity);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/entregarPedido")
	public void entregarPedido(@RequestBody Pedido pedido) {
		chefService.entregarPedido(pedido);
	}
}
