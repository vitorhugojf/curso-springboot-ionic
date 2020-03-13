package com.example.demo;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void init() {
        Categoria cat1 = new Categoria("Informática", "Produtos de informática em geral");
        Categoria cat2 = new Categoria("Escritório", "Produtos de Escritório em geral");

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
    }
}

