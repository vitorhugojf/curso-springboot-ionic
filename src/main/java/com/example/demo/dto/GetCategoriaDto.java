package com.example.demo.dto;

import com.example.demo.domain.Produto;

import java.util.Set;

public class GetCategoriaDto {
    private String nome;
    private String descricao;
    private Set<GetProdutoDto> produtos;

    public GetCategoriaDto() {
    }

    public GetCategoriaDto(String nome, String descricao, Set<GetProdutoDto> produtos) {
        this.nome = nome;
        this.descricao = descricao;
        this.produtos = produtos;
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

    public Set<GetProdutoDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<GetProdutoDto> produtos) {
        this.produtos = produtos;
    }
}
