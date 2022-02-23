package br.com.fundatec.locadoraVeiculo.telas;

import br.com.fundatec.locadoraVeiculo.bancodedados.ClienteRepository;
import br.com.fundatec.locadoraVeiculo.bancodedados.CriacaoBaseDadoCliente;
import br.com.fundatec.locadoraVeiculo.bancodedados.CriacaoBaseDadoVeiculo;
import br.com.fundatec.locadoraVeiculo.bancodedados.VeiculoRepository;
import br.com.fundatec.locadoraVeiculo.enums.TipoPessoa;
import br.com.fundatec.locadoraVeiculo.models.Cliente;
import br.com.fundatec.locadoraVeiculo.models.Veiculo;

import java.util.List;
import java.util.Scanner;

public class TelaLocacao {
    private Scanner in = new Scanner(System.in);
    private ClienteRepository bancoCliente = ClienteRepository.criar();
    public VeiculoRepository bancoVeiculo = VeiculoRepository.criar();

    public void imprimirTelaDeLocacoes() {
        boolean continuar = true;
        while (continuar) {
            System.out.printf("");
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
                    System.out.println("Encerrar locações");
                    break;
                case 3:
                    System.out.println("Listar locações");
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
        CriacaoBaseDadoVeiculo.inicializarBase();
        for (int i = 0; i < bancoVeiculo.getVeiculos().size(); i++) {
            System.out.println(String.format("   >>> [%d] --> %s", i, bancoVeiculo.get(i)));
        }
        System.out.println("Selecione o veiculo pelo id: ");
        int numeroVeiculo = in.nextInt();
        veiculo = bancoVeiculo.selecionarVeiculo(numeroVeiculo);
    }
}


//        int contador = 0;
//        CriacaoBaseDadoVeiculo.inicializarBase();
//        for (Veiculo elemento : bancoVeiculo.getVeiculos()) {
//            System.out.println("Id: " + contador++ + "," + "Placa: " +
//                    elemento.getPlaca() + "," + " Marca: " + elemento.getMarca() + "," +
//                    " Modelo: " + elemento.getModelo() + "," + " Tipo do Veiculo: " + elemento.getTipoVeiculo() +
//                    "," + " Kilometragem: " +
//                    elemento.getKilometragem() + " Valor por Km Rodado: " + elemento.getValorKmRodado() +
//                    " Valor da diaria: " + elemento.getValorDiaria());
//            System.out.println("_");
//        }
//        System.out.println("Selecione um veículo pelo seu id: ");
//        int idVeiculo = in.nextInt();
//        CriacaoBaseDadoCliente.inicializarBase();
//        for (Cliente elemento : bancoCliente.getClientes()) {
//            if (elemento.getTipoPessoa().equals(TipoPessoa.FISICA)) {
//                System.out.println("Pessoa juridica ou fisica : " + elemento.getTipoPessoa() + "," + " Nome: " + elemento.getNome() +
//                        "," + " Documento: " + elemento.getDocumento() + "," + " Endereço: " + elemento.getEndereco().getLogradouro() +
//                        "," + elemento.getEndereco().getNumero() + "," + elemento.getEndereco().getBairro() +
//                        "," + elemento.getEndereco().getCidade() +
//                        "," + elemento.getEndereco().getUf() + " - " + elemento.getEndereco().getCep());
//            } else if (elemento.getTipoPessoa().equals(TipoPessoa.JURIDICA)) {
//                System.out.println("Pessoa juridica ou fisica : " + elemento.getTipoPessoa() + "," + " CNPJ: " + elemento.getCnpj() +
//                        "," + " Tipo de Documento: " + elemento.getTipoDocumento() + "," + " Razão Social: " + elemento.getRazaoSocial() +
//                        "," + " Endereço: " + elemento.getEndereco().getLogradouro() + "," + elemento.getEndereco().getNumero() +
//                        "," + elemento.getEndereco().getBairro() + "," + elemento.getEndereco().getCidade() +
//                        "," + elemento.getEndereco().getUf() + " - " + elemento.getEndereco().getCep());
//                System.out.println("_");
//            }
//        }
//        System.out.println("Selecione um cliente pelo seu id");
//        int idCliente = in.nextInt();
//    }
//}