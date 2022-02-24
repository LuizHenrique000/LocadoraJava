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

    public Cliente(TipoPessoa tipoPessoa, String nome, Long documento, Endereco endereco) {
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Cliente(TipoPessoa tipoPessoa, Long cnpj, TipoDocumento tipoDocumento, Long documento, String razaoSocial, Endereco endereco) {
        this.tipoPessoa = tipoPessoa;
        this.cnpj = cnpj;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente [" + "tipoPessoa=" + tipoPessoa + ", nome='" + nome + '\'' + ", cnpj=" + cnpj + ", tipoDocumento=" + tipoDocumento + ", documento=" + documento + ", razaoSocial='" + razaoSocial + '\'' + ", endereco=" + endereco + ']';
    }
}
