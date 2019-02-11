package com.booksgames.loja.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "grupo")
public class Grupo {
    private static final long serialVersionUID = 1L;

    @Id
    public ObjectId _id;
    public String descricao;

    // Constructors
    public Grupo() {}

    public Grupo(ObjectId _id, String descricao) {
        this._id = _id;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}