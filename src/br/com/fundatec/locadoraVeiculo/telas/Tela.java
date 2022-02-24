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

    public Float solicitarFloat(){
        try{
            in.nextFloat();
        } catch (InputMismatchException excecao) {
            solicitarTexto();
            System.out.println("Resposta Inválida");
        }
        return in.nextFloat();
    }

    public int solicitarInt() {
        return in.nextInt();
    }
    public Double solicitarDouble(){
        return in.nextDouble();
    }
    public Long solicitarLong(){
        return in.nextLong();
    }
}
