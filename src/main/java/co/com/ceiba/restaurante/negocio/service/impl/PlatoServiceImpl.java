package co.com.ceiba.restaurante.negocio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurante.negocio.entity.PlatosEntity;
import co.com.ceiba.restaurante.negocio.entity.builder.PlatosBuilder;
import co.com.ceiba.restaurante.negocio.model.Plato;
import co.com.ceiba.restaurante.negocio.repository.PlatoRepository;
import co.com.ceiba.restaurante.negocio.service.PlatoService;

@Service
public class PlatoServiceImpl implements PlatoService {

	@Autowired
	PlatoRepository platoRepository;
	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.PlatoService#guardarPlato(co.com.ceiba.restaurante.negocio.model.Plato)
	 */
	@Override
	public void guardarPlato(Plato plato) {
		// Se ejecutan las validaciones
		
		// Se almacena en la BD o repositorio
		platoRepository.save(PlatosBuilder.convertirAEntity(plato));
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.PlatoService#findByNombre(co.com.ceiba.restaurante.negocio.model.Plato)
	 */
	@Override
	public PlatosEntity findByNombre(Plato plato) {
		return platoRepository.findByNombre(plato.getNombre());
	}

	@Override
	public PlatosEntity findById(long id) {
		return platoRepository.findByPk(id);
	}

}
