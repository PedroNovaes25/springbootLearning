/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.resources;

import com.teste2boot.demospring2.dto.ClienteDTO;
import com.teste2boot.demospring2.dto.ClienteNewDTO;
import com.teste2boot.demospring2.resources.domain.Cliente;
import com.teste2boot.demospring2.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author guita
 */
@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
    
    @Autowired
    private ClienteService service;
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> find(@PathVariable Integer id){
        Cliente obj = service.find(id);
        return ResponseEntity.ok(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDto) {  //transforma o json em objeto
        Cliente obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDTO, @PathVariable Integer id) {

        Cliente obj = service.fromDTO(objDTO);
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
    public ResponseEntity<List<ClienteDTO>> findAll() {

        List<Cliente> list = service.findAll();
        List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList()); // transforma
        //a lista de Cliente em uma lista de ClienteDTO
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findPage
            (
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                    @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                    @RequestParam(value = "direction", defaultValue = "ASC") String direction
            ) {
        Page<Cliente> list = service.findPage(page, linesPerPage, orderBy,direction);
        Page<ClienteDTO> listDTO = list.map(obj -> new ClienteDTO(obj)); // transforma
        //a lista de Cliente em uma lista de Cliente
        return ResponseEntity.ok().body(listDTO);
    }
}
