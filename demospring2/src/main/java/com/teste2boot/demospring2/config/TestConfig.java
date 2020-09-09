package com.teste2boot.demospring2.config;

import com.teste2boot.demospring2.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test") // essa configuração só será usada quando o profile "test" estiver sendo chamado
public class TestConfig {

    @Autowired
    DbService dbService;


    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateTestDatabase();
        return true;
    }
}
