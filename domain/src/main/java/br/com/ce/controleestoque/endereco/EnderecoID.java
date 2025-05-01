package br.com.ce.controleestoque.endereco;

import br.com.ce.controleestoque.Identifier;
import br.com.ce.controleestoque.utils.IdUtils;
import br.com.ce.controleestoque.validation.Error;
import br.com.ce.controleestoque.validation.ValidationHandler;
import br.com.ce.controleestoque.validation.Validator;

import java.util.Objects;

public class EnderecoID extends Identifier {

    private String value;

    private EnderecoID(String value) {
        this.value = value;
    }

    public static EnderecoID novoId() {
        return new EnderecoID(IdUtils.uuid());
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void validate(ValidationHandler handler) {
        new EnderecoIDValidator(this, handler);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoID that = (EnderecoID) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    static class EnderecoIDValidator extends Validator {

        private final EnderecoID enderecoId;

        public EnderecoIDValidator(EnderecoID enderecoId, ValidationHandler handler) {
            super(handler);
            this.enderecoId = enderecoId;
        }

        @Override
        public void validate() {
            chechkId();
        }

        private void chechkId() {
            final var id = enderecoId.getValue();

            if (id == null || id.isEmpty()) {
                this.validationHandler().append(new Error("O ID do Endereço não pode ser nulo ou vazio!"));
            }
        }
    }
}
