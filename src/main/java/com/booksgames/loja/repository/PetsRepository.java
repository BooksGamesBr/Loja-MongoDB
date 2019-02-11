package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Pets;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetsRepository extends MongoRepository<Pets, ObjectId> {
    Pets findBy_id(ObjectId _id);
}