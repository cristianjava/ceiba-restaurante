package co.com.ceiba.restaurante.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

	@Query(value = "SELECT P.ID, P.EN_MESA, P. ENTREGADO, P.FECHA_PEDIDO, P.PAGADO, P.TOTAL FROM PEDIDO P WHERE P.ENTREGADO = 'N'  ORDER BY P.ID ASC LIMIT 1", nativeQuery = true)
	PedidoEntity findPrimerPedidoPorPreparar();

	@Modifying
	@Query(value = "UPDATE PEDIDO SET ENTREGADO = 'S' WHERE ID = :id", nativeQuery = true)
	void entregarPedido(@Param("id") long id);

	@Query(value = "SELECT P.ID, P.EN_MESA, P. ENTREGADO, P.FECHA_PEDIDO, P.PAGADO, P.TOTAL FROM PEDIDO P WHERE P.ID = :id", nativeQuery = true)
	PedidoEntity findByPk(@Param("id") long id);

	@Query(value = "SELECT P.ID, P.EN_MESA, P. ENTREGADO, P.FECHA_PEDIDO, P.PAGADO, P.TOTAL FROM PEDIDO P WHERE P.ENTREGADO = 'S' AND P.EN_MESA = 'N' ORDER BY P.ID ASC LIMIT 1", nativeQuery = true)
	PedidoEntity consultarProximoDespachoMesa();

	@Modifying
	@Query(value = "UPDATE PEDIDO SET EN_MESA = 'S' WHERE ID = :id", nativeQuery = true)
	void entregarDespachoPedido(@Param("id") long id);

	@Modifying
	@Query(value = "UPDATE PEDIDO SET PAGADO = 'S' WHERE ID = :id", nativeQuery = true)
	void pagarPedidoPk(@Param("id") long id);

}
