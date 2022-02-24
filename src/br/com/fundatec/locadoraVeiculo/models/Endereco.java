package br.com.fundatec.locadoraVeiculo.models;

public class Endereco {
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private Integer cep;

    public Endereco(String logradouro, Integer numero, String complemento, String bairro, String cidade, String uf,
                    Integer cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco [" +
                "logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", cep=" + cep +
                ']';
    }
}
