package com.exploring.websecurity2.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permisos database table.
 * 
 */
@Entity
@Table(name="permisos")
@NamedQuery(name="Permiso.findAll", query="SELECT p FROM Permiso p")
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String alias;

	private String name;

	@Column(name="nombre_componente")
	private String nombreComponente;

	//bi-directional many-to-one association to RolesPermiso
	@OneToMany(mappedBy="permiso")
	private List<RolesPermiso> rolesPermisos;

	public Permiso() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNombreComponente() {
		return this.nombreComponente;
	}

	public void setNombreComponente(String nombreComponente) {
		this.nombreComponente = nombreComponente;
	}

	public List<RolesPermiso> getRolesPermisos() {
		return this.rolesPermisos;
	}

	public void setRolesPermisos(List<RolesPermiso> rolesPermisos) {
		this.rolesPermisos = rolesPermisos;
	}

	public RolesPermiso addRolesPermiso(RolesPermiso rolesPermiso) {
		getRolesPermisos().add(rolesPermiso);
		rolesPermiso.setPermiso(this);

		return rolesPermiso;
	}

	public RolesPermiso removeRolesPermiso(RolesPermiso rolesPermiso) {
		getRolesPermisos().remove(rolesPermiso);
		rolesPermiso.setPermiso(null);

		return rolesPermiso;
	}

}