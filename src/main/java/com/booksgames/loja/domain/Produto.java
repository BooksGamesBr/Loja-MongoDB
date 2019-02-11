package com.booksgames.loja.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.crypto.Data;

@Document(collection = "produto")
public class Produto {
  private static final long serialVersionUID = 1L;

  @Id
  public ObjectId _id;
  
  public String descricao;
  public Double preco;
  public String grupo;
  public String cor;
  public Data datacadastro;
  
  // Constructors
  public Produto() {}
  
  public Produto(ObjectId _id, String descricao, Double preco, String grupo, String cor, Data datacadastro) {
    this._id = _id;
    this.descricao = descricao;
    this.preco = preco;
    this.grupo = grupo;
    this.cor = cor;
    this.datacadastro = datacadastro;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  // ObjectId needs to be converted to string

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

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public String getGrupo() {
    return grupo;
  }

  public void setGrupo(String grupo) {
    this.grupo = grupo;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public Data getDatacadastro() {
    return datacadastro;
  }

  public void setDatacadastro(Data datacadastro) {
    this.datacadastro = datacadastro;
  }
}