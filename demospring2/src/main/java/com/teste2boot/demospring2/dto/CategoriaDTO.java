package com.teste2boot.demospring2.dto;

import com.teste2boot.demospring2.resources.domain.Categoria;
import org.hibernate.validator.constraints.Length;


import java.io.Serializable;

import javax.validation.constraints.NotNull;
//import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.NotEmpty;


public class CategoriaDTO implements Serializable { //Serve para filtrar apenas os itens que quero
    private static final long serialVersion = 1L;

    private int id;

//    @NotEmpty(message="Preenchimento obrigatório")

    //    @NotNull(message="Preenchimento obrigatório")
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;


    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj) {
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
