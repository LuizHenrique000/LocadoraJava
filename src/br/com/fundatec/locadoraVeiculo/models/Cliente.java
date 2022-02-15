package br.com.fundatec.locadoraVeiculo.models;

import br.com.fundatec.locadoraVeiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraVeiculo.enums.TipoPessoa;

public class Cliente {
    private TipoPessoa tipoPessoa;
    private String nome;
    private long documento;
    private TipoDocumento tipoDocumento;
    private String razaoSocial;
    private Endereco endereco;

    public Cliente(TipoPessoa tipoPessoa, String nome, long documento, TipoDocumento tipoDocumento, String razaoSocial,
                   Endereco endereco) {
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
        this.documento = documento;
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

    public long getDocumento() {
        return documento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

}
