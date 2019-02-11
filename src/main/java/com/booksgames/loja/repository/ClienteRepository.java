package com.booksgames.loja.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksgames.loja.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}

