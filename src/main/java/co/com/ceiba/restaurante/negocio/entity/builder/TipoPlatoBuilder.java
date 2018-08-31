package co.com.ceiba.restaurante.negocio.entity.builder;

import co.com.ceiba.restaurante.negocio.entity.TipoPlatoEntity;
import co.com.ceiba.restaurante.negocio.model.TipoPlato;

public final class TipoPlatoBuilder {

	private TipoPlatoBuilder() {

	}

	public static TipoPlatoEntity convertirAEntity(TipoPlato tipoPlato) {
		TipoPlatoEntity tipoPlatoEntity = new TipoPlatoEntity();
		tipoPlatoEntity.setId(tipoPlato.getId());
		tipoPlatoEntity.setNombre(tipoPlato.getNombre());
		tipoPlatoEntity.setDescripcion(tipoPlato.getDescripcion());
		return tipoPlatoEntity;
	}

}
