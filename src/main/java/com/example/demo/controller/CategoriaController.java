package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<?> buscarCategorias() {
		List<Categoria> lista = categoriaService.buscarCategorias();
		return ResponseEntity.ok(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarCategoria(@PathVariable("id") int id) {
		Optional<Categoria> categoria = categoriaService.buscarCategoria(id);
		return ResponseEntity.ok(categoria);
	}
}
