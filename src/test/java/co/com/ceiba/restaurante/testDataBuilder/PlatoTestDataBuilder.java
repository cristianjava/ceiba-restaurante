package co.com.ceiba.restaurante.testDataBuilder;

import co.com.ceiba.restaurante.negocio.model.Plato;
import co.com.ceiba.restaurante.negocio.model.TipoPlato;

public class PlatoTestDataBuilder {

	private long id;
	private String nombre;
	private String descripcion;
	private double valor;
	private TipoPlato tipoPlato;

	private static final long ID = 1;
	private static final String NOMBRE = "Bandeja sencilla";
	private static final String DESCRIPCION = "sopa, arroz, ensalada, huevo y jugo";
	private static final double VALOR = 10000;
	private static final TipoPlato TIPO_PLATO = new TipoPlato(2, "Almuerzo", "almuerzo");

	public PlatoTestDataBuilder() {
		this.id = ID;
		this.nombre = NOMBRE;
		this.descripcion = DESCRIPCION;
		this.valor = VALOR;
		this.tipoPlato = TIPO_PLATO;
	}

	public PlatoTestDataBuilder conId(long id) {
		this.id = id;
		return this;
	}

	public PlatoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public PlatoTestDataBuilder conValor(double valor) {
		this.valor = valor;
		return this;
	}

	public PlatoTestDataBuilder conTipoPlato(TipoPlato tipoPlato) {
		this.tipoPlato = tipoPlato;
		return this;
	}

	public PlatoTestDataBuilder conDescripcion(String descipcion) {
		this.descripcion = descipcion;
		return this;
	}

	public Plato build() {
		return new Plato(this.id, this.nombre, this.descripcion, this.valor, this.tipoPlato);
	}
}
