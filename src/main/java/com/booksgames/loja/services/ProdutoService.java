package com.booksgames.loja.services;

import com.booksgames.loja.documents.Produto;

public interface ProdutoService {

   /* List<Produto> listarTodos();

    List<Produto> listarPorId(String id);*/

    Produto insert(Produto produto);

    Produto update(String id);

     void delete(String _id);
    }
