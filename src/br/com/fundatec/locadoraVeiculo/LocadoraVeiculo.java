package br.com.fundatec.locadoraVeiculo;

import br.com.fundatec.locadoraVeiculo.bancodedados.CriacaoBaseDadoCliente;
import br.com.fundatec.locadoraVeiculo.bancodedados.CriacaoBaseDadoVeiculo;
import br.com.fundatec.locadoraVeiculo.telas.TelaPrincipal;

public class LocadoraVeiculo {
    public static void main(String[] args) {
        CriacaoBaseDadoVeiculo.inicializarBase();
        CriacaoBaseDadoCliente.inicializarBase();
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.imprimirMenu();
    }
}
