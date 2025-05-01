package br.com.ce.controleestoque.pessoa;

import java.util.Arrays;
import java.util.Optional;

public enum TipoEstadoCivil {

    SOLTEIRO("SOLTEIRO"),
    CASADO("CASADO"),
    DIVORCIADO("DIVORCIADO");

    private String descricao;

    TipoEstadoCivil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    public Optional<TipoEstadoCivil> of(final String descricao) {
        return Arrays.stream(TipoEstadoCivil.values())
                .filter(it -> it.descricao.equalsIgnoreCase(descricao))
                .findFirst();
    }
}
