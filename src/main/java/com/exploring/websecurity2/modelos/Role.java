package com.exploring.websecurity2.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to RolesPermiso
	@OneToMany(mappedBy="role")
	private List<RolesPermiso> rolesPermisos;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="roles")
	private List<User> users;

	public Role() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RolesPermiso> getRolesPermisos() {
		return this.rolesPermisos;
	}

	public void setRolesPermisos(List<RolesPermiso> rolesPermisos) {
		this.rolesPermisos = rolesPermisos;
	}

	public RolesPermiso addRolesPermiso(RolesPermiso rolesPermiso) {
		getRolesPermisos().add(rolesPermiso);
		rolesPermiso.setRole(this);

		return rolesPermiso;
	}

	public RolesPermiso removeRolesPermiso(RolesPermiso rolesPermiso) {
		getRolesPermisos().remove(rolesPermiso);
		rolesPermiso.setRole(null);

		return rolesPermiso;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}