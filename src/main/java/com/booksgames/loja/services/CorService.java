package com.booksgames.loja.services;

import com.booksgames.loja.documents.Cor;

public interface CorService {

   /* List<Cor> findAll();

    List<Cor> findId(String id);*/

    Cor insert(Cor cor);

    Cor update(Cor cor);

    void delete(String id);
}
