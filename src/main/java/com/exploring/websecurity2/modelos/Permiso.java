package com.exploring.websecurity2.modelos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "permisos")
public class Permiso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//leer lista personas
		private String name;
		//personas.listar
		private String alias;
		//componente ListaPersonas
		private String nombreComponente;
		@OneToMany(
				mappedBy = "permiso", 
				cascade = CascadeType.ALL, 
				orphanRemoval = true
		)
		private Set<RolPermiso> RolPermiso = new HashSet<RolPermiso>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<RolPermiso> getRolPermiso() {
		return RolPermiso;
	}
	public void setRolPermiso(Set<RolPermiso> rolPermiso) {
		RolPermiso = rolPermiso;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getNombreComponente() {
		return nombreComponente;
	}
	public void setNombreComponente(String nombreComponente) {
		this.nombreComponente = nombreComponente;
	}
}
