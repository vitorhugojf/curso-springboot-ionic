package com.example.demo.controller;

import java.util.Set;

import com.example.demo.dto.AlterCategoriaDto;
import com.example.demo.dto.CreateCategoriaDto;
import com.example.demo.dto.GetCategoriaDto;

import com.example.demo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity buscarTodos() {
        Set<GetCategoriaDto> lista = categoriaService.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity buscar(@PathVariable("id") Integer id) {
        GetCategoriaDto categoria = categoriaService.buscar(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping()
    public ResponseEntity criar(@RequestBody CreateCategoriaDto categoria) {
        Categoria result = categoriaService.criar(categoria);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity alterar(@RequestBody AlterCategoriaDto categoria) {
        Categoria result = categoriaService.alterar(categoria);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletar(@PathVariable("id") Integer id) {
        categoriaService.deletar(id);
        return ResponseEntity.ok("Categoria com Id " + id + " deletada com sucesso.");
    }
}
