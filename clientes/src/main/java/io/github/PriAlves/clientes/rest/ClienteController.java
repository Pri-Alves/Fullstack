package io.github.PriAlves.clientes.rest;

import io.github.PriAlves.clientes.model.entity.Cliente;
import io.github.PriAlves.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController //controller + responseBody
@RequestMapping ("/api/clientes") //mapear a URL base que será tratada dentro do controller
public class ClienteController {

    private final ClienteRepository repository;

    //como o controller so irá funcionar se o repository estiver funcionando, a dependencia é obrigatória, o correto é injetar via contrutor já na construção da classe
    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping //requisisão do tipo POST
    @ResponseStatus(HttpStatus.CREATED) //retornar o status created quando salvar um novo cliente no servidor
    public Cliente salvar ( @RequestBody Cliente cliente){ //@RequestBody para dizer que o novo cliente será passado por json no corpo da requisição
        return repository.save(cliente);
    }
}
