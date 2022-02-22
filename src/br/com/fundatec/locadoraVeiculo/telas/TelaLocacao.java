package br.com.fundatec.locadoraVeiculo.telas;

import java.util.Scanner;

public class TelaLocacao {
    private Scanner in = new Scanner(System.in);


    public void imprimirTelaDeLocacoes() {
        boolean continuar = true;
        while (continuar) {
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
    private void cadastrarLocacao(){
    }
}
