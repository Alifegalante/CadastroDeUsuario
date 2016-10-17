package alife.g.cadastrousuario.model.dao;

import alife.g.cadastrousuario.model.domain.Grupo;
import alife.g.cadastrousuario.model.domain.Usuario;
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
public class GrupoDao {

    private Connection conn;

    public GrupoDao() {
        try {
            this.conn = Conexao.getInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean salvar(Grupo obj) {
        Integer codigo = obj.getCodigo();
        String nome = obj.getNome();
     
        StringBuilder sql = new StringBuilder();
        if (codigo == null) {
            sql.append("insert into grupo");
            sql.append(" (codigo, nome ");
            sql.append(" ) ");
            sql.append(" values ( ( select coalesce(max(x.codigo), ? )+1 as ID from grupo x ) ,? ) ");
            try {
                PreparedStatement stm = this.conn.prepareStatement(sql.toString());
                stm.setString(2, nome);
                stm.setInt(1, 0);
                stm.execute();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            sql.append("update grupo set");
            sql.append(" nome = ? ");
            sql.append(" where codigo = ?");

            try {
                PreparedStatement stm = this.conn.prepareStatement(sql.toString());
                stm.setString(1, nome);
                stm.setInt(2, codigo);
                stm.execute();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean excluir(Grupo obj) {
        Integer codigo = obj.getCodigo();
        StringBuilder sql = new StringBuilder();
        sql.append("delete from grupo where codigo = ?");
        try {
            PreparedStatement stm = this.conn.prepareStatement(sql.toString());
            stm.setInt(1, codigo);
            stm.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public List<Grupo> listar() {
        List<Grupo> lst = new ArrayList<Grupo>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from grupo");
        try {
            PreparedStatement stm
                    = this.conn.prepareStatement(sql.toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Grupo m = new Grupo();
                m.setCodigo(rs.getInt("codigo"));
                m.setNome(rs.getString("nome"));
                lst.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }
}
