package com.exploring.websecurity2.repositorios;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exploring.websecurity2.modelos.Aportacion;
import com.exploring.websecurity2.modelos.Asociado;
@Repository
public interface AportacionRepository extends JpaRepository<Aportacion, Integer>{
	public List<Aportacion> findByAsociado(Asociado asociado, Sort sort); 
}
