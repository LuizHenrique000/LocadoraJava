package br.com.fundatec.locadoraVeiculo.bancodedados;

import br.com.fundatec.locadoraVeiculo.enums.TipoVeiculo;
import br.com.fundatec.locadoraVeiculo.models.Veiculo;

public class CriacaoBaseDados {
    public static void inicializarBase() {
        cadastrarVeiculos();
    }

    private static void cadastrarVeiculos() {
        VeiculoRepository bancoVeiculo = VeiculoRepository.criar();

        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0001", "VW", "Gol", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0003", "Chevrolet", "Onyx", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0004", "Toyota", "Etios", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0005", "Renault", "Sandero", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0002", "Fiat", "Palio", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0005", "Peugeot", "207", TipoVeiculo.HATCH, 0f, 5.0, 50.0));

        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0006", "VW", "Virtus", TipoVeiculo.SEDAN, 0f, 7.0, 60.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0007", "Fiat", "Siena", TipoVeiculo.SEDAN, 0f, 7.0, 60.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0008", "Chevrolet", "Cobalt", TipoVeiculo.SEDAN, 0f, 7.0, 60.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0009", "Toyota", "Corolla", TipoVeiculo.SEDAN, 0f, 8.0, 65.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0010", "Renault", "Logan", TipoVeiculo.SEDAN, 0f, 7.0, 60.0));

        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0011", "Jeep", "Compass", TipoVeiculo.SUV, 0f, 11.0, 100.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0012", "VW", "T-Cross", TipoVeiculo.SUV, 0f, 11.0, 95.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0013", "Hyundai", "Creta", TipoVeiculo.SUV, 0f, 11.0, 95.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0014", "Honda", "HRV", TipoVeiculo.SUV, 0f, 11.0, 95.0));

        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0015", "Ford", "Ranger", TipoVeiculo.PICKUP, 0f, 12.5, 110.0));
        bancoVeiculo.cadastrarVeiculo(new Veiculo("ABC0016", "VW", "Amarok", TipoVeiculo.PICKUP, 0f, 12.0, 115.0));
    }
}

