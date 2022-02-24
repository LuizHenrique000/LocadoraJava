package br.com.fundatec.locadoraVeiculo.telas;

import br.com.fundatec.locadoraVeiculo.bancodedados.ClienteRepository;
import br.com.fundatec.locadoraVeiculo.bancodedados.LocacaoRepository;
import br.com.fundatec.locadoraVeiculo.bancodedados.VeiculoRepository;

import br.com.fundatec.locadoraVeiculo.models.Cliente;
import br.com.fundatec.locadoraVeiculo.models.Locacao;
import br.com.fundatec.locadoraVeiculo.models.Veiculo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TelaLocacao {
    private Scanner in = new Scanner(System.in);
    private ClienteRepository bancoCliente = ClienteRepository.criar();
    public VeiculoRepository bancoVeiculo = VeiculoRepository.criar();
    public LocacaoRepository bancoLocacao = LocacaoRepository.criar();

    public void imprimirTelaDeLocacoes() {
        boolean continuar = true;
        while (continuar) {
            System.out.println();
            System.out.println("_________TELA DE LOCAÇÕES___________");
            System.out.println("| Digite 1 para Cadastrar Locações |");
            System.out.println("| Digite 2 para Encerrar Locações  |");
            System.out.println("| Digite 3 para Listar Locações    |");
            System.out.println("| Digite 0 para Retornar ao Menu   |");
            System.out.println("------------------------------------");
            int opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarLocacao();
                    break;
                case 2:
                    encerrarLocacoes();
                    break;
                case 3:
                    listarLocacoes();
                    break;
                case 0:
                    return;
                default:
                    System.out.print("Resposta Inválida");
            }
        }
    }

    private void cadastrarLocacao() {
        System.out.println("Veiculos:");
        List<Veiculo> veiculos = bancoVeiculo.getVeiculos();
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            System.out.println(String.format("   >>> [%d] --> %s", i, veiculo));
        }
        System.out.println("Selecione o veiculo pelo id: ");
        int numeroVeiculo = in.nextInt();
        Veiculo veiculo = bancoVeiculo.selecionarVeiculo(numeroVeiculo);
        System.out.println();
        System.out.printf("Clientes:");
        System.out.println();
        List<Cliente> clientes = bancoCliente.getClientes();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println(String.format("   >>> [%d] --> %s", i, cliente));
        }
        System.out.println();
        System.out.printf("Selecione o cliente por id: ");
        int numeroCliente = in.nextInt();
        in.nextLine();
        Cliente cliente = bancoCliente.selecionarCliente(numeroCliente);
        System.out.printf("Digite a data de locação: ");
        LocalDate dataLocacao = LocalDate.parse(in.nextLine());
        Locacao locacao = new Locacao(cliente, veiculo, dataLocacao);
        bancoLocacao.adicionar(locacao);
    }

    private void listarLocacoes() {
        List<Locacao> locacoes = bancoLocacao.getLocacoes();
        for (int i = 0; i < locacoes.size(); i++) {
            Locacao locacao = locacoes.get(i);
            System.out.println(String.format("   >>> [%d] --> %s", i, locacoes));
        }

    }

    public void encerrarLocacoes() {
        List<Locacao> locacoes = bancoLocacao.getLocacoes();
        for (int i = 0; i < locacoes.size(); i++) {
            Locacao locacao = locacoes.get(i);
            System.out.println(String.format("   >>> [%d] --> %s", i, locacoes));
        }
        System.out.printf("Escolha a locação a ser encerrada: ");
        int numeroLocacao = in.nextInt();
        in.nextLine();
        Locacao locacao = bancoLocacao.selecionarLocacao(numeroLocacao);
        System.out.printf("Digite a data de entrega: ");
        LocalDate dataEntrega = LocalDate.parse(in.nextLine());
        System.out.printf("Digite a kilometragem atual: ");
        Float kilometragemAtual = in.nextFloat();
        locacao.encerrar(dataEntrega, kilometragemAtual);
        System.out.println("_______________CONTA FINALIZADA_________________");
        System.out.println("| Kilometragem atual: " + kilometragemAtual      );
        System.out.println("| Data de entrega: " + dataEntrega               );
        System.out.println("| Valor total: " + locacao.valor                 );
        System.out.println("------------------------------------------------");
    }
}

