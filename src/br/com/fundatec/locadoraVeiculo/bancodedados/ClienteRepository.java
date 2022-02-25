package br.com.fundatec.locadoraVeiculo.bancodedados;

import br.com.fundatec.locadoraVeiculo.models.Cliente;
import br.com.fundatec.locadoraVeiculo.models.Veiculo;

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
        System.out.printf("Cliente cadastrado com sucesso");
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    public Cliente selecionarCliente(int indice) {
        return clientes.get(indice);
    }
}
