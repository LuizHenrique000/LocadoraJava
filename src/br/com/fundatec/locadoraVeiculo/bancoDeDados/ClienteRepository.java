package br.com.fundatec.locadoraVeiculo.bancoDeDados;

import br.com.fundatec.locadoraVeiculo.models.Cliente;

import java.util.LinkedList;
import java.util.List;

public class ClienteRepository {
    private static ClienteRepository instancia;

    private List<Cliente> clientes;

    private ClienteRepository() {
        this.clientes = new LinkedList<>();
    }

    public static ClienteRepository criar() {
        if (instancia == null) {
            instancia = new ClienteRepository();
        }
        return instancia;

    }

    public void adicionar(Cliente cliente) {
        this.clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso");
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
