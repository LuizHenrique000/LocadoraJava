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

    public Cliente(TipoPessoa tipoPessoa,String nome,Long documento, Endereco endereco) {
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Cliente(TipoPessoa tipoPessoa,Long cnpj, TipoDocumento tipoDocumento,String razaoSocial, Endereco endereco) {
        this.tipoPessoa = tipoPessoa;
        this.cnpj = cnpj;
        this.tipoDocumento = tipoDocumento;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public Long getDocumento() {
        return documento;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
