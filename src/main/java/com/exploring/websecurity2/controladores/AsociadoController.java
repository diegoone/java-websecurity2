package com.exploring.websecurity2.controladores;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploring.websecurity2.modelos.ActividadAsociado;
import com.exploring.websecurity2.modelos.Asociado;
import com.exploring.websecurity2.modelos.Persona;
import com.exploring.websecurity2.payload.request.LoginRequest;
import com.exploring.websecurity2.repositorios.ActividadAsociadoRepository;
import com.exploring.websecurity2.repositorios.AsociadoRepository;
import com.exploring.websecurity2.repositorios.PersonaRepository;
import com.exploring.websecurity2.seguridad.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/api/asociado")
public class AsociadoController {
	private HttpServletRequest request;
	//private JwtUtils jwtUtils;
	@Autowired
	private AsociadoRepository asociadoRepo;
	@Autowired
	private PersonaRepository personaRepo;
	@Autowired
	private ActividadAsociadoRepository actividadAsociadoRepo;
    String userId;
	@Autowired
    public AsociadoController(HttpServletRequest request) {
		this.request = request;
		//String jwt = request.getHeader("Authorization");
		//this.userId = jwtUtils.getUserNameFromJwtToken(jwt);
	}
	@Transactional
	@PostMapping("crear")
	public ResponseEntity<?> crear(@Valid @RequestBody Asociado asociado) {
		ActividadAsociado actividad = new ActividadAsociado();
		actividad.setFechaIngreso(new Date());
		actividad.setFechaRetiro(null);
		actividad.setMovitoRetiro(null);
		asociado.setActividadAsociados(List.of(actividad));
		personaRepo.save(asociado.getPersona());
		asociadoRepo.save(asociado);
		actividad.setAsociado(asociado);
		actividadAsociadoRepo.save(actividad);
		return ResponseEntity.ok("se registro correctamente");
	}
}
