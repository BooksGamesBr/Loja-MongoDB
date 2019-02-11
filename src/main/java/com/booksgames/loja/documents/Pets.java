package com.booksgames.loja.documents;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pets")
public class Pets {
    @Id
    public ObjectId _id;

    public String nome;
    public String especie;
    public String raca;

    // Constructors
    public Pets() {}

    public Pets(ObjectId _id, String nome, String especie, String raca) {
        this._id = _id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
    }

    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
}