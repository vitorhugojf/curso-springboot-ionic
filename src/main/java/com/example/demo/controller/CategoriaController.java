package com.example.demo.controller;

import com.example.demo.domain.Categoria;
import com.example.demo.dto.categoria.AlterCategoriaDto;
import com.example.demo.dto.categoria.CreateCategoriaDto;
import com.example.demo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity buscarTodos() {
        return ResponseEntity.ok(categoriaService.buscarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity buscar(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(categoriaService.buscar(id));
    }

    @PostMapping()
    public ResponseEntity criar(@RequestBody CreateCategoriaDto categoria) {
        Categoria novaCategoria = categoriaService.criar(categoria);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaCategoria.getId()).toUri()).build();
    }

    @PutMapping
    public ResponseEntity alterar(@RequestBody AlterCategoriaDto categoria) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletar(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(categoriaService.deletar(id));
    }
}
