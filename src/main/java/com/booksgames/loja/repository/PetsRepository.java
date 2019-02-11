package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Pets;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;

public interface PetsRepository extends MongoRepository<Pets, ObjectId> {
    Pets findBy_id(ObjectId _id);
}