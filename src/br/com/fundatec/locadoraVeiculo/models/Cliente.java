package br.com.fundatec.locadoraVeiculo.models;

import br.com.fundatec.locadoraVeiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraVeiculo.enums.TipoPessoa;

public class Cliente {
    private TipoPessoa tipoPessoa;
    private String nome;
    private Long cnpj;
    private TipoDocumento tipoDocumento;
    private Long documento;
    private String razaoSocial;
    private Endereco endereco;

    public Cliente(Long cnpj, String razaoSocial, Endereco endereco) {
        this.tipoPessoa = TipoPessoa.JURIDICA;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
    }

    public Cliente(String nome, TipoDocumento tipoDocumento, Long documento, Endereco endereco) {
        this.tipoPessoa = TipoPessoa.FISICA;
        this.nome = nome;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.endereco = endereco;
    }


    @Override
    public String toString() {
        return "Cliente [" + "tipoPessoa=" + tipoPessoa + ", nome='" + nome + '\'' + ", cnpj=" + cnpj + ", tipoDocumento=" + tipoDocumento + ", documento=" + documento + ", razaoSocial='" + razaoSocial + '\'' + ", endereco=" + endereco + ']';
    }
}
