package br.com.fundatec.locadoraVeiculo.telas;

import java.util.Scanner;

public class TelaPrincipal {
    private Scanner in = new Scanner(System.in);
    boolean continuar = true;

    public void imprimirMenu() {

        while (continuar) {
            System.out.println("__________TELA DE MENU____________");
            System.out.println("| Digite 1 para Tela de Veículos |");
            System.out.println("| Digite 2 para Tela de Clientes |");
            System.out.println("| Digite 3 para Tela de Locações |");
            System.out.println("| Digite 0 para Encerrar         |");
            System.out.println("----------------------------------");
            int opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    TelaVeiculos telaDeVeiculos = new TelaVeiculos();
                    telaDeVeiculos.imprimirTelaVeiculos();
                    break;
                case 2:
                    TelaCliente telaDeClientes = new TelaCliente();
                    telaDeClientes.imprimirTelaDeClientes();
                    break;
                case 3:
                    TelaLocacoes telaDeLocacoes = new TelaLocacoes();
                    telaDeLocacoes.imprimirTelaDeLocacoes();
                    break;
                case 0:
                    System.out.println("Encerrando Programa....");
                    continuar = false;
                    break;
                default:
                    System.out.print("Resposta Inválida");
                    break;
            }
        }
    }
}
