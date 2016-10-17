package alife.g.cadastrousuario.model.dao;

import alife.g.cadastrousuario.model.domain.Produto;
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
public class ProdutoDao {

    private Connection conn;

    public ProdutoDao() {
        try {
            this.conn = Conexao.getInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean salvar(Produto obj) {
        Integer codigo = obj.getCodigo();
        String descricao = obj.getDescricao();
        int tipo = obj.getTipo();
        double valor = obj.getValor();
        double estoque = obj.getEstoque();
        int situacao = obj.getSituacao();

        StringBuilder sql = new StringBuilder();
        if (codigo == null) {
            sql.append("insert into produto");
            sql.append(" (codigo, descricao, tipo, valor, estoque, situacao ");
            sql.append(" ) ");
            sql.append(" values ( ( select coalesce(max(x.codigo), ? )+1 as ID from produto x ) ,? , ");
            sql.append(" ?, ?, ?, ? ) ");
            try {
                PreparedStatement stm = this.conn.prepareStatement(sql.toString());
                stm.setString(2, descricao);
                stm.setInt(3, tipo);
                stm.setDouble(4, valor);
                stm.setDouble(5, estoque);
                stm.setInt(6, situacao);
                stm.setInt(1, 0);
                stm.execute();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            sql.append("update produto set");
            sql.append(" descricao = ?, tipo = ?, valor = ?, estoque = ?, situacao = ? ");
            sql.append(" where codigo = ?");

            try {
                PreparedStatement stm = this.conn.prepareStatement(sql.toString());
                stm.setString(1, descricao);
                stm.setInt(2, tipo);
                stm.setDouble(3, valor);
                stm.setDouble(4, estoque);
                stm.setInt(5, situacao);
                stm.setInt(6, codigo);
                stm.execute();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean excluir(Produto obj) {
        Integer codigo = obj.getCodigo();
        StringBuilder sql = new StringBuilder();
        sql.append("delete from produto where codigo = ?");
        try {
            PreparedStatement stm = this.conn.prepareStatement(sql.toString());
            stm.setInt(1, codigo);
            stm.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produto> listar() {
        List<Produto> lst = new ArrayList<Produto>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from produto");
        try {
            PreparedStatement stm
                    = this.conn.prepareStatement(sql.toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Produto m = new Produto();
                m.setCodigo(rs.getInt("codigo"));
                m.setDescricao(rs.getString("descricao"));
                m.setTipo(rs.getInt("tipo"));
                m.setValor(rs.getDouble("valor"));
                m.setEstoque(rs.getDouble("estoque"));
                m.setSituacao(rs.getInt("situacao"));
                lst.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }
}
