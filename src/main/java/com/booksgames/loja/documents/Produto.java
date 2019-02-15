package com.booksgames.loja.documents;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Document(collection = "produto")
public class Produto {
  private static final long serialVersionUID = 1L;

  @Id
  public String _id;
  
  public String descricao;
  public Double preco;
  public Grupo grupo;
  public Cor cor;
  @JsonFormat(pattern="dd/MM/yyyy HH:mm")
  public Date datacadastro;
  
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Produto)) return false;

    Produto produto = (Produto) o;

    if (!get_id().equals(produto.get_id())) return false;
    if (!getDescricao().equals(produto.getDescricao())) return false;
    if (!getPreco().equals(produto.getPreco())) return false;
    if (!getGrupo().equals(produto.getGrupo())) return false;
    if (!getCor().equals(produto.getCor())) return false;
    return getDatacadastro().equals(produto.getDatacadastro());
  }

  @Override
  public int hashCode() {
    int result = get_id().hashCode();
    result = 31 * result + getDescricao().hashCode();
    result = 31 * result + getPreco().hashCode();
    result = 31 * result + getGrupo().hashCode();
    result = 31 * result + getCor().hashCode();
    result = 31 * result + getDatacadastro().hashCode();
    return result;
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