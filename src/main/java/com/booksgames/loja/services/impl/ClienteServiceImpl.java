package com.booksgames.loja.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksgames.loja.documents.Cliente;
import com.booksgames.loja.services.ClienteService;
import com.booksgames.loja.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRespository;

    @Override
    public List<Cliente> listarTodos() {
        return this.clienteRespository.findAll();
    }

 /*   @Override
    public Cliente listarPorId(String id) {
        return this.clienteRespository.findById(id);
    }*

    @Override
    public Cliente cadastrar(Cliente cliente) {
        return this.clienteRespository.save(cliente);
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        return this.clienteRespository.save(cliente);
    }

   @Override
    public void remover(Integer id) {
        this.clienteRespository.delete(id);
    }*/

}
