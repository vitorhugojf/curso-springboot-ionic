package com.example.demo.dto.categoria;

import java.io.Serializable;

public class CreateCategoriaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String descricao;

    public CreateCategoriaDto() {
    }

    public CreateCategoriaDto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
