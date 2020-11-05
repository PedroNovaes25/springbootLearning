package com.teste2boot.demospring2.services;

import com.teste2boot.demospring2.resources.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface IEmailService {

    void sendOrderConfirmationEmail(Pedido pedido);

    void sendEmail(SimpleMailMessage msg);
}
