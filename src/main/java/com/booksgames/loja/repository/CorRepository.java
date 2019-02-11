package com.booksgames.loja.repository;

import com.booksgames.loja.domain.Cor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CorRepository extends MongoRepository<Cor, String> {
    Cor findBy_id(ObjectId _id);
}