package br.com.ce.controleestoque;

import br.com.ce.controleestoque.validation.ValidationHandler;

public abstract class Entity<ID extends Identifier> {

    private ID id;

    public Entity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public abstract void validate(ValidationHandler handler);
}
