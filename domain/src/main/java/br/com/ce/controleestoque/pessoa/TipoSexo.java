package br.com.ce.controleestoque.pessoa;

import java.util.Arrays;
import java.util.Optional;

public enum TipoSexo {

    MASCULINO("MASCULINO"),
    FEMININO("FEMININO"),
    OUTROS("OUTROS");

    private String descricao;

    TipoSexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Optional<TipoSexo> of(final String descricao) {
        return Optional.ofNullable(descricao)
                .flatMap(desc -> Arrays.stream(TipoSexo.values())
                        .filter(it -> it.descricao.equalsIgnoreCase(desc))
                        .findFirst());
    }
}
