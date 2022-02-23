package br.com.fundatec.locadoraVeiculo.bancodedados;

import br.com.fundatec.locadoraVeiculo.enums.TipoPessoa;
import br.com.fundatec.locadoraVeiculo.models.Cliente;

public class CriacaoBaseDadoCliente {
    public static void inicializarBase() {
        cadastrarClientes();
    }

    private static void cadastrarClientes() {
        ClienteRepository bancoCliente = ClienteRepository.criar();
        bancoCliente.adicionar(new Cliente(TipoPessoa.FISICA, cnpj, tipoDocumento, razaoSocial, endereco));
    }
}
