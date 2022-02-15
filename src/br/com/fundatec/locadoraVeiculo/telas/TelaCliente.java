package br.com.fundatec.locadoraVeiculo.telas;


import br.com.fundatec.locadoraVeiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraVeiculo.enums.TipoPessoa;
import br.com.fundatec.locadoraVeiculo.models.Cliente;
import br.com.fundatec.locadoraVeiculo.models.Endereco;
import br.com.fundatec.locadoraVeiculo.bancoDeDados.ClienteRepository;
import java.util.Scanner;

public class TelaCliente {
    boolean continuar = true;
    private ClienteRepository bancoCliente = ClienteRepository.criar();
    private Scanner in = new Scanner(System.in);

    public void imprimirTelaDeClientes() {

        while (continuar) {
            System.out.println("__________TELA DE CLIENTES__________");
            System.out.println("| Digite 1 para Cadastrar Clientes |");
            System.out.println("| Digite 2 para Listar clientes    |");
            System.out.println("| Digite 0 para Retornar ao menu   |");
            System.out.println("------------------------------------");
            int opcao = in.nextInt();

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
        long documento = 0L;
        TipoDocumento tipoDocumento = null;

        System.out.println("Digite se você é uma pessoa física ou jurídica: ");
        TipoPessoa tipoPessoa = TipoPessoa.valueOf(in.next().toUpperCase());
        in.nextLine();
        if (tipoPessoa.equals(TipoPessoa.JURIDICA)) {
            System.out.println("Digite seu nome: ");
            nome = in.nextLine();
            System.out.println("Digite seu CNPJ:");
            documento = in.nextLong();
            in.nextLine();
            System.out.println("Digite sua razão social: ");
            razaoSocial = in.nextLine();
        }
        else if(tipoPessoa.equals(TipoPessoa.FISICA)) {
            System.out.println("Digite seu nome: ");
            nome = in.nextLine();
            System.out.println("Digite seu documento: ");
            documento = in.nextLong();
            in.nextLine();
            System.out.println("Digite seu tipo de documento: ");
            tipoDocumento = TipoDocumento.valueOf(in.next().toUpperCase());
            if (tipoDocumento.equals(TipoDocumento.CPF)) {
                System.out.println("Informe o CPF: ");
               documento = in.nextLong();
                in.nextLine();
            } else if (tipoDocumento.equals(TipoDocumento.RG)) {
                System.out.println("Informe o RG:");
              documento = in.nextLong();
                in.nextLine();
            }
        }
        System.out.println("Digite seu logradouro: ");
        String logradouro = in.nextLine();
        System.out.println("Digite o número da sua casa: ");
        Integer numero = in.nextInt();
        in.nextLine();
        System.out.println("Digite o complemento do seu endereço: ");
        String complemento = in.nextLine();
        System.out.println("Digite seu bairro: ");
        String bairro = in.nextLine();
        System.out.println("Digite sua cidade: ");
        String cidade = in.nextLine();
        System.out.println("Digite sua UF: ");
        String uf = in.nextLine();
        System.out.println("Digite seu CEP: ");
        Integer cep = in.nextInt();
        in.nextLine();
        Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);
        Cliente cliente = new Cliente(tipoPessoa, nome, documento, tipoDocumento, razaoSocial, endereco);
        bancoCliente.adicionar(cliente);
    }

    private void listarClientes() {
        for (Cliente elemento :
                bancoCliente.getClientes()) {
            System.out.println("Nome: " + elemento.getNome() + "\nEndereço: " + elemento.getEndereco().getLogradouro() + "\nPessoa juridica ou fisica : " + elemento.getTipoPessoa());
            System.out.println("_");
        }
    }
}
