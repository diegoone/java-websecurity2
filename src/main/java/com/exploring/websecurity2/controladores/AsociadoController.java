package com.exploring.websecurity2.controladores;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.exploring.websecurity2.dto.AsociadoDto;
import com.exploring.websecurity2.dto.UserDTO;
import com.exploring.websecurity2.modelos.ActividadAsociado;
import com.exploring.websecurity2.modelos.Asociado;
import com.exploring.websecurity2.modelos.Persona;
import com.exploring.websecurity2.payload.request.LoginRequest;
import com.exploring.websecurity2.repositorios.ActividadAsociadoRepository;
import com.exploring.websecurity2.repositorios.AsociadoRepository;
import com.exploring.websecurity2.repositorios.PersonaRepository;
import com.exploring.websecurity2.seguridad.jwt.JwtUtils;
import com.exploring.websecurity2.seguridad.jwt.ModeloToken;

import io.jsonwebtoken.lang.Assert;

@CrossOrigin(origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/api/asociado")
public class AsociadoController {
	@Autowired
	private JwtUtils jwtUtils; 
	@Autowired
	private AsociadoRepository asociadoRepo;
	@Autowired
	private PersonaRepository personaRepo;
	@Autowired
	private ActividadAsociadoRepository actividadAsociadoRepo;
    public AsociadoController(
    		) {
	}
    public static HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
        return servletRequest;
    }
	/*
	public void initialize() {
		String jwt = request.getHeader("Authorization");
		this.userId = jwtUtils.getUserNameFromJwtToken(jwt);
	}
	*/
	@PostMapping("test-headers")
	public ResponseEntity<?> testHeaders(@Valid @RequestBody Asociado asociado) {
		HttpServletRequest req = getCurrentRequest();
    	String userId = jwtUtils.getUserNameFromJwtToken(jwtUtils.parseJwt(req));
		return null;
    }
    
	@Transactional
	@PostMapping("crear")
	public ResponseEntity<?> crear(
			@RequestHeader Map<String, String> headers, 
			@Valid @RequestBody Asociado asociado) {
		ModeloToken modeloToken = jwtUtils.getModeloToken(headers);
		ActividadAsociado actividad = new ActividadAsociado();
		actividad.setFechaIngreso(new Date());
		actividad.setFechaRetiro(null);
		actividad.setMovitoRetiro(null);
		asociado.setActividadAsociados(List.of(actividad));
		
		personaRepo.save(asociado.getPersona());
		
		asociado.setCreadoEn(new Date());
		asociado.setCreadoPor(modeloToken.userName);
		
		asociadoRepo.save(asociado);
		
		actividad.setAsociado(asociado);
		actividadAsociadoRepo.save(actividad);
		
		return ResponseEntity.ok("se registro correctamente");
	}
	@Transactional
	@PutMapping("actualizar/{idAsociado}")
	public ResponseEntity<?> actualizar(
			@RequestHeader Map<String, String> headers, 
			@Valid @RequestBody Asociado asociado, 
			@PathVariable int idAsociado) {
		Optional<Asociado> existente = asociadoRepo.findById(idAsociado);
		if(!existente.isPresent()) {
			return ResponseEntity
			.status(HttpStatus.NOT_FOUND)
			.body("no se encontró");
		}
		Persona personaBD = existente.get().getPersona(); 
		if(asociado.getPersona() == null || personaBD.getId() != asociado.getPersona().getId()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Operación no permitida");
		}
		personaRepo.save(asociado.getPersona());
		return ResponseEntity.ok("se actualizó correctamente");
	}
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		ModelMapper modelMapper = new ModelMapper();
		List<Asociado> lista = asociadoRepo.findAll();
		List<AsociadoDto> listaDto = lista.stream().map( asociado -> 
			modelMapper.map(asociado, AsociadoDto.class)
		).collect(Collectors.toList());
		return ResponseEntity.ok(listaDto);
	}
}
