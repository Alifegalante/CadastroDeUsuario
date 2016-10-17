package alife.g.cadastrousuario.model.domain;

/**
 *
 * @author Administrador
 */
public class Produto {

    private Integer codigo;
    private String descricao;
    private int tipo;
    private double valor;
    private double estoque;
    private int situacao;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Produto() {
        this.estoque = 0.0;
        this.situacao = 1;
        this.tipo = 1;
        this.valor = 0.0;
    }

}
