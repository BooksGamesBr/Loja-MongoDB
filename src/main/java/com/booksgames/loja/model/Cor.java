package com.booksgames.loja.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cor")
public class Cor {
    private static final long serialVersionUID = 1L;

    @Id
    public ObjectId _id;

    public String nome;
    public String hex;

    // Constructors
    public Cor() {}

    public Cor(ObjectId _id, String nome, String hex) {
        this._id = _id;
        this.nome = nome;
        this.hex = hex;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}