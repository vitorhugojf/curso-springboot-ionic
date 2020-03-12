package com.example.demo.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@GetMapping
	public String listartodos() {
		return "todos";
	}

	@GetMapping(value = "/{id}")
	public String listar(@PathVariable("id") int id, @RequestParam(required = false) String valor) {
			return "Id " + id + " e Valor " + valor;
	}
}
