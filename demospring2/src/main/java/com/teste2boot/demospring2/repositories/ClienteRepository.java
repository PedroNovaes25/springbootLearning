/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.repositories;

import com.teste2boot.demospring2.resources.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author guita
 */
@Repository  //OBS: Camada de acesso a dados          //Nome da classe e tipo do Identificador()ID
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    @Transactional(readOnly = true)
    Cliente findByEmail(String email); //indica uma busca no BD por email
}
