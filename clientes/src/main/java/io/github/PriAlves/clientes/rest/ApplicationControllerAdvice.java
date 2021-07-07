package io.github.PriAlves.clientes.rest;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleValidationErros(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult(); //tem o resultado da validação
        List<String> messages = bindingResult.getAllErrors() //getallerrors é um array de erros
                .stream() //pega uma stream de errors
                .map( objectError -> objectError.getDefaultMessage()) //map para transformar tipos, nesse caso de object errors para string
                .collect(Collectors.toList()); //transforma o stream de streams criado acima para uma lista/array de streams
    }
}
