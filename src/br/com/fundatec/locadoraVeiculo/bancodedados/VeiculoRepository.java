package br.com.fundatec.locadoraVeiculo.bancodedados;

import br.com.fundatec.locadoraVeiculo.models.Veiculo;

import java.util.LinkedList;
import java.util.List;

public class VeiculoRepository {
    private static VeiculoRepository instancia;

    private List<Veiculo> veiculos;

    private VeiculoRepository() {
        this.veiculos = new LinkedList<>();
    }

    public static VeiculoRepository criar() {
        if (instancia == null) {
            instancia = new VeiculoRepository();
        }
        return instancia;
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public Veiculo selecionarVeiculo(int indice) {
        return veiculos.get(indice);
    }
}
