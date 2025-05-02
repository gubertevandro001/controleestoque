package br.com.ce.controleestoque.endereco;

import br.com.ce.controleestoque.validation.Error;
import br.com.ce.controleestoque.validation.ValidationHandler;
import br.com.ce.controleestoque.validation.Validator;

public class EnderecoValidator extends Validator {

    private final Endereco endereco;

    public EnderecoValidator(Endereco endereco, ValidationHandler handler) {
        super(handler);
        this.endereco = endereco;
    }

    @Override
    public void validate() {
        checkLogradouro();
        checkNumero();
        checkBairro();
        checkCidade();
        checkEstado();
        checkCep();
        checkPessoaId();
        checkTipoEndereco();
    }

    private void checkLogradouro() {
        if (endereco.getLogradouro() == null || endereco.getLogradouro().isBlank()) {
            this.validationHandler().append(new Error("Logradouro não pode ser nulo ou vazio!"));
        }
    }

    private void checkNumero() {
        if (endereco.getNumero() == null || endereco.getNumero().isBlank()) {
            this.validationHandler().append(new Error("Número não pode ser nulo ou vazio!"));
        }
    }

    private void checkBairro() {
        if (endereco.getBairro() == null || endereco.getBairro().isBlank()) {
            this.validationHandler().append(new Error("Bairro não pode ser nulo ou vazio!"));
        }
    }

    private void checkCidade() {
        if (endereco.getCidade() == null || endereco.getCidade().isBlank()) {
            this.validationHandler().append(new Error("Cidade não pode ser nula ou vazia!"));
        }
    }

    private void checkEstado() {
        if (endereco.getEstado() == null || endereco.getEstado().isBlank()) {
            this.validationHandler().append(new Error("Estado não pode ser nulo ou vazio!"));
        }
    }

    private void checkCep() {
        if (endereco.getCep() == null || endereco.getCep().isBlank()) {
            this.validationHandler().append(new Error("CEP não pode ser nulo ou vazio!"));
        }
    }

    private void checkPessoaId() {
        if (endereco.getPessoaId() == null) {
            this.validationHandler().append(new Error("ID da Pessoa não pode ser nulo!"));
        }
    }

    private void checkTipoEndereco() {
        if (endereco.getTipoEndereco() == null) {
            this.validationHandler().append(new Error("Tipo de Endereço não pode ser nulo!"));
        }
    }
}
