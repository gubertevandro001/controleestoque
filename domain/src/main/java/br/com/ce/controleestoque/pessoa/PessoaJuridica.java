package br.com.ce.controleestoque.pessoa;

import br.com.ce.controleestoque.endereco.Endereco;
import br.com.ce.controleestoque.utils.InstantUtils;
import br.com.ce.controleestoque.validation.ValidationHandler;

import java.time.Instant;
import java.util.List;

public class PessoaJuridica extends Pessoa {

    private CNPJ cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String inscricaoMunicipal;
    private String inscricaoEstadual;

    private PessoaJuridica(final PessoaID pessoaId,
                           final TipoPessoa tipoPessoa,
                           final String telefoneFixo,
                           final String telefoneCelular,
                           final String email,
                           final Instant dataCadastro,
                           final Instant dataAlteracao,
                           final List<Endereco> enderecos,
                           final CNPJ cnpj,
                           final String razaoSocial,
                           final String nomeFantasia,
                           final String inscricaoMunicipal,
                           final String inscricaoEstadual
    ) {
        super(pessoaId, tipoPessoa, telefoneFixo, telefoneCelular, email, dataCadastro, dataAlteracao, enderecos);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public static PessoaJuridica novaPessoaJuridica(final PessoaID pessoaId,
                                                    final TipoPessoa tipoPessoa,
                                                    final String telefoneFixo,
                                                    final String telefoneCelular,
                                                    final String email,
                                                    final List<Endereco> enderecos,
                                                    final CNPJ cnpj,
                                                    final String razaoSocial,
                                                    final String nomeFantasia,
                                                    final String inscricaoMunicipal,
                                                    final String inscricaoEstadual
    ) {
        final var data = InstantUtils.now();
        return new PessoaJuridica(pessoaId, tipoPessoa, telefoneFixo, telefoneCelular, email, data, data,
                enderecos, cnpj, razaoSocial, nomeFantasia, inscricaoMunicipal, inscricaoEstadual);
    }

    public CNPJ getCnpj() {
        return cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    @Override
    public void validate(ValidationHandler handler) {
        new PessoaJuridicaValidator(this, handler).validate();
    }
}
