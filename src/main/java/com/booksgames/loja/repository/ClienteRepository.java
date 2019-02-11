package com.booksgames.loja.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.booksgames.loja.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, ObjectId> {
    Cliente findBy_id(ObjectId _id);
}

