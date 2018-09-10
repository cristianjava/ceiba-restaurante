package co.com.ceiba.restaurante.negocio.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PLATO")
public class PlatosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String nombre;

	@NotNull
	private String descripcion;
	
	@NotNull
	private double valor;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_plato")
	private TipoPlatoEntity tipoPlato;

	@OneToMany(mappedBy = "plato", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<DetallePedidoEntity> detallePedido;
	
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

	public TipoPlatoEntity getTipoPlato() {
		return tipoPlato;
	}

	public void setTipoPlato(TipoPlatoEntity tipoPlato) {
		this.tipoPlato = tipoPlato;
	}
	
}
