package co.com.ceiba.restaurante.negocio.entity.builder;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.restaurante.negocio.entity.DetallePedidoEntity;
import co.com.ceiba.restaurante.negocio.model.DetallePedido;

public class DetallePedidoBuilder {

	private DetallePedidoBuilder() {

	}

	public static DetallePedidoEntity convertirAEntity(DetallePedido detallePedido) {
		DetallePedidoEntity detallePedidoEntity = new DetallePedidoEntity();
		detallePedidoEntity.setPedido(PedidoBuilder.convertirAEntity(detallePedido.getPedido()));
		detallePedidoEntity.setPlato(PlatosBuilder.convertirAEntity(detallePedido.getPlato()));
		return detallePedidoEntity;
	}

	public static List<DetallePedido> convertirAObjeto(List<DetallePedidoEntity> detallePedido) {
		List<DetallePedido> detallesPedidoObject = new ArrayList<>();
		for (DetallePedidoEntity detallePedidoEntity : detallePedido) {
			DetallePedido detallePedidoObject = new DetallePedido();
			
			detallePedidoObject.getPlato().setId(detallePedidoEntity.getPlato().getId());
			detallePedidoObject.getPlato().setNombre(detallePedidoEntity.getPlato().getNombre());
			detallePedidoObject.getPlato().setDescripcion(detallePedidoEntity.getPlato().getDescripcion());
			detallePedidoObject.getPlato().setValor(detallePedidoEntity.getPlato().getValor());
			detallePedidoObject.getPlato().setNombre(detallePedidoEntity.getPlato().getNombre());
			detallePedidoObject.getPlato().getTipoPlato().setId(detallePedidoEntity.getPlato().getTipoPlato().getId());
			
			detallesPedidoObject.add(detallePedidoObject);
		}
		return detallesPedidoObject;
	}

}
