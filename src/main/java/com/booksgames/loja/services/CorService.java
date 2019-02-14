package com.booksgames.loja.services;

import com.booksgames.loja.documents.Cor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CorService {
   /* List<Cor> findAll();
    List<Cor> findId(String id);*/

    Cor insert(Cor cor);
    Cor update(String id);
    void delete(String id);

    //WebFluxo
    Flux<Cor> findAll();
    Mono<Cor> findById(String id);
    Mono<Cor> save(Cor cor);

}
