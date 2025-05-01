package br.com.ce.controleestoque.pessoa;

import br.com.ce.controleestoque.ValueObject;
import br.com.ce.controleestoque.validation.Error;
import br.com.ce.controleestoque.validation.ValidationHandler;
import br.com.ce.controleestoque.validation.Validator;

public class CPF extends ValueObject {

    private String numero;

    private CPF(String numero) {
        this.numero = numero;
    }

    public static CPF novoCPF(String numero) {
        return new CPF(numero);
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public void validate(ValidationHandler handler) {
        new CPFValidator(this, handler);
    }

    static class CPFValidator extends Validator {

        private final CPF cpf;

        CPFValidator(CPF cpf, ValidationHandler handler) {
            super(handler);
            this.cpf = cpf;
        }

        @Override
        public void validate() {
            checkCpf();
        }

        private void checkCpf() {
            final var numeroCpf = cpf.getNumero();

            if (numeroCpf == null || numeroCpf.isEmpty()) {
                this.validationHandler().append(new Error("O CPF não pode ser nulo ou vazio!"));
                return;
            }

            final var value = numeroCpf.replaceAll("[^0-9]", "");

            if (value.length() != 11) {
                this.validationHandler().append(new Error("CPF deve conter 11 dígitos!"));
                return;
            }

            if (value.matches("(\\d)\\1{10}")) {
                this.validationHandler().append(new Error("CPF inválido, sequência repetida"));
                return;
            }

            int[] p1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] p2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

            int digito1 = verificador(value.substring(0, 9), p1);
            int digito2 = verificador(value.substring(0, 9) + digito1, p2);

            if (!value.equals(value.substring(0, 9) + digito1 + digito2)) {
                this.validationHandler().append(new Error("CPF Inválido, dígitos verificadores não conferem"));
            }
        }

        private int verificador(String base, int[] p) {
            int soma = 0;
            for (int i = 0; i < p.length; i++) {
                soma += (base.charAt(i) - '0') * p[i];
            }
            int resto = soma % 11;
            return (resto < 2) ? 0 : (11 - resto);
        }
    }
}
