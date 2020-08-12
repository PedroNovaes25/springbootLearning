/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.resources;

import com.teste2boot.demospring2.resources.domain.Categoria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guita
 */

@RestController //Classe controladora rest
@RequestMapping(value="/categorias") // é como se fosse o endereço de url localhost:8080/categoria
public class CategoriaResource {
 
    @RequestMapping(method=RequestMethod.GET)
    public List<Categoria> listar(){
        
        Categoria cat1 = new Categoria(1, "Informática");
        Categoria cat2 = new Categoria(2, "Escritório");
        
        List<Categoria> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);
        
        return lista;
    }
}
