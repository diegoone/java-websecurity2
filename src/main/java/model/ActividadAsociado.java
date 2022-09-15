package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "actividadAsociado" database table.
 * 
 */
@Entity
@Table(name="\"actividadAsociado\"")
@NamedQuery(name="ActividadAsociado.findAll", query="SELECT a FROM ActividadAsociado a")
public class ActividadAsociado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaIngreso\"")
	private Date fechaIngreso;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaRetiro\"")
	private Date fechaRetiro;

	@Column(name="\"movitoRetiro\"")
	private String movitoRetiro;

	//bi-directional many-to-one association to Asociado
	@ManyToOne
	@JoinColumn(name="\"idAsociado\"")
	private Asociado asociado;

	public ActividadAsociado() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaRetiro() {
		return this.fechaRetiro;
	}

	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public String getMovitoRetiro() {
		return this.movitoRetiro;
	}

	public void setMovitoRetiro(String movitoRetiro) {
		this.movitoRetiro = movitoRetiro;
	}

	public Asociado getAsociado() {
		return this.asociado;
	}

	public void setAsociado(Asociado asociado) {
		this.asociado = asociado;
	}

}