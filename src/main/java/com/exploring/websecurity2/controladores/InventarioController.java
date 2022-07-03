package com.exploring.websecurity2.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/inventario")
public class InventarioController {
	@GetMapping("/compras/listaCompras")
	@PreAuthorize("hasAuthority('compras.listar')")
	public ResponseEntity<?> getAllCompras() {
		return ResponseEntity.ok("Tiene permisos para ver compras");
	}
	@GetMapping("/ventas/listaVentas")
	@PreAuthorize("hasAuthority('ventas.listar')")
	public ResponseEntity<?> getAllVentas() {
		return ResponseEntity.ok("Tiene permisos para ver ventas");
	}
}
