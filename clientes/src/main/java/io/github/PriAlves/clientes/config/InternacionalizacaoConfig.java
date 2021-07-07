package io.github.PriAlves.clientes.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class InternacionalizacaoConfig {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages"); //o ResourceBundle ja entende qu
        // e messages esta em properties
        messageSource.setDefaultEncoding("ISO-8859-1"); //para reconhecer os caracteres brasileiros
        messageSource.setDefaultLocale(Locale.getDefault());
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean(){ //faz a interpolaçao/integração entre as mensagens e a nossa validação da especifição das validações do java (nome,cpf)
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
