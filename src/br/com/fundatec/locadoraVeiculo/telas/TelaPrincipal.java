package br.com.fundatec.locadoraVeiculo.telas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaPrincipal {
    private Scanner in = new Scanner(System.in);


    public void imprimirMenu() {
        boolean continuar = true;
        while (continuar) {

            System.out.println();
            System.out.println("__________TELA DE MENU____________");
            System.out.println("| Digite 1 para Tela de Veículos |");
            System.out.println("| Digite 2 para Tela de Clientes |");
            System.out.println("| Digite 3 para Tela de Locações |");
            System.out.println("| Digite 0 para Encerrar         |");
            System.out.println("----------------------------------");
            int opcao = -1;

            try {
                opcao = in.nextInt();
            } catch (InputMismatchException excecao) {
                System.out.println("resposta errada, digite entre 1, 2 ou 0");
            }

            switch (opcao) {
                case 1:
                    TelaVeiculo telaDeVeiculos = new TelaVeiculo();
                    telaDeVeiculos.imprimirTelaVeiculos();
                    break;
                case 2:
                    TelaCliente telaDeClientes = new TelaCliente();
                    telaDeClientes.imprimirTelaDeClientes();
                    break;
                case 3:
                    TelaLocacao telaDeLocacoes = new TelaLocacao();
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
