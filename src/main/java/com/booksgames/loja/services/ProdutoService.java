package com.booksgames.loja.services;

import com.booksgames.loja.documents.Cliente;
import com.booksgames.loja.documents.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> listarTodos();

    List<Produto> listarPorId(String id);

    /*Produto cadastrar(Produto produto);

    Produto atualizar(Produto produto);

     void remover(Integer id);*/
    }
