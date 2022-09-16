package com.exploring.websecurity2.repositorios;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exploring.websecurity2.modelos.User;
import com.exploring.websecurity2.proyecciones.PermisoView;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	//nota que debido a que rolPermisos es una lista, no se le puede hacer un join hasta permiso 
	//es necesario crearle un alias (rp en este caso) y luego hacer el join con permiso, 
	//de lo contrario dara un error de dereferenciación
	@Query("select "
			+ "p.alias as alias, "
			+ "p.nombreComponente as componenteVista "
			+ "from User u join u.roles r join r.rolPermisos rp join rp.permiso p "
			+ "where u.username = ?1")
	List<PermisoView> getAllPermisosFor(String username);
}