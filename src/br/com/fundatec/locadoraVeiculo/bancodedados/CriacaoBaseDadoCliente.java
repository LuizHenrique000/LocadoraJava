package br.com.fundatec.locadoraVeiculo.bancodedados;

import br.com.fundatec.locadoraVeiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraVeiculo.enums.TipoPessoa;
import br.com.fundatec.locadoraVeiculo.models.Cliente;
import br.com.fundatec.locadoraVeiculo.models.Endereco;

public class CriacaoBaseDadoCliente {
    public static void inicializarBase() {
        cadastrarClientes();
    }

    private static void cadastrarClientes() {
        ClienteRepository bancoCliente = ClienteRepository.criar();
        bancoCliente.adicionar(new Cliente("Fernando",TipoDocumento.CPF, 61991286058L, new Endereco("Rua Barão de Vitória", 97, "Casa", "Casa Grande", "Diadema", "SP", 44302021)));
        bancoCliente.adicionar(new Cliente("Jorge", TipoDocumento.CPF,39607635242L, new Endereco("Avenida Esbertalina Barbosa Damiani", 29, "Casa", "Guriri Norte", "São Mateus", "ES", 29946490)));
    }
}
