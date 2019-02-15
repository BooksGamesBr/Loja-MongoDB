package com.booksgames.loja.repository.reactive;

import com.booksgames.loja.documents.Cor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CorReactiveRespository extends ReactiveMongoRepository<Cor, String>{

    Flux<Cor> findByNome(String nome);
 /*   List<Cor> findByNomeGoogle();*/
}
