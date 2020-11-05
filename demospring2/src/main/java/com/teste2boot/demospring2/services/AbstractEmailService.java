package com.teste2boot.demospring2.services;

import com.teste2boot.demospring2.resources.domain.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements IEmailService{

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendOrderConfirmationEmail(Pedido pedidoObj) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(pedidoObj);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido pedidoObj){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(pedidoObj.getCliente().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Pedido confirmado! Código: " +  pedidoObj.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(pedidoObj.toString());
        return sm;
    }

   
}
