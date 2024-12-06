package com.br.joao.projeto.projeto_api.repository;

import com.br.joao.projeto.projeto_api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
