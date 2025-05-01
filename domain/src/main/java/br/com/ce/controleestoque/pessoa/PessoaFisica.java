package br.com.ce.controleestoque.pessoa;

import br.com.ce.controleestoque.endereco.Endereco;
import br.com.ce.controleestoque.utils.InstantUtils;
import br.com.ce.controleestoque.validation.ValidationHandler;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class PessoaFisica extends Pessoa {

    private String nome;
    private CPF cpf;
    private LocalDate dataNascimento;
    private TipoSexo sexo;
    private TipoEstadoCivil estadoCivil;
    private String nacionalidade;

    private PessoaFisica(final PessoaID pessoaId,
                         final TipoPessoa tipoPessoa,
                         final String telefoneFixo,
                         final String telefoneCelular,
                         final String email,
                         final Instant dataCadastro,
                         final Instant dataAlteracao,
                         final String nome,
                         final List<Endereco> enderecos,
                         final String nacionalidade,
                         final TipoEstadoCivil estadoCivil,
                         final TipoSexo sexo,
                         final LocalDate dataNascimento,
                         final CPF cpf
    ) {
        super(pessoaId, tipoPessoa, telefoneFixo, telefoneCelular, email, dataCadastro, dataAlteracao, enderecos);
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public static PessoaFisica novaPessoaFisica(final PessoaID pessoaId,
                                                final TipoPessoa tipoPessoa,
                                                final String telefoneFixo,
                                                final String telefoneCelular,
                                                final String email,
                                                final String nome,
                                                final List<Endereco> enderecos,
                                                final String nacionalidade,
                                                final TipoEstadoCivil estadoCivil,
                                                final TipoSexo sexo,
                                                final LocalDate dataNascimento,
                                                final CPF cpf
    ) {
        final var data = InstantUtils.now();
        return new PessoaFisica(pessoaId, tipoPessoa, telefoneFixo, telefoneCelular, email, data, data, nome, enderecos,
                nacionalidade, estadoCivil, sexo, dataNascimento, cpf);
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public TipoEstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public CPF getCpf() {
        return cpf;
    }

    @Override
    public void validate(ValidationHandler handler) {
        new PessoaFisicaValidator(this, handler).validate();
    }
}

