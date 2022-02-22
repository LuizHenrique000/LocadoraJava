package br.com.fundatec.locadoraVeiculo.telas;

import br.com.fundatec.locadoraVeiculo.bancodedados.CriacaoBaseDados;
import br.com.fundatec.locadoraVeiculo.bancodedados.VeiculoRepository;
import br.com.fundatec.locadoraVeiculo.enums.TipoVeiculo;
import br.com.fundatec.locadoraVeiculo.models.Veiculo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaVeiculo {


    public VeiculoRepository bancoVeiculo = VeiculoRepository.criar();
    private Scanner in = new Scanner(System.in);

    public void imprimirTelaVeiculos() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("__________TELA DE VEICULOS__________");
            System.out.println("| Digite 1 para Cadastrar Veículos |");
            System.out.println("| Digite 2 para Listar Veículos    |");
            System.out.println("| Digite 0 para Retornar ao menu   |");
            System.out.println("------------------------------------");
            int opcao = 4;

            try {
                opcao = in.nextInt();
            } catch (InputMismatchException excecao) {
                System.out.println("resposta errada, digite entre 1, 2 ou 0");
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

   public void listarVeiculos() {
        CriacaoBaseDados criacaoBaseDados = new CriacaoBaseDados();
        CriacaoBaseDados.inicializarBase();
        for (Veiculo elemento :
                bancoVeiculo.getVeiculos()) {
            System.out.println("Placa: " + elemento.getPlaca() +  " Marca: " + elemento.getMarca() + " Modelo: " + elemento.getModelo() + " Tipo do Veiculo: " + elemento.getTipoVeiculo() + " Kilometragem: " +
                    elemento.getKilometragem() + " Valor por Km Rodado: " + elemento.getValorKmRodado() + " Valor da diaria: " + elemento.getValorDiaria());
            System.out.println("_");

        }
    }
}
