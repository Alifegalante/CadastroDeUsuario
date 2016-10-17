package alife.g.cadastrousuario.model.dao;

import alife.g.cadastrousuario.model.domain.Cliente;
import alife.g.cadastrousuario.services.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ClienteDao {

    private Connection conn;

    public ClienteDao() {
        try {
            this.conn = Conexao.getInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean salvar(Cliente obj) {
        Integer codigo = obj.getCodigo();
        String nome = obj.getNome();
        String cpfNpj = obj.getCpfCnpj();
        Integer limite = obj.getLimiteDesconto();
        Integer situacao = obj.getSituacao();

        StringBuilder sql = new StringBuilder();
        if (codigo == null) {
            sql.append("insert into cliente");
            sql.append(" (codigo, nome, cpfnpj, limite_desconto, situacao ");
            sql.append(" ) ");
            sql.append(" values ( ( select coalesce(max(x.codigo), ? )+1 as ID from cliente x ) ,?, ?, ?, ? ) ");
            try {
                PreparedStatement stm = this.conn.prepareStatement(sql.toString());
                stm.setString(2, nome);
                stm.setString(3, cpfNpj);
                stm.setInt(4, limite);
                stm.setInt(5, situacao);
                stm.setInt(1, 0);
                stm.execute();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            sql.append("update cliente set");
            sql.append(" nome = ? ");
            sql.append(" , cpfnpj = ? ");
            sql.append(" , limite_desconto = ? ");
            sql.append(" , situacao = ? ");
            sql.append(" where codigo = ?");

            try {
                PreparedStatement stm = this.conn.prepareStatement(sql.toString());
                stm.setString(1, nome);
                stm.setString(2, cpfNpj);
                stm.setInt(3, limite);
                stm.setInt(4, situacao);
                stm.setInt(5, codigo);
                stm.execute();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean excluir(Cliente obj) {
        Integer codigo = obj.getCodigo();
        StringBuilder sql = new StringBuilder();
        sql.append("delete from cliente where codigo = ?");
        try {
            PreparedStatement stm = this.conn.prepareStatement(sql.toString());
            stm.setInt(1, codigo);
            stm.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listar() {
        List<Cliente> lst = new ArrayList<Cliente>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from cliente");
        try {
            PreparedStatement stm
                    = this.conn.prepareStatement(sql.toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Cliente m = new Cliente();
                m.setCodigo(rs.getInt("codigo"));
                m.setNome(rs.getString("nome"));
                m.setCpfCnpj(rs.getString("cpfnpj"));
                m.setLimiteDesconto(rs.getInt("limite_desconto"));
                m.setSituacao(rs.getInt("situacao"));
                lst.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }
}
