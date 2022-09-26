package com.exploring.websecurity2.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.exploring.websecurity2.modelos.ActividadAsociado;
import com.exploring.websecurity2.modelos.Aportacion;
import com.exploring.websecurity2.modelos.Persona;

public class AsociadoDto {
	public Integer id;
	public Date creadoEn;
	public String creadoPor;
	public Integer idPersona;
	public String personaApellidos;
	public String personaCodigoUbicacion;
	public String personaDui;
	public Date personaFechaNacimiento;
	public String personaGenero;
	public String personaNombres;
	public String personaOcupacion;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(Date creadoEn) {
		this.creadoEn = creadoEn;
	}
	public String getCreadoPor() {
		return creadoPor;
	}
	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public String getPersonaApellidos() {
		return personaApellidos;
	}
	public void setPersonaApellidos(String personaApellidos) {
		this.personaApellidos = personaApellidos;
	}
	public String getPersonaCodigoUbicacion() {
		return personaCodigoUbicacion;
	}
	public void setPersonaCodigoUbicacion(String personaCodigoUbicacion) {
		this.personaCodigoUbicacion = personaCodigoUbicacion;
	}
	public String getPersonaDui() {
		return personaDui;
	}
	public void setPersonaDui(String personaDui) {
		this.personaDui = personaDui;
	}
	public Date getPersonaFechaNacimiento() {
		return personaFechaNacimiento;
	}
	public void setPersonaFechaNacimiento(Date personaFechaNacimiento) {
		this.personaFechaNacimiento = personaFechaNacimiento;
	}
	public String getPersonaGenero() {
		return personaGenero;
	}
	public void setPersonaGenero(String personaGenero) {
		this.personaGenero = personaGenero;
	}
	public String getPersonaNombres() {
		return personaNombres;
	}
	public void setPersonaNombres(String personaNombres) {
		this.personaNombres = personaNombres;
	}
	public String getPersonaOcupacion() {
		return personaOcupacion;
	}
	public void setPersonaOcupacion(String personaOcupacion) {
		this.personaOcupacion = personaOcupacion;
	}
	
	
}
