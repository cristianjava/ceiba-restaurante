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
import co.com.ceiba.restaurante.negocio.service.CajeroService;
import co.com.ceiba.restaurante.negocio.util.Constantes;

@RestController
@RequestMapping("/cajero")
public class CajeroRest {

	@Autowired
	CajeroService cajeroService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/consultarPedidoPagar")
	public Pedido consultarPedidoPagar(@RequestBody Pedido pedido) {
		PedidoEntity pedidoEntity = cajeroService.consultarPedidoPagar(pedido);
		if (pedidoEntity == null) {
			throw new RestauranteException(Constantes.PEDIDO_NO_REGISTRADO);
		}
		return PedidoBuilder.convertirAObjeto(pedidoEntity);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/pagarPedido")
	public void pagarPedido(@RequestBody Pedido pedido) {
		cajeroService.pagarPedido(pedido);
	}
}
