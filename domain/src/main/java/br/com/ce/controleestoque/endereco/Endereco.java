package br.com.ce.controleestoque.endereco;

import br.com.ce.controleestoque.Entity;
import br.com.ce.controleestoque.pessoa.PessoaID;
import br.com.ce.controleestoque.utils.InstantUtils;
import br.com.ce.controleestoque.validation.ValidationHandler;

import java.time.Instant;

public class Endereco extends Entity<EnderecoID> {

    private PessoaID pessoaId;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private TipoEndereco tipoEndereco;
    private Instant dataCadastro;
    private Instant dataAlteracao;

    private Endereco(final EnderecoID enderecoID,
                     final PessoaID pessoaId,
                     final TipoEndereco tipoEndereco,
                     final String cep,
                     final String estado,
                     final  String bairro,
                     final String complemento,
                     final String logradouro,
                     final String numero,
                     final String cidade,
                     final  Instant dataCadastro,
                     final  Instant dataAlteracao
    ) {
        super(enderecoID);
        this.pessoaId = pessoaId;
        this.tipoEndereco = tipoEndereco;
        this.cep = cep;
        this.estado = estado;
        this.bairro = bairro;
        this.complemento = complemento;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
    }

    public static Endereco novoEndereco(PessoaID pessoaId, TipoEndereco tipoEndereco, String cep, String estado,
                                        String bairro, String complemento, String logradouro, String numero, String cidade
    ) {
        final var id = EnderecoID.novoId();
        final var data = InstantUtils.now();
        return new Endereco(id, pessoaId, tipoEndereco, cep, estado, bairro, complemento, logradouro, numero, cidade, data, data);
    }

    public Instant getDataAlteracao() {
        return dataAlteracao;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getNumero() {
        return numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public PessoaID getPessoaId() {
        return pessoaId;
    }

    @Override
    public void validate(ValidationHandler handler) {

    }
}
