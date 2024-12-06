package com.br.joao.projeto.projeto_api.service;

import com.br.joao.projeto.projeto_api.entity.Cliente;
import com.br.joao.projeto.projeto_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //JPA
    public List<Cliente> criarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id).map(Cliente -> {
            Cliente.setNome(clienteAtualizado.getNome());
            Cliente.setEndereco(clienteAtualizado.getEndereco());
            Cliente.setAtivo(clienteAtualizado.getAtivo());
            return clienteRepository.save(Cliente);
        }).orElse(null);
    }

    public void excluirCliente(Long id){
        clienteRepository.deleteById(id);
    }

}
