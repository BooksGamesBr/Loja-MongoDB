package com.booksgames.loja.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produto")
public class Produto {
  private static final long serialVersionUID = 1L;

  @Id
  public ObjectId _id;
  
  public String descricao;
  public Float preco;
  public String grupo;
  public String cor;
  
  // Constructors
  public Produto() {}
  
  public Produto(ObjectId _id, String descricao, Float preco, String grupo, String cor) {
    this._id = _id;
    this.descricao = descricao;
    this.preco = preco;
    this.grupo = grupo;
    this.cor = cor;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  // ObjectId needs to be converted to string
  public String get_id() { return _id.toHexString(); }
  public void set_id(ObjectId _id) { this._id = _id; }
  
  public String getDescricao() { return descricao; }
  public void setDescricao(String descricao) { this.descricao = descricao; }
  
  public Float getPreco() { return preco; }
  public void setPreco(Float preco) { this.preco = preco; }
  
  public String getGrupo() { return grupo; }
  public void setGrupo(String grupo) { this.grupo = grupo; }
  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }
}