package br.com.fundatec.locadoraVeiculo.telas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tela {
    private Scanner in = new Scanner(System.in);

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
        return in.nextInt();
    }

    public Double solicitarDouble() {
        return in.nextDouble();
    }

    public Long solicitarLong() {
        return in.nextLong();
    }
}
