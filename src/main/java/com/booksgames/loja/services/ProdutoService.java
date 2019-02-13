package com.booksgames.loja.services;

import com.booksgames.loja.documents.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> findAll();

    //List<Produto> listarPorId(String id);

    Produto insert(Produto produto);

    Produto update(String id);

    void delete(String _id);
}
