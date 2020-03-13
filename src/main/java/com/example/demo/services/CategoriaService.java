package com.example.demo.services;

import com.example.demo.domain.Categoria;
import com.example.demo.dto.AlterCategoriaDto;
import com.example.demo.dto.CreateCategoriaDto;
import com.example.demo.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria buscar(Integer id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe nenhum usuário com o Id " + id + " na base de dados."));
    }

    public Categoria criar(CreateCategoriaDto categoria) {
        return categoriaRepository.save(modelMapper.map(categoria, Categoria.class));
    }

    public Categoria alterar(AlterCategoriaDto categoria) {
        Categoria categoriaDesatualizada = categoriaRepository.findById(categoria.getId())
                .orElseThrow(() -> new RuntimeException("Não existe nenhum usuário com o Id " + categoria.getId() + " na base de dados."));
        categoriaDesatualizada.setDescricao(categoria.getDescricao());
        return categoriaRepository.save(categoriaDesatualizada);
    }

    public void deletar(Integer id){
        categoriaRepository.deleteById(id);
    }

}
