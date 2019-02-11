package com.booksgames.loja.repository;

import com.booksgames.loja.domain.Grupo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GrupoRepository extends MongoRepository<Grupo, String> {
    Grupo findBy_id(ObjectId _id);
}