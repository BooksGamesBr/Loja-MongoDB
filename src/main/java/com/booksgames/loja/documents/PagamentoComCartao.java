package com.booksgames.loja.documents;

import com.booksgames.loja.documents.enums.EstadoPagamento;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pagamentocomcartao")
public class PagamentoComCartao extends Pagamento {
    private static final long serialVersionUID = 1L;

    private Integer numeroDeParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(String _id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(_id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
