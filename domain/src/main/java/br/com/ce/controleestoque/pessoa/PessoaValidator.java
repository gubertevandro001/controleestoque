package br.com.ce.controleestoque.pessoa;

import br.com.ce.controleestoque.validation.Error;
import br.com.ce.controleestoque.validation.ValidationHandler;
import br.com.ce.controleestoque.validation.Validator;

public class PessoaValidator extends Validator {

    private final Pessoa pessoa;

    public PessoaValidator(Pessoa pessoa, ValidationHandler handler) {
        super(handler);
        this.pessoa = pessoa;
    }

    @Override
    public void validate() {
        checkTipoPessoa();
        checkTelefoneCelular();
        checkEnderecoes();
    }

    private void checkTipoPessoa() {
        if (pessoa.getTipoPessoa() == null) {
            this.validationHandler().append(new Error("Tipo de pessoa não pode ser nulo"));
        }
    }

    private void checkTelefoneCelular() {
        if (pessoa.getTelefoneCelular() == null || pessoa.getTelefoneCelular().isBlank()) {
            this.validationHandler().append(new Error("Telefone celular não pode ser nulo ou vazio"));
        }
    }

    private void checkEnderecoes() {
        if (pessoa.getEnderecos() == null || pessoa.getEnderecos().isEmpty()) {
            this.validationHandler().append(new Error("Endereços não podem ser nulos ou vazios"));
        }
    }
}
