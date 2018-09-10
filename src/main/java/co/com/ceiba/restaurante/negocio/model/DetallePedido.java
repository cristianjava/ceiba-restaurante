package co.com.ceiba.restaurante.negocio.model;

public class DetallePedido {

	private Pedido pedido;
	private Plato plato;

	public DetallePedido(Pedido pedido, Plato plato) {
		super();
		this.pedido = pedido;
		this.plato = plato;
	}

	public DetallePedido() {
		super();
	}

	public Pedido getPedido() {
		if (pedido == null) {
			pedido = new Pedido();
		}
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Plato getPlato() {
		if (plato == null) {
			plato = new Plato();
		}
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

}
