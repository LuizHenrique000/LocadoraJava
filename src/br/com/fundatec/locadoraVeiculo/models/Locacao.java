package br.com.fundatec.locadoraVeiculo.models;

import br.com.fundatec.locadoraVeiculo.enums.SituacaoLocacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataLocacao;
    private LocalDate dataEntrega;
    private BigDecimal valor;
    private SituacaoLocacao situacao;

    public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataLocacao, LocalDate dataEntrega, BigDecimal valor, SituacaoLocacao situacao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataLocacao = dataLocacao;
        this.dataEntrega = dataEntrega;
        this.valor = valor;
        this.situacao = situacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public SituacaoLocacao getSituacao() {
        return situacao;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", dataLocacao=" + dataLocacao +
                ", dataEntrega=" + dataEntrega +
                ", valor=" + valor +
                ", situacao=" + situacao +
                '}';
    }
}
