package com.booksgames.loja.services.impl;

import com.booksgames.loja.services.ProdutoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksgames.loja.documents.Produto;
import com.booksgames.loja.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRespository;

    @Override
    public List<Produto> listarTodos() {

        return this.produtoRespository.findAll();
    }

    @Override
    public List<Produto> listarPorId(String id) {
        return this.listarTodos();
    }/*

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

