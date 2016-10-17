package alife.g.cadastrousuario.controller;

import alife.g.cadastrousuario.model.dao.ServicoDoSistemaDao;
import alife.g.cadastrousuario.model.domain.ServicoDoSistema;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class ServicoDoSistemaController {
    private ServicoDoSistemaDao dao;

    public ServicoDoSistemaController() throws Exception {
        try {
            this.dao = new ServicoDoSistemaDao();
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public List<ServicoDoSistema> pesquisar(String nome) throws Exception {
        try {
            if (nome.equalsIgnoreCase("")) {
                return this.dao.listarTodos();
            } else {
                return this.dao.listarPorNome(nome);
            }
               
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public void excluir (ServicoDoSistema s) throws Exception {
        try {
            this.dao.remover(s);
        }catch (SQLException ex) {
            throw new Exception (ex.getMessage());
        }
    }
    
    public void salvar (ServicoDoSistema s) throws Exception {
        try {
            this.dao.salvar(s);
        }catch (SQLException ex) {
            throw new Exception (ex.getMessage());
        }
    }
    
    public void salvarTodos(List<ServicoDoSistema> todos) throws Exception {
        for (Iterator<ServicoDoSistema> servicos = todos.iterator(); servicos.hasNext();) {
            ServicoDoSistema servico = servicos.next();
            this.salvar(servico);
        }
 
    }
    
}
