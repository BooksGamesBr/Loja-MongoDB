package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Pets;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface PetsRepository extends MongoRepository<Pets, String> {
    Pets findBy_id(String _id);
}