package com.br.joao.projeto.projeto_api.service;

import com.br.joao.projeto.projeto_api.entity.Produto;
import com.br.joao.projeto.projeto_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //JPA
    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id).map(Produto -> {
            Produto.setNome(produtoAtualizado.getNome());
            Produto.setDescricao(produtoAtualizado.getDescricao());
            Produto.setPreco(produtoAtualizado.getPreco());
            return produtoRepository.save(Produto);
        }).orElse(null);
    }

    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

}
