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
    private List<Contato> contatos = new ArrayList<>();
    
    private Contato contato = new Contato();
    private boolean editando = false;
    
    public String cadastrar(){
        this.daoContato.persist(this.contato);
        this.contato = new Contato();
        return "faces/home.xhtml";
    }
    
    public String editar(Contato c){
        this.contato = c;
        this.editando = true;
        return "faces/home.xhtml";
    }
    
    public String atualizar(){
        this.daoContato.edit(contato);
        this.contato = new Contato();
        this.editando = false;
        return "faces/home.xhtml";
    }
    
    public String remover(Contato c){
        this.daoContato.remove(c);
        return "faces/home.xhtml";
    }
    
    public List<Contato> listar(){
        return this.daoContato.list();
    }
    
    public List<Contato> listContatoAlf(){
     
     return this.lc.ordemAlf();
    
    }

    public ListaContato getLc() {
        return lc;
    }

    public void setLc(ListaContato lc) {
        this.lc = lc;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
 
}
