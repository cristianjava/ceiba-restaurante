package co.com.ceiba.restaurante.negocio.model;

import java.io.Serializable;

public class TipoPlato implements Serializable {

	private static final long serialVersionUID = -8120882315756011849L;
	private long id;
	private String nombre;
	private String descripcion;

	public TipoPlato(long id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public TipoPlato() {
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

}
