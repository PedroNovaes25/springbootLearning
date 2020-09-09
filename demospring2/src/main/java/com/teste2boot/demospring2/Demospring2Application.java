package com.teste2boot.demospring2;

import com.teste2boot.demospring2.repositories.CategoriaRepository;
import com.teste2boot.demospring2.repositories.CidadeRepository;
import com.teste2boot.demospring2.repositories.ClienteRepository;
import com.teste2boot.demospring2.repositories.EnderecoRepository;
import com.teste2boot.demospring2.repositories.EstadoRepository;
import com.teste2boot.demospring2.repositories.ItemPedidoRepository;
import com.teste2boot.demospring2.repositories.PagamentoRepository;
import com.teste2boot.demospring2.repositories.PedidoRepository;
import com.teste2boot.demospring2.repositories.ProdutoRepository;
import com.teste2boot.demospring2.resources.domain.Categoria;
import com.teste2boot.demospring2.resources.domain.Cidade;
import com.teste2boot.demospring2.resources.domain.Cliente;
import com.teste2boot.demospring2.resources.domain.Endereco;
import com.teste2boot.demospring2.resources.domain.Estado;
import com.teste2boot.demospring2.resources.domain.ItemPedido;
import com.teste2boot.demospring2.resources.domain.Pagamento;
import com.teste2boot.demospring2.resources.domain.PagamentoComBoleto;
import com.teste2boot.demospring2.resources.domain.PagamentoComCartao;
import com.teste2boot.demospring2.resources.domain.Pedido;
import com.teste2boot.demospring2.resources.domain.Produto;
import com.teste2boot.demospring2.resources.domain.enums.EstadoPagamento;
import com.teste2boot.demospring2.resources.domain.enums.TipoCliente;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demospring2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Demospring2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
