package br.com.ce.controleestoque.pessoa;

import br.com.ce.controleestoque.Entity;
import br.com.ce.controleestoque.endereco.Endereco;
import br.com.ce.controleestoque.utils.InstantUtils;
import br.com.ce.controleestoque.validation.ValidationHandler;

import java.time.Instant;
import java.util.List;

public class Pessoa extends Entity<PessoaID> {

    private TipoPessoa tipoPessoa;
    private String telefoneFixo;
    private String telefoneCelular;
    private String email;
    private Instant dataCadastro;
    private Instant dataAlteracao;
    private List<Endereco> enderecos;

    public Pessoa(final PessoaID pessoaId,
                  final TipoPessoa tipoPessoa,
                  final String telefoneFixo,
                  final String telefoneCelular,
                  final String email,
                  final Instant dataCadastro,
                  final Instant dataAlteracao,
                  final List<Endereco> enderecos
    ) {
        super(pessoaId);
        this.tipoPessoa = tipoPessoa;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
        this.enderecos = enderecos;
    }

    public static Pessoa novaPessoa(final TipoPessoa tipoPessoa,
                             final String telefoneFixo,
                             final String telefoneCelular,
                             final String email,
                             final List<Endereco> enderecos
    ) {
        final var id = PessoaID.novoId();
        final var data = InstantUtils.now();
        return new Pessoa(id, tipoPessoa, telefoneFixo, telefoneCelular, email, data, data, enderecos);
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public String getEmail() {
        return email;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public Instant getDataAlteracao() {
        return dataAlteracao;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    @Override
    public void validate(ValidationHandler handler) {
        new PessoaValidator(this, handler).validate();
    }
}
