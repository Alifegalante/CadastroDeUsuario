package alife.g.cadastrousuario.model.domain;

/**
 *
 * @author Administrador
 */
public class Cliente {
    private Integer codigo;
    private String nome;
    private String cpfCnpj;
    private int limiteDesconto;
    private int situacao;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public int getLimiteDesconto() {
        return limiteDesconto;
    }

    public void setLimiteDesconto(int limiteDesconto) {
        this.limiteDesconto = limiteDesconto;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Cliente() {
        
    }
    
    
}
