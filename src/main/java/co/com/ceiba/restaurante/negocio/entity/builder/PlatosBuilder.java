package co.com.ceiba.restaurante.negocio.entity.builder;

import co.com.ceiba.restaurante.negocio.entity.PlatosEntity;
import co.com.ceiba.restaurante.negocio.entity.TipoPlatoEntity;
import co.com.ceiba.restaurante.negocio.model.Plato;

public final class PlatosBuilder {

	private PlatosBuilder() {

	}

	public static PlatosEntity convertirAEntity(Plato plato) {
		TipoPlatoEntity tipoPlatoEntity = TipoPlatoBuilder.convertirAEntity(plato.getTipoPlato());
		PlatosEntity platosEntity = new PlatosEntity();
		platosEntity.setNombre(plato.getNombre());
		platosEntity.setDescripcion(plato.getDescripcion());
		platosEntity.setValor(plato.getValor());
		platosEntity.setNombre(plato.getNombre());
		platosEntity.setTipoPlato(tipoPlatoEntity);
		return platosEntity;
	}

}
