package alife.g.cadastrousuario.model.dao;

import alife.g.cadastrousuario.model.domain.Acl;
import alife.g.cadastrousuario.model.domain.ServicoDoSistema;
import alife.g.cadastrousuario.model.domain.Usuario;
import alife.g.cadastrousuario.services.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AclDao {
    
    private Connection cnx; 
    private String sqlSelect;
            
        public AclDao() throws SQLException {
            this.cnx = Conexao.getInstance();
            this.sqlSelect = "select * from acl ";
    }
    
    public void salvar(Acl a) throws SQLException {
        StringBuilder sql = new StringBuilder();
        Integer codigoServico = a.getCodigoServico();
        Integer codigoUsuario = a.getCodigoUsuario();
        Integer nivel = a.getNivel();
        PreparedStatement ps;
        
        if (this.getByPk(codigoUsuario, codigoServico).getCodigoServico() != null) {
            //update
            sql.append("update acl set nivel = ? where codigo_usuario = ?");
            sql.append("and codigo_servico = ?");
            ps = this.cnx.prepareStatement(sql.toString());
            ps.setInt(1, nivel);
            ps.setInt(2, codigoUsuario);
            ps.setInt(3, codigoServico);
            
        } else {
            //insert
            sql.append("insert into acl (codigo_usuario, codigo_servico, nivel )");
            sql.append("values (?, ?, ?) ");
            ps = this.cnx.prepareStatement(sql.toString());
            ps.setInt(3, nivel);
            ps.setInt(1, codigoUsuario);
            ps.setInt(2, codigoServico);
        }    
        ps.execute();
    }        


   public void remover(Acl a) throws SQLException {
    StringBuilder sql = new StringBuilder("Delete from acl ");
    sql.append(" where codigo_usuario = ? and codigo_servico = ? ");
    PreparedStatement ps = this.cnx.prepareStatement(sql.toString());
    ps.setInt(1, a.getCodigoUsuario());
    ps.setInt(2, a.getCodigoServico());
    ps.execute();
     
   }    
   
   public List<Acl> listar(Usuario u) throws SQLException {
       StringBuilder sql = new StringBuilder(this.sqlSelect);
       sql.append("where codigo_usuario = ? ");
       PreparedStatement ps = this.cnx.prepareStatement(sql.toString());
       ps.setInt(1, u.getCodigo());
       ps.execute();
       return this.hydrator(ps.getResultSet());
   }
   
   private List<Acl> hydrator(ResultSet rs) throws SQLException {
     List<Acl> lista = new ArrayList<Acl>();
     while (rs.next()) {
        Acl acl = new Acl();
        acl.setCodigoServico(rs.getInt("codigo_servico"));
        acl.setCodigoUsuario(rs.getInt("codigo_usuario"));
        acl.setNivel(rs.getInt("nivel"));        
        lista.add(acl);
     }
        return lista;
   }
   
   public Acl getByPk(Integer codUsuario, Integer codigoServico) throws SQLException {
       StringBuilder sql = new StringBuilder(this.sqlSelect);
       sql.append(" where codigo_usuario = ? and codigo_servico = ? ");
       PreparedStatement ps = this.cnx.prepareStatement(sql.toString());
       ps.setInt(1, codUsuario);
       ps.setInt(2, codigoServico);
       ps.execute();
       int qtd = ps.getResultSet().getFetchSize();
       Acl acl = new Acl();
       
       if (qtd > 0) {
          ps.getResultSet().first();
          int codigoU = ps.getResultSet().getInt("codigo_usuario");
          int codigoS = ps.getResultSet().getInt("codigo_servico");
          int nivel = ps.getResultSet().getInt("nivel");
          acl.setCodigoServico(codigoS);
          acl.setCodigoUsuario(codigoU);
          acl.setNivel(nivel);
       }  
       return acl;
   }
   

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
