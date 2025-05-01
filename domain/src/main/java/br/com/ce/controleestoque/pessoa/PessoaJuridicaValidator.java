package br.com.ce.controleestoque.pessoa;

import br.com.ce.controleestoque.validation.Error;
import br.com.ce.controleestoque.validation.ValidationHandler;
import br.com.ce.controleestoque.validation.Validator;

public class PessoaJuridicaValidator extends Validator {

    private final PessoaJuridica pessoaJuridica;

    public PessoaJuridicaValidator(PessoaJuridica pessoaJuridica, ValidationHandler handler) {
        super(handler);
        this.pessoaJuridica = pessoaJuridica;
    }

    @Override
    public void validate() {
        checkCNPJ();
        checkRazaoSocial();
        checkNomeFantasia();
        checkInscricaoMunicipal();
        checkInscricaoEstadual();
    }

    private void checkCNPJ() {
        pessoaJuridica.getCnpj().validate(this.validationHandler());
    }

    private void checkRazaoSocial() {
        if (pessoaJuridica.getRazaoSocial() == null || pessoaJuridica.getRazaoSocial().isBlank()) {
            this.validationHandler().append(new Error("Razão Social não pode ser nula ou vazia!"));
        }
    }

    private void checkNomeFantasia() {
        if (pessoaJuridica.getNomeFantasia() == null || pessoaJuridica.getNomeFantasia().isBlank()) {
            this.validationHandler().append(new Error("Nome Fantasia não pode ser nulo ou vazio!"));
        }
    }

    private void checkInscricaoMunicipal() {
        if (pessoaJuridica.getInscricaoMunicipal() == null || pessoaJuridica.getInscricaoMunicipal().isBlank()) {
            this.validationHandler().append(new Error("Inscrição Municipal não pode ser nula ou vazia!"));
        }
    }

    private void checkInscricaoEstadual() {
        if (pessoaJuridica.getInscricaoEstadual() == null || pessoaJuridica.getInscricaoEstadual().isBlank()) {
            this.validationHandler().append(new Error("Inscrição Estadual não pode ser nula ou vazia!"));
        }
    }
}
