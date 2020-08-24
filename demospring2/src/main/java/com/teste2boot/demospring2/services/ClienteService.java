/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.services;

import com.teste2boot.demospring2.repositories.ClienteRepository;
import com.teste2boot.demospring2.resources.domain.Cliente;
import com.teste2boot.demospring2.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guita
 */
@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository repo;
    
    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        
       return obj.orElseThrow(() -> new ObjectNotFoundException
            (   //Menssagem                                       //Causa (Nome da classe)
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())
            );
        
    }
}
