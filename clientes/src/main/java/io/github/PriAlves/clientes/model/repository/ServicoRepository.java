package io.github.PriAlves.clientes.model.repository;

import io.github.PriAlves.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
