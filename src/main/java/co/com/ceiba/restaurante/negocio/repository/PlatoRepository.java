package co.com.ceiba.restaurante.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.restaurante.negocio.entity.PlatosEntity;

public interface PlatoRepository extends JpaRepository<PlatosEntity, Long> {

	@Query(value = "SELECT P.ID, P.NOMBRE, P.DESCRIPCION, P.VALOR FROM PLATO P WHERE P.NOMBRE = :nombre", nativeQuery = true)
	PlatosEntity findByNombre(@Param("nombre") String nombre);
	
}
