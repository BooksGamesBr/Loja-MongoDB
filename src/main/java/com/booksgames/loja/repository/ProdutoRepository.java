package com.booksgames.loja.repository;

import com.booksgames.loja.model.Produto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
  Produto findBy_id(ObjectId _id);
}