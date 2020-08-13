/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.resources;

import com.teste2boot.demospring2.resources.domain.Categoria;
import com.teste2boot.demospring2.services.CategoriaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guita
 */

@RestController //Classe controladora rest
@RequestMapping(value="/categorias") // ENDPOINT é como se fosse o endereço de url exemp(localhost:8080/categoria)
public class CategoriaResource {
 
    @Autowired
    private CategoriaService service;
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET) // agora o endpoint terá o /categorias + ID
    public ResponseEntity<?> find(@PathVariable Integer id){ //o ID da url passará para o id da variável
        
        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
