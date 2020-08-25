/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.resources;

import com.teste2boot.demospring2.dto.CategoriaDTO;
import com.teste2boot.demospring2.resources.domain.Categoria;
import com.teste2boot.demospring2.services.CategoriaService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;


/**
 * @author guita
 */

@RestController //Classe controladora rest
@RequestMapping(value = "/categorias") // ENDPOINT é como se fosse o endereço de url exemp(localhost:8080/categoria)
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET) // agora o endpoint terá o /categorias + ID
    public ResponseEntity<Categoria> find(@PathVariable Integer id) { //o ID da url passará para o id da variável

        Categoria obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDTO) { //transforma o json em objeto
        Categoria obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        //Criando o URI
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDTO, @PathVariable Integer id) {

        Categoria obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAll() {

        List<Categoria> list = service.findAll();
        List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList()); // transforma
        //a lista de categoria em uma lista de categoriaDTO
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<CategoriaDTO>> findPage
            (
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                    @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                    @RequestParam(value = "direction", defaultValue = "ASC") String direction
            ) {


        Page<Categoria> list = service.findPage(page, linesPerPage, orderBy,direction);
        Page<CategoriaDTO> listDTO = list.map(obj -> new CategoriaDTO(obj)); // transforma
        //a lista de categoria em uma lista de categoriaDTO
        return ResponseEntity.ok().body(listDTO);
    }
}
