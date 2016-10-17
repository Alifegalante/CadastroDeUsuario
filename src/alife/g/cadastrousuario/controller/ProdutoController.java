package alife.g.cadastrousuario.controller;

import alife.g.cadastrousuario.model.dao.ProdutoDao;
import alife.g.cadastrousuario.model.domain.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ProdutoController {

    private ProdutoDao dao;
    private Produto produtoManipulado;
    private List<Produto> lista;

    public ProdutoController() {
        this.dao = new ProdutoDao();
        this.produtoManipulado = null;
        this.lista = new ArrayList<Produto>();
    }

    public void pesquisar() {
        this.lista = dao.listar();
    }

    public void novo() {
        this.produtoManipulado = new Produto();
    }

    public void excluir() {
        this.dao.excluir(this.produtoManipulado);
    }

    public void salvar() {
        this.dao.salvar(this.produtoManipulado);
    }

    public Produto getProdutoManipulado() {
        return produtoManipulado;
    }

    public void setProdutoManipulado(Produto produtoManipulado) {
        this.produtoManipulado = produtoManipulado;
    }

    public List<Produto> getLista() {
        return lista;
    }

    public void setLista(List<Produto> lista) {
        this.lista = lista;
    }

   

}
