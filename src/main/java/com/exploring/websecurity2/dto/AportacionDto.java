package com.exploring.websecurity2.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.exploring.websecurity2.modelos.Asociado;

public class AportacionDto {
	private Integer id;
	private Date fecha;
	private BigDecimal monto;
//	private Asociado asociado;
	private Integer asociadoId;
	private String asociadoPersonaNombres;
	private String asociadoPersonaApellidos;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public Integer getAsociadoId() {
		return asociadoId;
	}
	public void setAsociadoId(Integer asociadoId) {
		this.asociadoId = asociadoId;
	}
	public String getAsociadoPersonaNombres() {
		return asociadoPersonaNombres;
	}
	public void setAsociadoPersonaNombres(String asociadoPersonaNombres) {
		this.asociadoPersonaNombres = asociadoPersonaNombres;
	}
	public String getAsociadoPersonaApellidos() {
		return asociadoPersonaApellidos;
	}
	public void setAsociadoPersonaApellidos(String asociadoPersonaApellidos) {
		this.asociadoPersonaApellidos = asociadoPersonaApellidos;
	}
	
}
