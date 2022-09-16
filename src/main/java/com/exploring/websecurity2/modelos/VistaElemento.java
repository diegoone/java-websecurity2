package com.exploring.websecurity2.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the vista_elemento database table.
 * 
 */
@Entity
@Table(name="vista_elemento")
@NamedQuery(name="VistaElemento.findAll", query="SELECT v FROM VistaElemento v")
public class VistaElemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String accion;

	private Boolean borrado;

	private String campo;

	@Column(name="creado_por")
	private Long creadoPor;

	@Column(name="fecha_creado")
	private Timestamp fechaCreado;

	@Column(name="fecha_modificado")
	private Timestamp fechaModificado;

	@Column(name="id_vista_componente")
	private Long idVistaComponente;

	@Column(name="modificado_por")
	private Long modificadoPor;

	public VistaElemento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Boolean getBorrado() {
		return this.borrado;
	}

	public void setBorrado(Boolean borrado) {
		this.borrado = borrado;
	}

	public String getCampo() {
		return this.campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public Long getCreadoPor() {
		return this.creadoPor;
	}

	public void setCreadoPor(Long creadoPor) {
		this.creadoPor = creadoPor;
	}

	public Timestamp getFechaCreado() {
		return this.fechaCreado;
	}

	public void setFechaCreado(Timestamp fechaCreado) {
		this.fechaCreado = fechaCreado;
	}

	public Timestamp getFechaModificado() {
		return this.fechaModificado;
	}

	public void setFechaModificado(Timestamp fechaModificado) {
		this.fechaModificado = fechaModificado;
	}

	public Long getIdVistaComponente() {
		return this.idVistaComponente;
	}

	public void setIdVistaComponente(Long idVistaComponente) {
		this.idVistaComponente = idVistaComponente;
	}

	public Long getModificadoPor() {
		return this.modificadoPor;
	}

	public void setModificadoPor(Long modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

}