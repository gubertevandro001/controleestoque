package br.com.ce.controleestoque.pessoa;

import br.com.ce.controleestoque.validation.Error;
import br.com.ce.controleestoque.validation.ValidationHandler;
import br.com.ce.controleestoque.validation.Validator;

public class PessoaFisicaValidator extends Validator {

    private final PessoaFisica pessoaFisica;
    private static final Integer CARACTERES_MINIMO_NOME = 3;

    public PessoaFisicaValidator(PessoaFisica pessoaFisica, ValidationHandler handler) {
        super(handler);
        this.pessoaFisica = pessoaFisica;
    }

    @Override
    public void validate() {
        checkCPF();
        checkNome();
        checkDataNascimento();
        checkSexo();
        checkEstadoCivil();
        checkNacionalidade();
    }

    private void checkCPF() {
        pessoaFisica.getCpf().validate(this.validationHandler());
    }

    private void checkNome() {
        final var nome = pessoaFisica.getNome();

        if (nome == null || nome.isBlank()) {
            this.validationHandler().append(new Error("O Nome não pode ser nulo ou vazio!"));
            return;
        }
        if (nome.length() <= CARACTERES_MINIMO_NOME) {
            this.validationHandler().append(new Error("O Nome deve ter mais de 3 letras!"));
        }
    }

    private void checkDataNascimento() {
        final var dataNascimento = pessoaFisica.getDataNascimento();

        if (dataNascimento == null) {
            this.validationHandler().append(new Error("A Data de Nascimento não pode ser nula!"));
        }
    }

    private void checkSexo() {
        final var sexo = pessoaFisica.getSexo();

        if (sexo == null) {
            this.validationHandler().append(new Error("O Sexo não pode ser nulo!"));
        }
    }

    private void checkEstadoCivil() {
        final var estadoCivil = pessoaFisica.getEstadoCivil();

        if (estadoCivil == null) {
            this.validationHandler().append(new Error("O Estado Civil não pode ser nulo!"));
        }
    }

    private void checkNacionalidade() {
        final var nacionalidade = pessoaFisica.getNacionalidade();

        if (nacionalidade == null || nacionalidade.isBlank()) {
            this.validationHandler().append(new Error("A Nacionalidade não pode ser nula ou vazia!"));
        }
    }
}
