package com.teste2boot.demospring2.dto;

import com.teste2boot.demospring2.resources.domain.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable { //Serve para filtrar apenas os itens que quero
    private static final long serialVersion = 1L;

    private int id;
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj ) {
        id = obj.getId();
        nome = obj.getNome();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
