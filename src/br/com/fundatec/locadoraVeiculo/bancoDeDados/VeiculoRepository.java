package br.com.fundatec.locadoraVeiculo.bancoDeDados;

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
        System.out.println("Veiculo cadastrado com sucesso");
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}
