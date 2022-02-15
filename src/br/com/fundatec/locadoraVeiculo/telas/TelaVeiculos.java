package br.com.fundatec.locadoraVeiculo.telas;

import br.com.fundatec.locadoraVeiculo.bancoDeDados.VeiculoRepository;
import br.com.fundatec.locadoraVeiculo.enums.TipoVeiculo;
import br.com.fundatec.locadoraVeiculo.models.Veiculo;
import java.util.Scanner;

public class TelaVeiculos {

    boolean continuar = true;
    private VeiculoRepository bancoVeiculo = VeiculoRepository.criar();
    private Scanner in = new Scanner(System.in);

    public void imprimirTelaVeiculos() {

        while (continuar) {
            System.out.println("__________TELA DE VEICULOS__________");
            System.out.println("| Digite 1 para Cadastrar Veículos |");
            System.out.println("| Digite 2 para Listar Veículos    |");
            System.out.println("| Digite 0 para Retornar ao menu   |");
            System.out.println("------------------------------------");
            int opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 0:
                    return;
                default:
                    System.out.print("Resposta Inválida");
                    break;

            }
        }
    }

    private void cadastrarVeiculo() {
        System.out.println("Digite a placa do seu veículo: ");
        String placa = in.next();
        System.out.println("Digite a marca do seu veiculo: ");
        String marca = in.next();
        System.out.println("Digite o modelo do seu veículo: ");
        String modelo = in.next();
        System.out.println("Digite o tipo do seu veículo entre HATCH, SEDAN, SUV, PICKUP;");
        TipoVeiculo tipoVeiculo = TipoVeiculo.valueOf(in.next().toUpperCase());
        System.out.println("Digite a kilometragem do seu veículo:");
        float kilometragem = in.nextFloat();
        System.out.println("Digite o valor por Km rodado:");
        Double valorKmRodado = in.nextDouble();
        System.out.println("Digite o valor da diaria:");
        Double valorDiaria = in.nextDouble();
        Veiculo veiculo = new Veiculo(placa, marca, modelo, tipoVeiculo, kilometragem, valorKmRodado, valorDiaria);
        bancoVeiculo.cadastrarVeiculo(veiculo);
    }

    private void listarVeiculos() {
        for (Veiculo elemento :
                bancoVeiculo.getVeiculos()) {
            System.out.println("Modelo: " + elemento.getModelo() + "\nMarca: " + elemento.getMarca() + "\nPlaca: " + elemento.getPlaca());
            System.out.println("_");
        }
    }
}
