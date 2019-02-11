package com.booksgames.loja.dto;

import com.booksgames.loja.documents.Cor;
import org.bson.types.ObjectId;

import java.io.Serializable;

public class CorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private ObjectId _id;
    private String nome;
    private String hex;

    public CorDTO() {
    }

    public CorDTO(Cor obj) {
        _id = obj.get_id();
        nome = obj.getNome();
        hex = obj.getHex();
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
