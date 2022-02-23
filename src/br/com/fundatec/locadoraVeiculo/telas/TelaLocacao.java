package br.com.fundatec.locadoraVeiculo.telas;

import br.com.fundatec.locadoraVeiculo.bancodedados.CriacaoBaseDadoVeiculo;
import br.com.fundatec.locadoraVeiculo.bancodedados.VeiculoRepository;
import br.com.fundatec.locadoraVeiculo.models.Veiculo;

import java.util.Scanner;

public class TelaLocacao {
    private Scanner in = new Scanner(System.in);
    public VeiculoRepository bancoVeiculo = VeiculoRepository.criar();

    public void imprimirTelaDeLocacoes() {
        boolean continuar = true;
        while (continuar) {
            System.out.printf("");
            System.out.println("_________TELA DE LOCAÇÕES___________");
            System.out.println("| Digite 1 para Cadastrar Locações |");
            System.out.println("| Digite 2 para Encerrar Locações  |");
            System.out.println("| Digite 3 para Listar Locações    |");
            System.out.println("| Digite 0 para Retornar ao Menu   |");
            System.out.println("------------------------------------");
            int opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarLocacao();
                    break;
                case 2:
                    System.out.println("Encerrar locações");
                    break;
                case 3:
                    System.out.println("Listar locações");
                    break;
                case 0:
                    return;
                default:
                    System.out.print("Resposta Inválida");
            }
        }
    }

    private void cadastrarLocacao() {
        int contador = 0;
        CriacaoBaseDadoVeiculo.inicializarBase();
        for (Veiculo elemento : bancoVeiculo.getVeiculos()) {
            System.out.println("Id: " + contador++ + "," + "Placa: " +
                    elemento.getPlaca() + "," + " Marca: " + elemento.getMarca() + "," +
                    " Modelo: " + elemento.getModelo() + "," + " Tipo do Veiculo: " + elemento.getTipoVeiculo() +
                    "," + " Kilometragem: " +
                    elemento.getKilometragem() + " Valor por Km Rodado: " + elemento.getValorKmRodado() +
                    " Valor da diaria: " + elemento.getValorDiaria());
            System.out.println("_");
        }

    }
}
