package co.com.ceiba.restaurante.negocio.service;

import co.com.ceiba.restaurante.negocio.model.Plato;

public interface PlatoService {

	/**
	 * Metodo para guardar un plato en la BD
	 * 
	 * @param plato
	 */
	void guardarPlato(Plato plato);

	/**
	 * Metodo para buscar un plato por el nombre
	 * 
	 * @param plato
	 * @return
	 */
	Object findByNombre(Plato plato);
}
