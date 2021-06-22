package io.github.PriAlves.clientes.model.repository;

import io.github.PriAlves.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
