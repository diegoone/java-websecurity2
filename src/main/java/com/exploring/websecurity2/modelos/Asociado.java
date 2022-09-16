package com.exploring.websecurity2.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the asociado database table.
 * 
 */
@Entity
@NamedQuery(name="Asociado.findAll", query="SELECT a FROM Asociado a")
public class Asociado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to ActividadAsociado
	@OneToMany(mappedBy="asociado")
	private List<ActividadAsociado> actividadAsociados;

	//bi-directional many-to-one association to Aportacion
	@OneToMany(mappedBy="asociado")
	private List<Aportacion> aportacions;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idPersona")
	private Persona persona;

	public Asociado() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ActividadAsociado> getActividadAsociados() {
		return this.actividadAsociados;
	}

	public void setActividadAsociados(List<ActividadAsociado> actividadAsociados) {
		this.actividadAsociados = actividadAsociados;
	}

	public ActividadAsociado addActividadAsociado(ActividadAsociado actividadAsociado) {
		getActividadAsociados().add(actividadAsociado);
		actividadAsociado.setAsociado(this);

		return actividadAsociado;
	}

	public ActividadAsociado removeActividadAsociado(ActividadAsociado actividadAsociado) {
		getActividadAsociados().remove(actividadAsociado);
		actividadAsociado.setAsociado(null);

		return actividadAsociado;
	}

	public List<Aportacion> getAportacions() {
		return this.aportacions;
	}

	public void setAportacions(List<Aportacion> aportacions) {
		this.aportacions = aportacions;
	}

	public Aportacion addAportacion(Aportacion aportacion) {
		getAportacions().add(aportacion);
		aportacion.setAsociado(this);

		return aportacion;
	}

	public Aportacion removeAportacion(Aportacion aportacion) {
		getAportacions().remove(aportacion);
		aportacion.setAsociado(null);

		return aportacion;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}