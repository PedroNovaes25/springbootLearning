package com.teste2boot.demospring2;

import com.teste2boot.demospring2.repositories.CategoriaRepository;
import com.teste2boot.demospring2.repositories.CidadeRepository;
import com.teste2boot.demospring2.repositories.ClienteRepository;
import com.teste2boot.demospring2.repositories.EnderecoRepository;
import com.teste2boot.demospring2.repositories.EstadoRepository;
import com.teste2boot.demospring2.repositories.ProdutoRepository;
import com.teste2boot.demospring2.resources.domain.Categoria;
import com.teste2boot.demospring2.resources.domain.Cidade;
import com.teste2boot.demospring2.resources.domain.Cliente;
import com.teste2boot.demospring2.resources.domain.Endereco;
import com.teste2boot.demospring2.resources.domain.Estado;
import com.teste2boot.demospring2.resources.domain.Produto;
import com.teste2boot.demospring2.resources.domain.enums.TipoCliente;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demospring2Application implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;
            
    public static void main(String[] args) {
        SpringApplication.run(Demospring2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        ///---------------------------------------------
        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        ///---------------------------------------------
        
        Cliente cli1 = new Cliente(null, "Maria Silva", "MariaSilva@gmail.com", "488.801.858-50", TipoCliente.PessoaFisica);

        cli1.getTelefones().addAll(Arrays.asList("46492103", "49485503"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38450950", cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 803", "Jardim", "38450950", cli1, c2);
        
        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
        
        
        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));
        
        ///---------------------------------------------
        

    }
}
