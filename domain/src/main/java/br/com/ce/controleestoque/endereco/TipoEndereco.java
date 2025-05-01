package br.com.ce.controleestoque.endereco;

import java.util.Arrays;
import java.util.Optional;

public enum TipoEndereco {

    PRINCIPAL("PRINCIPAL"),
    SECUNDARIO("SECUNDARIO"),
    COBRANCA("COBRANCA"),
    ENTREGA("ENTREGA");

    private String descricao;

    TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    public Optional<TipoEndereco> of(final String descricao) {
        return Arrays.stream(TipoEndereco.values())
                .filter(it -> it.descricao.equalsIgnoreCase(descricao))
                .findFirst();
    }
}
