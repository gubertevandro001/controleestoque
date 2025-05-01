package br.com.ce.controleestoque.pessoa;

import br.com.ce.controleestoque.ValueObject;
import br.com.ce.controleestoque.validation.Error;
import br.com.ce.controleestoque.validation.ValidationHandler;
import br.com.ce.controleestoque.validation.Validator;

public class CNPJ extends ValueObject {

    private String numero;

    private CNPJ(String numero) {
        this.numero = numero;
    }

    public static CNPJ novoCNPJ(String numero) {
        return new CNPJ(numero);
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public void validate(ValidationHandler handler) {
        new CNPJValidator(this, handler);
    }

    static class CNPJValidator extends Validator {

        private final CNPJ cnpj;

        CNPJValidator(CNPJ cnpj, ValidationHandler handler) {
            super(handler);
            this.cnpj = cnpj;
        }

        @Override
        public void validate() {
            checkCNPJ();
        }

        private void checkCNPJ() {
            final var numeroCnpj = cnpj.getNumero();

            if (numeroCnpj == null || numeroCnpj.isEmpty()) {
                this.validationHandler().append(new Error("CNPJ não pode ser nulo ou vazio!"));
                return;
            }

            final var cnpjConvertido = numeroCnpj.replaceAll("[^0-9]", "");

            if (cnpjConvertido.length() != 14) {
                this.validationHandler().append(new Error("CNPJ deve conter 14 dígitos numéricos"));
                return;
            }

            if (cnpjConvertido.matches("(\\d)\\1{13}")) {
                this.validationHandler().append(new Error("CNPJ inválido, sequência repetida"));
                return;
            }

            int[] p1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] p2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

            int digito1 = verificador(cnpjConvertido.substring(0, 12), p1);
            int digito2 = verificador(cnpjConvertido.substring(0, 12) + digito1, p2);

            if (!cnpjConvertido.equals(cnpjConvertido.substring(0, 12) + digito1 + digito2)) {
                this.validationHandler().append(new Error("CNPJ inválido, dígitos verificadores não conferem"));
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
