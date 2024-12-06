package com.br.joao.projeto.projeto_api.repository;

import com.br.joao.projeto.projeto_api.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
