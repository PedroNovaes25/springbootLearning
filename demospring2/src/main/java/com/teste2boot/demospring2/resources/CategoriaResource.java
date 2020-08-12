/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.resources;

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
    public String listar(){
        return "REST está funcionando!";
    }
}
