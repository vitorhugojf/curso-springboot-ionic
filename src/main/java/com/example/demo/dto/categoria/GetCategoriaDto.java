package com.example.demo.dto.categoria;

import java.util.Set;

public class GetCategoriaDto {

    private Integer id;
    private String nome;
    private String descricao;
    private Set<InformacaoProduto> produtos;

    public GetCategoriaDto() {
    }

    public GetCategoriaDto(Integer id, String nome, String descricao, Set<InformacaoProduto> produtos) {
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

    public Set<InformacaoProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<InformacaoProduto> produtos) {
        this.produtos = produtos;
    }
}

class InformacaoProduto {

    private Integer produtoId;
    private String produtoNome;
    private Double produtoPreco;

    public InformacaoProduto() {
    }

    public InformacaoProduto(Integer produtoId, String produtoNome, Double produtoPreco) {
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
        this.produtoPreco = produtoPreco;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public Double getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(Double produtoPreco) {
        this.produtoPreco = produtoPreco;
    }
}