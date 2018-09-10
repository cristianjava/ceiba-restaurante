package co.com.ceiba.restaurante.negocio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Pedido implements Serializable {

	private static final long serialVersionUID = -303855565564940025L;

	private long id;
	private LocalDate fechaPedido;
	private double total;
	private String entregado;
	private String enMesa;
	private String pagado;
	private List<DetallePedido> detallePedido;

	public Pedido(long id, LocalDate fechaPedido, double total, List<DetallePedido> detallePedido) {
		super();
		this.id = id;
		this.fechaPedido = fechaPedido;
		this.total = total;
		this.detallePedido = detallePedido;
	}

	public Pedido() {
		super();
	}

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

	public String getEntregado() {
		return entregado;
	}

	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}

	public List<DetallePedido> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(List<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}

}
