package com.booksgames.loja.services;

import com.booksgames.loja.documents.Produto;

import java.util.List;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface ProdutoService {

    List<Produto> findAll();

    //List<Produto> listarPorId(String id);

    Produto insert(Produto produto);

    Produto update(String id);

    void delete(String _id);
}
