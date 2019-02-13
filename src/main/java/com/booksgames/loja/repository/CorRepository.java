package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Cor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CorRepository extends MongoRepository<Cor, String> {
    Cor findBy_id(String _id);
}