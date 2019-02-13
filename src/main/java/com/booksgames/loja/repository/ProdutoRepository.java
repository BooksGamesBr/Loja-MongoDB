package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
  Produto findBy_id(String _id);
}