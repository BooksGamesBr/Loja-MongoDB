package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Pets;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetsRepository extends MongoRepository<Pets, String> {
    Pets findBy_id(String _id);
}