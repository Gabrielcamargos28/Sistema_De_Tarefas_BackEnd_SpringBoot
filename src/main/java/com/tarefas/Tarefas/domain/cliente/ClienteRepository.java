package com.tarefas.Tarefas.domain.cliente;

import com.tarefas.Tarefas.domain.cliente.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Page<Cliente> findAlByAtivoTrue(Pageable paginacao);
}
