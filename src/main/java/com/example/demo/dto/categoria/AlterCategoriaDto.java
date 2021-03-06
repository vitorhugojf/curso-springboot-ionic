package com.example.demo.dto.categoria;

import java.io.Serializable;

public class AlterCategoriaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String descricao;

    public AlterCategoriaDto(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
