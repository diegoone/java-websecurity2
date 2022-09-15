package com.exploring.websecurity2.repositorios;

import org.springframework.stereotype.Repository;

import com.exploring.websecurity2.modelos.ERole;

import model.Role;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}