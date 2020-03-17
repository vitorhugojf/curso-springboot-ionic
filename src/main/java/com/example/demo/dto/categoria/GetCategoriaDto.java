package com.example.demo.dto.categoria;

import com.example.demo.dto.produto.ProdutoInfosDto;

import java.util.Set;

public class GetCategoriaDto {

    private Integer id;
    private String nome;
    private String descricao;
    private Set<ProdutoInfosDto> produtos;

    public GetCategoriaDto() {
    }

    public GetCategoriaDto(Integer id, String nome, String descricao, Set<ProdutoInfosDto> produtos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.produtos = produtos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<ProdutoInfosDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ProdutoInfosDto> produtos) {
        this.produtos = produtos;
    }
}