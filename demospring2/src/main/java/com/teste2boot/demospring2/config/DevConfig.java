package com.teste2boot.demospring2.config;

import com.teste2boot.demospring2.services.DbService;
import com.teste2boot.demospring2.services.IEmailService;
import com.teste2boot.demospring2.services.SmtpEmalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev") // essa configuração só será usada quando o profile "test" estiver sendo chamado
public class DevConfig {

    @Autowired
    private DbService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDatabase() throws ParseException {

        if (!"create".equals(strategy)) {
            return false;
        }

        dbService.instantiateTestDatabase();
        return true;
    }

    @Bean
    public IEmailService emailService() {
        return new SmtpEmalService();
    }
}
