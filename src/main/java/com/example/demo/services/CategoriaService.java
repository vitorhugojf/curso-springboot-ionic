package com.example.demo.services;

import com.example.demo.domain.Categoria;
import com.example.demo.dto.AlterCategoriaDto;
import com.example.demo.dto.CreateCategoriaDto;
import com.example.demo.dto.GetCategoriaDto;
import com.example.demo.extras.ObjectMapperUtils;
import com.example.demo.extras.ObjectNotFoundException;
import com.example.demo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Set<GetCategoriaDto> buscarTodos() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return ObjectMapperUtils.mapAll(categorias, GetCategoriaDto.class);
    }

    public GetCategoriaDto buscar(Integer id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não existe nenhuma categoria com o Id " + id + " na base de dados.", Categoria.class.getName()));
        return ObjectMapperUtils.map(categoria, GetCategoriaDto.class);
    }

    public Categoria criar(CreateCategoriaDto categoria) {
        return categoriaRepository.save(ObjectMapperUtils.map(categoria, Categoria.class));
    }

    public Categoria alterar(AlterCategoriaDto categoria) {
        Categoria categoriaDesatualizada = categoriaRepository.findById(categoria.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Não existe nenhuma categoria com o Id " + categoria.getId() + " na base de dados.", Categoria.class.getName()));
        categoriaDesatualizada.setDescricao(categoria.getDescricao());
        return categoriaRepository.save(categoriaDesatualizada);
    }

    public void deletar(Integer id) {
        categoriaRepository.deleteById(id);
    }

}
