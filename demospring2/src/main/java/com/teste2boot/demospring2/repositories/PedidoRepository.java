/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.repositories;

import com.teste2boot.demospring2.resources.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guita
 */
@Repository  //OBS: Camada de acesso a dados          //Nome da classe e tipo do Identificador()ID
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
