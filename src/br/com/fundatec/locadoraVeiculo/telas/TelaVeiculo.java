package br.com.fundatec.locadoraVeiculo.telas;

import br.com.fundatec.locadoraVeiculo.bancodedados.CriacaoBaseDadoVeiculo;
import br.com.fundatec.locadoraVeiculo.bancodedados.VeiculoRepository;
import br.com.fundatec.locadoraVeiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraVeiculo.enums.TipoPessoa;
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
            int opcao;

            try {
                opcao = in.nextInt();
            } catch (InputMismatchException excecao) {
                in.nextLine();
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
        System.out.println("Digite a placa do seu veículo: ");
        String placa = in.next();
        System.out.println("Digite a marca do seu veiculo: ");
        String marca = in.next();
        System.out.println("Digite o modelo do seu veículo: ");
        String modelo = in.next();
        System.out.println("Digite o tipo do seu veículo entre HATCH, SEDAN, SUV, PICKUP: ");
        TipoVeiculo tipoVeiculo;
        try {
            tipoVeiculo = TipoVeiculo.valueOf(in.next().toUpperCase());
        } catch (IllegalArgumentException excecao) {
            in.nextLine();
            System.out.printf("Resposta inválida, digite entre HATCH, SEDAN, SUV e PICKUP: ");
        }
        tipoVeiculo = TipoVeiculo.valueOf(in.next().toUpperCase());
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
        for (Veiculo elemento : bancoVeiculo.getVeiculos()) {
            for (int i = 0; i < bancoVeiculo.getVeiculos().size(); i++) {
                System.out.println("Id: " + i + "Placa: " + elemento.getPlaca() + " Marca: " + elemento.getMarca()
                        + " Modelo: " + elemento.getModelo() + " Tipo do Veiculo: " + elemento.getTipoVeiculo()
                        + " Kilometragem: " +
                        elemento.getKilometragem() + " Valor por Km Rodado: " + elemento.getValorKmRodado()
                        + " Valor da diaria: " + elemento.getValorDiaria());
                System.out.println("_");

            }
        }
    }
    private TipoPessoa lerTipoPessoa() {
        while (true) {
            try {
                String tipoPessoa = in.next();
                return TipoPessoa.valueOf(tipoPessoa.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.err.println(
                        "Tipo de pessoa invalida, digite uma das opções válidas. (FISICA ou JURIDICA)");
            }
        }
    }
    private TipoDocumento lerTipoDocumento() {
        while (true) {
            try {
                String tipoDocumento = in.next();
                return TipoDocumento.valueOf(tipoDocumento.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.err.println(
                        "Tipo de documento inválido, digite uma das opções válidas: CPF, CNH ou RG");
            }
        }
    }

    private  int lerInt(){
        while (true) {
            try {
                return in.nextInt();
            } catch (InputMismatchException excecao) {
                in.nextLine();
                System.err.println("!!!Digite um valor válido!!!");
            }
        }
    }
    private Long lerLong() {
        while (true) {
            try {
                return in.nextLong();
            } catch (InputMismatchException excecao) {
                in.nextLine();
                System.err.println("!!!Digite um valor válido!!!");
            }
        }
    }
    private String lerString(){
        while (true) {
            try {
                return in.next();
            } catch (InputMismatchException excecao) {
                in.nextLine();
                System.err.println("!!!Digite uma opção válida!!!");
            }
        }
    }
}
}