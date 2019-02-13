package com.booksgames.loja.services;

import com.booksgames.loja.documents.Grupo;

public interface GrupoService {
   /* List<Grupo> findAll();

    List<Grupo> findId(String id);*/

    Grupo insert(Grupo grupo);

    Grupo update(Grupo grupo);

    void delete(String id);
}
