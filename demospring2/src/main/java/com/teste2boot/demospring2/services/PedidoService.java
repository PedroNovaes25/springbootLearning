/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.services;

import com.teste2boot.demospring2.repositories.ItemPedidoRepository;
import com.teste2boot.demospring2.repositories.PagamentoRepository;
import com.teste2boot.demospring2.repositories.PedidoRepository;
import com.teste2boot.demospring2.repositories.ProdutoRepository;
import com.teste2boot.demospring2.resources.domain.ItemPedido;
import com.teste2boot.demospring2.resources.domain.PagamentoComBoleto;
import com.teste2boot.demospring2.resources.domain.Pedido;
import com.teste2boot.demospring2.resources.domain.enums.EstadoPagamento;
import com.teste2boot.demospring2.services.exceptions.ObjectNotFoundException;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guita
 */

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repo;

    @Autowired
    private  BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    ClienteService clienteService;
    
    public Pedido find(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        
        return obj.orElseThrow(()-> new ObjectNotFoundException
        (
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()
        ));
       
    }

    public Pedido insert(Pedido obj) {
        obj.setId(null);
        obj.setInstance(new Date());
        obj.setCliente(clienteService.find(obj.getCliente().getId()));
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto){
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = repo.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()){
            ip.setDesconto(0.0);
            ip.setProduto(produtoService.find(ip.getproduto().getId()));
            ip.setPreco(ip.getproduto().getPreco());
            ip.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
        System.out.println(obj);
        return obj;


    }
}
