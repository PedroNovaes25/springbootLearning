/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.services;

import com.teste2boot.demospring2.dto.ClienteDTO;
import com.teste2boot.demospring2.dto.ClienteNewDTO;
import com.teste2boot.demospring2.repositories.CidadeRepository;
import com.teste2boot.demospring2.repositories.ClienteRepository;
import com.teste2boot.demospring2.repositories.EnderecoRepository;
import com.teste2boot.demospring2.resources.domain.Cidade;
import com.teste2boot.demospring2.resources.domain.Cliente;
import com.teste2boot.demospring2.resources.domain.Endereco;
import com.teste2boot.demospring2.resources.domain.enums.TipoCliente;
import com.teste2boot.demospring2.services.exceptions.DataIntegrityException;
import com.teste2boot.demospring2.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author guita
 */
@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository repo;

    @Autowired
    EnderecoRepository enderecoRepository;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        
       return obj.orElseThrow(() -> new ObjectNotFoundException
            (   //Menssagem                                       //Causa (Nome da classe)
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())
            );
    }

    @Transactional
    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = repo.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    public Cliente update(Cliente obj){
       Cliente newObj = find(obj.getId());
       updateData(newObj, obj);

        return repo.save(newObj);
    }

    private void updateData(Cliente newObj, Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionadas");
        }
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        return new Cliente(objDto.getId(), objDto.getNome(),objDto.getEmail(), null,null);
    }

    public Cliente fromDTO(ClienteNewDTO objDto) {
        Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
        Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
        Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
        cli.getEnderecos().add(end);
        cli.getTelefones().add(objDto.getTelefone1());
        if (objDto.getTelefone2()!=null) {
            cli.getTelefones().add(objDto.getTelefone2());
        }
        if (objDto.getTelefone3()!=null) {
            cli.getTelefones().add(objDto.getTelefone3());
        }
        return cli;
    }


    public List<Cliente> findAll() {
        return repo.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);
        return repo.findAll(pageRequest);
    }


}
