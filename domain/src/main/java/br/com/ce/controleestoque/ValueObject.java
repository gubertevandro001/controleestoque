package br.com.ce.controleestoque;

import br.com.ce.controleestoque.validation.ValidationHandler;

public abstract class ValueObject {

    public abstract void validate(ValidationHandler handler);
}
