package co.com.ceiba.restaurante.negocio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DETALLE_PEDIDO")
public class DetallePedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private PedidoEntity pedido;

	@ManyToOne
	@JoinColumn(name = "id_plato")
	private PlatosEntity plato;

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public PlatosEntity getPlato() {
		return plato;
	}

	public void setPlato(PlatosEntity plato) {
		this.plato = plato;
	}

}
