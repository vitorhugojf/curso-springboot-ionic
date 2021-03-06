package com.example.demo.dto.produto;

import java.io.Serializable;

public class ProdutoInfosDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer produtoId;
    private String produtoNome;
    private Double produtoPreco;

    public ProdutoInfosDto() {
    }

    public ProdutoInfosDto(Integer produtoId, String produtoNome, Double produtoPreco) {
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