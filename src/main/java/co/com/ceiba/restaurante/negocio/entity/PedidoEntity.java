package co.com.ceiba.restaurante.negocio.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PEDIDO")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private LocalDate fechaPedido;

	@NotNull
	private double total;

	@NotNull
	private String entregado;

	@NotNull
	private String enMesa;

	@NotNull
	private String pagado;
	
	@OneToMany(mappedBy = "pedido", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<DetallePedidoEntity> detallePedido;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getFechaPedido() { 
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getEntregado() {
		return entregado;
	}

	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}

	public String getEnMesa() {
		return enMesa;
	}

	public void setEnMesa(String enMesa) {
		this.enMesa = enMesa;
	}

	public String getPagado() {
		return pagado;
	}

	public void setPagado(String pagado) {
		this.pagado = pagado;
	}

	public List<DetallePedidoEntity> getDetallePedido() {
		return detallePedido;
	}

}
