package io.github.PriAlves.clientes;

import io.github.PriAlves.clientes.model.entity.Cliente;
import io.github.PriAlves.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {

//
//    @Bean
//    public CommandLineRunner run (@Autowired ClienteRepository repository){ //@Autowired é annotations para injeção de dependencia, poderia estar acima do Bean se fosse utilizado em toda a classe
//        return args -> {
//            Cliente cliente = Cliente.builder().cpf("00000000000").nome("Fulano").build(); // forma de criação de cliente disponivel por conta do @builder na classe cliente
//            repository.save(cliente);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class, args);
    }
}
