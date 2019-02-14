package com.booksgames.loja.repository.reactive;

import com.booksgames.loja.documents.Cor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CorReactiveRespository extends ReactiveMongoRepository<Cor, String>{

}
