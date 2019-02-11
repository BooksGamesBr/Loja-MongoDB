package com.booksgames.loja.dto;

import org.bson.types.ObjectId;

import javax.xml.crypto.Data;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public ObjectId _id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=1, max=80, message="O tamanho deve ser entre 1 e 80 caracteres")
    public String descricao;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=1, max=80, message="O tamanho deve ser entre 1 e 80 caracteres")
    public Double preco;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=1, max=80, message="O tamanho deve ser entre 1 e 80 caracteres")
    private GrupoDTO grupoDTO;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=1, max=80, message="O tamanho deve ser entre 1 e 80 caracteres")
    private CorDTO corDTO;

    public Data datacadastro;

    public ProdutoDTO() {
    }

    public ProdutoDTO(ObjectId _id, String descricao, Double preco, GrupoDTO grupoDTO, CorDTO corDTO, Data datacadastro) {
        this._id = _id;
        this.descricao = descricao;
        this.preco = preco;
        this.grupoDTO = grupoDTO;
        this.corDTO = corDTO;
        this.datacadastro = datacadastro;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public GrupoDTO getGrupoDTO() {
        return grupoDTO;
    }

    public void setGrupoDTO(GrupoDTO grupoDTO) {
        this.grupoDTO = grupoDTO;
    }

    public CorDTO getCorDTO() {
        return corDTO;
    }

    public void setCorDTO(CorDTO corDTO) {
        this.corDTO = corDTO;
    }

    public Data getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Data datacadastro) {
        this.datacadastro = datacadastro;
    }
}