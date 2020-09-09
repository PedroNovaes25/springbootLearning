/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.resources.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.teste2boot.demospring2.resources.domain.enums.EstadoPagamento;
import javax.persistence.Entity;

/**
 *
 * @author guita
 */
@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento{
    
    private static final long serialVersionUID = 1L;
    
    private Integer numerosDeParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numerosDeParcelas) {
        super(id, estado, pedido);
        this.numerosDeParcelas = numerosDeParcelas;
    }

    public Integer getNumerosDeParcelas() {
        return numerosDeParcelas;
    }

    public void setNumerosDeParcelas(Integer numerosDeParcelas) {
        this.numerosDeParcelas = numerosDeParcelas;
    }

   
    
    
    
}
