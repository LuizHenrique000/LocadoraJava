package br.com.fundatec.locadoraVeiculo.bancodedados;

import br.com.fundatec.locadoraVeiculo.models.Cliente;
import br.com.fundatec.locadoraVeiculo.models.Locacao;
import br.com.fundatec.locadoraVeiculo.models.Veiculo;

import java.util.LinkedList;
import java.util.List;

public class LocacaoRepository {
    private static LocacaoRepository instancia;

    private List<Locacao> locacoes;

    private LocacaoRepository() {
        this.locacoes = new LinkedList<>();
    }

    public static LocacaoRepository criar() {
        if (instancia == null) {
            instancia = new LocacaoRepository();
        }
        return instancia;

    }

    public void adicionar(Locacao locacao) {
        this.locacoes.add(locacao);
        System.out.println("Locação cadastrada com sucesso");
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }
    public Locacao selecionarLocacao(int indice) {
        return locacoes.get(indice);
    }
}
