package com.exploring.websecurity2.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploring.websecurity2.modelos.ActividadAsociado;
import com.exploring.websecurity2.modelos.Asociado;
import com.exploring.websecurity2.modelos.Persona;
import com.exploring.websecurity2.payload.request.LoginRequest;
import com.exploring.websecurity2.repositorios.AsociadoRepository;
import com.exploring.websecurity2.seguridad.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/api/asociado")
public class AsociadoController {
    /*
	private HttpServletRequest request;
	//private JwtUtils jwtUtils;
	@Autowired
	private AsociadoRepository asociadoRepo;
    String userId;
	@Autowired
    public AsociadoController(HttpServletRequest request) {
		this.request = request;
		//String jwt = request.getHeader("Authorization");
		//this.userId = jwtUtils.getUserNameFromJwtToken(jwt);
	}
	@PostMapping("crear")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody Asociado asociado) {
		//asociadoRepo.save(asociado);
		Asociado response = new Asociado();
		response.setPersona(new Persona());
		ActividadAsociado actividadAsociado = new ActividadAsociado();
		response.setActividadAsociados(List.of(actividadAsociado));
		return ResponseEntity.ok(response);
	}
	*/
}
