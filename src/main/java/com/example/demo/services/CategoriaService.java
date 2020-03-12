package com.example.demo.services;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarCategorias(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarCategoria(int id){
        return categoriaRepository.findById(id);
    }
}
