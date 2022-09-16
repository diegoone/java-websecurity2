	package com.exploring.websecurity2.modelos;
	import java.util.HashSet;
	import java.util.Set;

	import javax.persistence.*;
	@Entity
	@Table(name = "roles")
	public class Role {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Column(length = 20)
		private String name;
		@OneToMany(mappedBy = "rol", 
				cascade = CascadeType.ALL, 
				orphanRemoval = true
		)
		private Set<RolPermiso> rolPermisos = new HashSet<>();
		public Role() {
		}
		public Role(String name) {
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Set<RolPermiso> getRolPermisos() {
			return rolPermisos;
		}
		public void setRolPermisos(Set<RolPermiso> rolPermisos) {
			this.rolPermisos = rolPermisos;
		}
		
	}
