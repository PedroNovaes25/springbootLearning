/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.services;

import com.teste2boot.demospring2.repositories.CategoriaRepository;
import com.teste2boot.demospring2.resources.domain.Categoria;
import com.teste2boot.demospring2.services.exceptions.DataIntegrityException;
import com.teste2boot.demospring2.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author guita
 */
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException
            (   //Menssagem                                       //Causa (Nome da classe)
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())
            );
    }
    
    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj){
        find(obj.getId());
        return repo.save(obj);
    }


    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produto");
        }
    }
}
