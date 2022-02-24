package br.com.fundatec.locadoraVeiculo.models;

import br.com.fundatec.locadoraVeiculo.enums.SituacaoLocacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataLocacao;
    private LocalDate dataEntrega;
    private BigDecimal valor;
    private SituacaoLocacao situacao;

    public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataLocacao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataLocacao = dataLocacao;
        this.situacao = SituacaoLocacao.ATIVA;
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

    public void encerrar(LocalDate dataEntrega, Float kmAtual) {
        this.situacao = SituacaoLocacao.ENCERRADA;

        Long numeroDiarias = ChronoUnit.DAYS.between(dataLocacao, dataEntrega);
        Float diferencaKm = kmAtual.floatValue() - veiculo.getKilometragem().floatValue();

        // (numeroDiarias * veiculo.getValorDiaria()) + (diferencaKm * veiculo.getValorKmRodado());
        BigDecimal diarias = new BigDecimal(numeroDiarias);
        BigDecimal valorDiaria = new BigDecimal(veiculo.getValorDiaria().toString());
        BigDecimal km = new BigDecimal(diferencaKm.toString());
        BigDecimal valorKm = new BigDecimal(veiculo.getValorKmRodado());

        (diarias * veiculo.getValorDiaria()) + (diferencaKm * veiculo.getValorKmRodado());
    }
}
