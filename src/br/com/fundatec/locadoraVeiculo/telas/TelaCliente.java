package br.com.fundatec.locadoraVeiculo.telas;

import br.com.fundatec.locadoraVeiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraVeiculo.enums.TipoPessoa;
import br.com.fundatec.locadoraVeiculo.models.Cliente;
import br.com.fundatec.locadoraVeiculo.models.Endereco;
import br.com.fundatec.locadoraVeiculo.bancodedados.ClienteRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TelaCliente {
    Tela tela = new Tela();
    private ClienteRepository bancoCliente = ClienteRepository.criar();
    private Scanner in = new Scanner(System.in);

    public void imprimirTelaDeClientes() {
        boolean continuar = true;
        while (continuar) {
            System.out.println();
            System.out.println("__________TELA DE CLIENTES__________");
            System.out.println("| Digite 1 para Cadastrar Clientes |");
            System.out.println("| Digite 2 para Listar clientes    |");
            System.out.println("| Digite 0 para Retornar ao menu   |");
            System.out.println("------------------------------------");
            int opcao;

            try {
                opcao = tela.solicitarInt();
            } catch (InputMismatchException excecao) {
               tela.solicitarTexto();
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 0:
                    return;
                default:
                    System.out.print("Resposta Inválida");
                    break;
            }
        }
    }

    private void cadastrarCliente() {
        String razaoSocial = "";
        String nome = "";
        long documento = 0;
        TipoDocumento tipoDocumento = null;
        Long cnpj = 0L;

        System.out.println("Digite se você é uma pessoa física ou jurídica: ");
        TipoPessoa tipoPessoa;
        tipoPessoa = null;
        while (tipoPessoa == null) {
            try {
                tipoPessoa = TipoPessoa.valueOf(tela.solicitarTexto().toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.out.printf("Resposta inválida, digite entre FISICA e JURIDICA: ");
            }
        }
        if (tipoPessoa.equals(TipoPessoa.JURIDICA)) {
            System.out.println("Digite seu CNPJ:");
            cnpj = tela.solicitarLong();
            tela.solicitarTexto();
            System.out.println("Digite sua razão social: ");
            razaoSocial = tela.solicitarTexto();
            System.out.println("Digite seu tipo de documento: ");
            tipoDocumento = null;
            while (tipoDocumento == null) {
                try {
                    tipoDocumento = TipoDocumento.valueOf(tela.solicitarTexto().toUpperCase());
                } catch (IllegalArgumentException excecao) {
                    System.out.printf("Resposta inválida, digite entre CPF, RG ou CNH: ");
                }
            }
            if (tipoDocumento.equals(TipoDocumento.CPF)) {
                System.out.println("Informe o CPF: ");
                documento = tela.solicitarLong();
               tela.solicitarTexto();
            } else if (tipoDocumento.equals(TipoDocumento.RG)) {
                System.out.println("Informe o RG:");
                documento = tela.solicitarLong();
                tela.solicitarTexto();
            } else if (tipoDocumento.equals(TipoDocumento.CNH)) {
                System.out.println("Informe a sua CNH: ");
                documento = tela.solicitarLong();
                tela.solicitarTexto();
            }
        } else if (tipoPessoa.equals(TipoPessoa.FISICA)) {
            System.out.println("Digite seu nome: ");
            nome = tela.solicitarTexto();
            System.out.println("Digite seu documento: ");
            documento = tela.solicitarLong();
           tela.solicitarTexto();
        }
        System.out.println("Digite seu logradouro: ");
        String logradouro = tela.solicitarTexto();
        System.out.println("Digite o número da sua casa: ");
        Integer numero = tela.solicitarInt();
        tela.solicitarTexto();
        System.out.println("Digite o complemento do seu endereço: ");
        String complemento = tela.solicitarTexto();
        System.out.println("Digite seu bairro: ");
        String bairro = tela.solicitarTexto();
        System.out.println("Digite sua cidade: ");
        String cidade = tela.solicitarTexto();
        System.out.println("Digite sua UF: ");
        String uf = tela.solicitarTexto();
        System.out.println("Digite seu CEP: ");
        Integer cep = tela.solicitarInt();
       tela.solicitarTexto();
        Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);
        Cliente cliente;
        if (tipoPessoa.equals(TipoPessoa.FISICA)) {
            cliente = new Cliente(tipoPessoa, nome, documento, endereco);
            bancoCliente.adicionar(cliente);
        } else {
            Cliente cliente1 = new Cliente(tipoPessoa, cnpj, tipoDocumento, documento, razaoSocial, endereco);
            bancoCliente.adicionar(cliente1);
        }

    }

    private void listarClientes() {
        List<Cliente> clientes = bancoCliente.getClientes();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println(String.format("   >>> [%d] --> %s", i, cliente));
            System.out.println("_");
        }

    }
}
