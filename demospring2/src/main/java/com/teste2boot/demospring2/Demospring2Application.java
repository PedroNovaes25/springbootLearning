package com.teste2boot.demospring2;

import com.teste2boot.demospring2.repositories.CategoriaRepository;
import com.teste2boot.demospring2.resources.domain.Categoria;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demospring2Application implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(Demospring2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        
        
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
    }
}
