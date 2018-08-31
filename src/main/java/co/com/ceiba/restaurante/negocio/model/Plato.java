package co.com.ceiba.restaurante.negocio.model;

import java.io.Serializable;

public class Plato implements Serializable {

	private static final long serialVersionUID = 1898919637129158326L;
	private long id;
	private String nombre;
	private String descripcion;
	private double valor;
	private TipoPlato tipoPlato;

	public Plato(long id, String nombre, String descripcion, double valor, TipoPlato tipoPlato) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
		this.tipoPlato = tipoPlato;
	}

	public Plato() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoPlato getTipoPlato() {
		if (tipoPlato == null) {
			tipoPlato = new TipoPlato();
		}
		return tipoPlato;
	}

	public void setTipoPlato(TipoPlato tipoPlato) {
		this.tipoPlato = tipoPlato;
	}

}
