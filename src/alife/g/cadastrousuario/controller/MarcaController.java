package alife.g.cadastrousuario.controller;

import alife.g.cadastrousuario.model.dao.MarcaDao;
import alife.g.cadastrousuario.model.domain.Marca;
import java.util.ArrayList;
import java.util.List;

public class MarcaController {

    private MarcaDao dao;
    private Marca marcaManipulada;
    private List<Marca> lista;

    public MarcaController() {
        this.dao = new MarcaDao();
        this.marcaManipulada = null;
        this.lista = new ArrayList<Marca>();
    }

    public void pesquisar() {
        this.lista = dao.listar();
    }

    public void novo() {
        this.marcaManipulada = new Marca();
    }

    public void excluir() {
        this.dao.excluir(this.marcaManipulada);
    }

    public void salvar() {
        this.dao.salvar(this.marcaManipulada);
    }

    public Marca getMarcaManipulada() {
        return marcaManipulada;
    }

    public void setMarcaManipulada(Marca marcaManipulada) {
        this.marcaManipulada = marcaManipulada;
    }

    public List<Marca> getLista() {
        return lista;
    }

    public void setLista(List<Marca> lista) {
        this.lista = lista;
    }

}
