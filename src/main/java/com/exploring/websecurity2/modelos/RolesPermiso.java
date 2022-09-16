package com.exploring.websecurity2.modelos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the roles_permisos database table.
 * 
 */
@Entity
@Table(name="roles_permisos")
@NamedQuery(name="RolesPermiso.findAll", query="SELECT r FROM RolesPermiso r")
public class RolesPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Permiso
	@ManyToOne
	@JoinColumn(name="id_permiso")
	private Permiso permiso;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Role role;

	public RolesPermiso() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Permiso getPermiso() {
		return this.permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}