package br.com.fundatec.locadoraVeiculo.models;

import br.com.fundatec.locadoraVeiculo.enums.SituacaoLocacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataLocacao;
    private LocalDate dataEntrega = null;
    public BigDecimal valor = null;
    private SituacaoLocacao situacao;

    public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataLocacao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataLocacao = dataLocacao;
        this.situacao = SituacaoLocacao.ATIVA;
    }

    public void encerrar(LocalDate dataEntrega, Float kilometragemAtual) {
        this.situacao = SituacaoLocacao.ENCERRADA;
        this.dataEntrega = dataEntrega;
        Long numeroDiarias = (ChronoUnit.DAYS.between(dataLocacao, dataEntrega) + 1);
        Float diferencaKm = kilometragemAtual - veiculo.getKilometragem().floatValue();
        BigDecimal diarias = new BigDecimal(numeroDiarias);
        BigDecimal valorDiaria = new BigDecimal(veiculo.getValorDiaria().toString());
        BigDecimal km = new BigDecimal(diferencaKm.toString());
        BigDecimal valorKm = new BigDecimal(veiculo.getValorKmRodado());
        this.valor = diarias.multiply(valorDiaria).add(km.multiply(valorKm));
        veiculo.alterarKilometragem(kilometragemAtual);
    }

    @Override
    public String toString() {
        return "Locacao [" + "cliente=" + cliente + ", veiculo=" + veiculo + ", dataLocacao=" +
                dataLocacao + ", dataEntrega=" + dataEntrega + ", valor=" + valor
                + ", situacao=" + situacao + ']';
    }
}
