package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@GetMapping
	public ResponseEntity<?> buscarCategorias() {
		Categoria c1 = new Categoria(1, "Informatica");
		Categoria c2 = new Categoria(2, "Escritório");

		List<Categoria> lista = new ArrayList<>();
		lista.add(c1);
		lista.add(c2);
		return ResponseEntity.ok(lista);
	}

	@GetMapping(value = "/{id}")
	public String buscarCategoria(@PathVariable("id") int id) {
		return "Id " + id;
	}
}
