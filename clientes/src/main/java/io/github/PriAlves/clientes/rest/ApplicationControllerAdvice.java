package io.github.PriAlves.clientes.rest;

import io.github.PriAlves.clientes.rest.exception.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleValidationErros(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult(); //tem o resultado da validação
        List<String> messages = bindingResult.getAllErrors() //getallerrors é um array de erros
                .stream() //pega uma stream de errors
                .map( objectError -> objectError.getDefaultMessage()) //map para transformar tipos, nesse caso de object errors para string
                .collect(Collectors.toList()); //transforma o stream de streams criado acima para uma lista/array de streams
        return new ApiErrors(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex){
        String mensagemErro = ex.getMessage();
        HttpStatus codigoStatus = ex.getStatus();
        ApiErrors apiErrors = new ApiErrors(mensagemErro);
        return new ResponseEntity(apiErrors, codigoStatus);
    }
}
