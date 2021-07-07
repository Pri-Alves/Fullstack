package io.github.PriAlves.clientes.rest;

import io.github.PriAlves.clientes.model.entity.Cliente;
import io.github.PriAlves.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

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
    public Cliente salvar ( @RequestBody @Valid Cliente cliente){ //@RequestBody para dizer que o novo cliente será passado por json no corpo da requisição
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id){ //@PathVariable("id") informar o ("id") é opcional porque o nome da url é igual ao da variavel
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); //ele busca por id e se estiver ok returna 200, caso nao encontre retorna um 404 not found
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204 código de sucesso
    public void deletar( @PathVariable Integer id) {
        //repository.deleteById(id); seria uma opção mais curta porem impede as tratativas de exception
        repository
                .findById(id)
                .map( cliente -> { //map mapeia um objeto para fazer algo com ele, nesse casl mapeia o cliente para podermos deleta-lo
                    repository.delete(cliente);
                    return Void.TYPE; //o retorno será void para não ficar sem retorno, pois o retorno nulo pode gerar uma exception
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); //ele busca por id e se estiver ok returna 200, caso nao encontre retorna um 404 not found
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204 código de sucesso
    public void atualizar( @PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        repository
                .findById(id)
                .map( cliente -> {
                    clienteAtualizado.setId(cliente.getId());
                    return repository.save(clienteAtualizado); //save salva o cliente atualizado
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); //ele busca por id e se estiver ok returna 200, caso nao encontre retorna um 404 not found
    }
}
