package co.com.ceiba.restaurante.negocio.entity.builder;

import co.com.ceiba.restaurante.negocio.entity.PlatosEntity;
import co.com.ceiba.restaurante.negocio.entity.TipoPlatoEntity;
import co.com.ceiba.restaurante.negocio.model.Plato;
import co.com.ceiba.restaurante.negocio.model.TipoPlato;

public final class PlatosBuilder {

	private PlatosBuilder() {

	}

	public static PlatosEntity convertirAEntity(Plato plato) {
		TipoPlatoEntity tipoPlatoEntity = TipoPlatoBuilder.convertirAEntity(plato.getTipoPlato());
		PlatosEntity platosEntity = new PlatosEntity();
		platosEntity.setId(plato.getId());
		platosEntity.setNombre(plato.getNombre());
		platosEntity.setDescripcion(plato.getDescripcion());
		platosEntity.setValor(plato.getValor());
		platosEntity.setNombre(plato.getNombre());
		platosEntity.setTipoPlato(tipoPlatoEntity);
		return platosEntity;
	}

	public static Plato convertirAObjeto(PlatosEntity platosEntity) {
		TipoPlato tipoPlato = TipoPlatoBuilder.convertirAObjeto(platosEntity.getTipoPlato());
		Plato plato = new Plato();
		plato.setId(platosEntity.getId());
		plato.setNombre(platosEntity.getNombre());
		plato.setDescripcion(platosEntity.getDescripcion());
		plato.setValor(platosEntity.getValor());
		plato.setNombre(platosEntity.getNombre());
		plato.setTipoPlato(tipoPlato);
		return plato;
	}

}
