/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.services;

import com.teste2boot.demospring2.repositories.PedidoRepository;
import com.teste2boot.demospring2.resources.domain.Pedido;
import com.teste2boot.demospring2.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guita
 */

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repo;
    
    public Pedido buscar(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        
        return obj.orElseThrow(()-> new ObjectNotFoundException
        (
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()
        ));
       
    }
    
}
