package io.github.PriAlves.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter@Setter
@NoArgsConstructor //para manter um construtor sem argumentos
@AllArgsConstructor //gera um construtor com todos os argumentos
@Builder //acesso ao padrão builder de ciente para criar um cliente de forma mais facil
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist // executa esse método antes de persistir no BD
    public void prePersist(){
        setDataCadastro(LocalDate.now()); //data de cadastro atual
    }
}
