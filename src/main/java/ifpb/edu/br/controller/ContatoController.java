/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.controller;

import ifpb.edu.br.contato.ContadoDao;
import ifpb.edu.br.contato.ContatoDaoIF;
import ifpb.edu.br.contato.Contato;
import ifpb.edu.br.contato.ListaContato;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Cliente
 */
@javax.faces.bean.ManagedBean(name = "controladorcontato")
@RequestScoped
public class ContatoController {

    private ContatoDaoIF daoContato = new ContadoDao();
    ListaContato lc = new ListaContato();
    private List<Contato> listContatos = new ArrayList<>();
    private List<Contato> resultadoBusca = new ArrayList<>();

    private Contato contato = new Contato();
    private String nome;
    private boolean editando = false;

    @PostConstruct
    public void init(){
        listar();
    }
    
    public String cadastrar() {
        this.daoContato.persist(this.contato);
        this.contato = new Contato();
        listar();
        return null;
    }

    public String editar(Contato c) {
        this.contato = c;
        this.editando = true;
        return null;
    }

    public String atualizar() {
        System.out.println("Controler contato id: " + this.contato.getId());
        this.daoContato.edit(this.contato);
        this.contato = new Contato();
        this.editando = false;
        listar();
        return null;
    }

    public String remover(Contato c) {
        this.daoContato.remove(c);
        listar();
        return null;
    }
    
    public String listar() {
        this.listContatos = this.daoContato.list();
        return null;
    }

    public String listContatoAlf() {
        this.listContatos = this.lc.ordemAlf();
        return null;
    }
    
    public String buscarPorNome(){
        this.resultadoBusca = this.lc.buscarporNome(nome);
        return "faces/resultado-busca.xhtml";
    }

    public List<Contato> getListContatos() {
        return listContatos;
    }

    public void setListContatos(List<Contato> listContatos) {
        this.listContatos = listContatos;
    }

    public List<Contato> getResultadoBusca() {
        return resultadoBusca;
    }

    public void setResultadoBusca(List<Contato> resultadoBusca) {
        this.resultadoBusca = resultadoBusca;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

}
