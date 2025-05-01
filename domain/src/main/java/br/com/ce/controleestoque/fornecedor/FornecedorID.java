package br.com.ce.controleestoque.fornecedor;

import br.com.ce.controleestoque.Identifier;
import br.com.ce.controleestoque.utils.IdUtils;
import br.com.ce.controleestoque.validation.ValidationHandler;

public class FornecedorID extends Identifier {

    private String value;

    private FornecedorID(String value) {
        this.value = value;
    }

    public static FornecedorID novoId() {
        return new FornecedorID(IdUtils.uuid());
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void validate(ValidationHandler handler) {

    }
}
