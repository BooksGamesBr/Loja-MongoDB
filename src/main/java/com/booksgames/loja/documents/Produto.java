package com.booksgames.loja.documents;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Document(collection = "produto")
public class Produto implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  public String _id;
  
  public String descricao;
  public Double preco;
  public Grupo grupo;
  public Cor cor;
  @JsonFormat(pattern="dd/MM/yyyy HH:mm")
  public Date datacadastro;

  @DBRef(lazy = true)
  private List<Grupo> grupos = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Cor> cors = new ArrayList<>();
  
  // Constructors
  public Produto() {}
  
  public Produto(String _id, String descricao, Double preco, Grupo grupo, Cor cor, Date datacadastro) {
    this._id = _id;
    this.descricao = descricao;
    this.preco = preco;
    this.grupo = grupo;
    this.cor = cor;
    this.datacadastro = datacadastro;
  }

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
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

  public Grupo getGrupo() {
    return grupo;
  }

  public void setGrupo(Grupo grupo) {
    this.grupo = grupo;
  }

  public Cor getCor() {
    return cor;
  }

  public void setCor(Cor cor) {
    this.cor = cor;
  }

  public Date getDatacadastro() {
    return datacadastro;
  }

  public void setDatacadastro(Date datacadastro) {
    this.datacadastro = datacadastro;
  }

  public List<Grupo> getGrupos() {
    return grupos;
  }

  public void setGrupos(List<Grupo> grupos) {
    this.grupos = grupos;
  }

  public List<Cor> getCors() {
    return cors;
  }

  public void setCors(List<Cor> cors) {
    this.cors = cors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Produto)) return false;
    Produto produto = (Produto) o;
    return get_id().equals(produto.get_id()) &&
            getDescricao().equals(produto.getDescricao()) &&
            getPreco().equals(produto.getPreco()) &&
            getGrupo().equals(produto.getGrupo()) &&
            getCor().equals(produto.getCor()) &&
            getDatacadastro().equals(produto.getDatacadastro()) &&
            getGrupos().equals(produto.getGrupos()) &&
            getCors().equals(produto.getCors());
  }

  @Override
  public int hashCode() {
    return Objects.hash(get_id(), getDescricao(), getPreco(), getGrupo(), getCor(), getDatacadastro(), getGrupos(), getCors());
  }

  @Override
  public String toString() {
    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    StringBuilder builder = new StringBuilder();
    builder.append(", Codigo: ");
    builder.append(get_id());
    builder.append(", Descricao: ");
    builder.append(getDescricao());
    builder.append(", Preco: ");
    builder.append(nf.format(getPreco()));
    builder.append(", Grupo: ");
    builder.append(getGrupo());
    builder.append(", Cor: ");
    builder.append(getCor());
    builder.append(", Data: ");
    builder.append(sdf.format(getDatacadastro()));
    return builder.toString();
  }
}