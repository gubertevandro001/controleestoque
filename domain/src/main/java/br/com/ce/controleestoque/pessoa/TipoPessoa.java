package br.com.ce.controleestoque.pessoa;

import java.util.Arrays;
import java.util.Optional;

public enum TipoPessoa {
    FISICA("FISICA"),
    JURIDICA("JURIDICA");

    private String descricao;

    TipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


    public Optional<TipoPessoa> of(final String descricao) {
        return Arrays.stream(TipoPessoa.values())
                .filter(it -> it.descricao.equalsIgnoreCase(descricao))
                .findFirst();
    }
}