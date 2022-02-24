package br.com.fundatec.locadoraVeiculo.telas;

import br.com.fundatec.locadoraVeiculo.bancodedados.VeiculoRepository;
import br.com.fundatec.locadoraVeiculo.enums.TipoVeiculo;
import br.com.fundatec.locadoraVeiculo.models.Veiculo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TelaVeiculo {
    Tela tela = new Tela();
    public VeiculoRepository bancoVeiculo = VeiculoRepository.criar();
    private Scanner in = new Scanner(System.in);

    public void imprimirTelaVeiculos() {
        boolean continuar = true;
        while (continuar) {
            System.out.println();
            System.out.println("__________TELA DE VEICULOS__________");
            System.out.println("| Digite 1 para Cadastrar Veículos |");
            System.out.println("| Digite 2 para Listar Veículos    |");
            System.out.println("| Digite 0 para Retornar ao menu   |");
            System.out.println("------------------------------------");
            int opcao;

            try {
                opcao = tela.solicitarInt();
            } catch (InputMismatchException excecao) {
               tela.solicitarTexto();
                opcao = -1;
            }

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
        tela.solicitarTexto();
        System.out.println("Digite a placa do seu veículo: ");
        String placa = tela.solicitarTexto();
        System.out.println("Digite a marca do seu veiculo: ");
        String marca = tela.solicitarTexto();
        System.out.println("Digite o modelo do seu veículo: ");
        String modelo = tela.solicitarTexto();
        System.out.println("Digite o tipo do seu veículo entre HATCH, SEDAN, SUV, PICKUP: ");
        TipoVeiculo tipoVeiculo = null;
        while (tipoVeiculo == null) {
            try {
                tipoVeiculo = TipoVeiculo.valueOf(tela.solicitarTexto().toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.out.printf("Resposta inválida, digite entre HATCH, SEDAN, SUV e PICKUP: ");
            }
        }
        System.out.println("Digite a kilometragem do seu veículo:");
        float kilometragem = tela.solicitarFloat();
        tela.solicitarTexto();
        System.out.println("Digite o valor por Km rodado:");
        Double valorKmRodado = tela.solicitarDouble();
        tela.solicitarTexto();
        System.out.println("Digite o valor da diaria:");
        Double valorDiaria = tela.solicitarDouble();
        tela.solicitarTexto();
        Veiculo veiculo = new Veiculo(placa, marca, modelo, tipoVeiculo, kilometragem, valorKmRodado, valorDiaria);
        bancoVeiculo.cadastrarVeiculo(veiculo);
    }

    public void listarVeiculos() {
        List<Veiculo> veiculos = bancoVeiculo.getVeiculos();
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            System.out.println(String.format("   >>> [%d] --> %s", i, veiculo));
            System.out.println("_");
        }
        if (bancoVeiculo.getVeiculos().isEmpty()) {
            System.out.println("Ainda não há nenhum veiculo: ");
        }
    }
}