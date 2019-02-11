package com.booksgames.loja.services;

import java.util.List;
import com.booksgames.loja.documents.Pets;

public interface PetsService {

    List<Pets> listarTodos();
    Pets listarPorId(String id);

}
