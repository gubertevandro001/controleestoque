package br.com.ce.controleestoque.pessoa;

import br.com.ce.controleestoque.Identifier;
import br.com.ce.controleestoque.utils.IdUtils;
import br.com.ce.controleestoque.validation.Error;
import br.com.ce.controleestoque.validation.ValidationHandler;
import br.com.ce.controleestoque.validation.Validator;

import java.util.Objects;

public class PessoaID extends Identifier {

    private String value;

    private PessoaID(String value) {
        this.value = value;
    }

    public static PessoaID novoId() {
        return new PessoaID(IdUtils.uuid());
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PessoaID pessoaID = (PessoaID) o;
        return Objects.equals(value, pessoaID.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public void validate(ValidationHandler handler) {
        new PessoaIDValidator(this, handler);
    }

    static class PessoaIDValidator extends Validator {

        private final PessoaID pessoaId;

        public PessoaIDValidator(PessoaID pessoaId, ValidationHandler handler) {
            super(handler);
            this.pessoaId = pessoaId;
        }

        @Override
        public void validate() {
            checkId();
        }

        private void checkId() {
            final var id = pessoaId.getValue();

            if (id == null || id.isEmpty()) {
                this.validationHandler().append(new Error("O ID da Pessoa não pode ser nulo ou vazio!"));
            }
        }
    }
}
