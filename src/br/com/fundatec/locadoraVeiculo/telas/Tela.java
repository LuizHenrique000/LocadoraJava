package br.com.fundatec.locadoraVeiculo.telas;

import br.com.fundatec.locadoraVeiculo.bancodedados.VeiculoRepository;
import br.com.fundatec.locadoraVeiculo.models.Veiculo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Tela {
    private Scanner in = new Scanner(System.in);
    public VeiculoRepository bancoVeiculo = VeiculoRepository.criar();

    public Tela() {
    }

    public String solicitarTexto() {
        return in.nextLine();
    }

    public Float solicitarFloat() {
        float numero = -1;
        while (numero == -1) {
            try {
                numero = in.nextFloat();
            } catch (InputMismatchException excecao) {
                System.out.println("Resposta inválida");
                in.nextLine();
            }

        }
        return numero;
    }

    public int solicitarInt() {
        int numero = -1;
        while (numero == -1) {
            try {
                numero = in.nextInt();
            } catch (InputMismatchException excecao) {
                System.out.println("Resposta inválida");
                in.nextLine();
            }

        }
        return numero;
    }


    public Double solicitarDouble() {
        double numero = -1;
        while (numero == -1) {
            try {
                numero = in.nextDouble();
            } catch (InputMismatchException excecao) {
                System.out.println("Resposta inválida");
                in.nextLine();
            }

        }
        return numero;
    }


    public Long solicitarLong() {
        Long numero = Long.valueOf(-1);
        while (numero == -1) {
            try {
                numero = in.nextLong();
            } catch (InputMismatchException excecao) {
                System.out.println("Resposta inválida");
                in.nextLine();
            }

        }
        return numero;
    }


}
