package com.exploring.websecurity2.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exploring.websecurity2.modelos.Asociado;
import com.exploring.websecurity2.modelos.Persona;
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
