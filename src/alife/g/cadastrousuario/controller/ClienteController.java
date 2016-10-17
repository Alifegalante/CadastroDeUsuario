package alife.g.cadastrousuario.controller;

import alife.g.cadastrousuario.model.dao.ClienteDao;
import alife.g.cadastrousuario.model.domain.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ClienteController {

    private ClienteDao dao;
    private Cliente clienteManipulada;
    private List<Cliente> lista;

    public ClienteController() {
        this.dao = new ClienteDao();
        this.clienteManipulada = null;
        this.lista = new ArrayList<Cliente>();
    }

    public void pesquisar() {
        this.lista = dao.listar();
    }

    public void novo() {
        this.clienteManipulada = new Cliente();
    }

    public void excluir() {
        this.dao.excluir(this.clienteManipulada);
    }

    public void salvar() {
        this.dao.salvar(this.clienteManipulada);
    }

    public Cliente getClienteManipulada() {
        return clienteManipulada;
    }

    public void setClienteManipulada(Cliente clienteManipulada) {
        this.clienteManipulada = clienteManipulada;
    }

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

}
