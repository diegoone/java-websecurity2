package com.exploring.websecurity2.seguridad.servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exploring.websecurity2.modelos.User;
import com.exploring.websecurity2.proyecciones.PermisoView;
import com.exploring.websecurity2.repositorios.UserRepository;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		List<PermisoView> permisos = userRepository.getAllPermisosFor(username);
		return UserDetailsImpl.build(user, permisos);
	}
}