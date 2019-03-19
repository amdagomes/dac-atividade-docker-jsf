package com.ifpb.dac;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Amand
 */
@Named
@RequestScoped
public class ControllerContato {
    
//    @EJB
    private ContatoDaoIF daoContato = new ContadoDao();
    private List<Contato> contatos = new ArrayList<>();
    
    private Contato contato = new Contato();
    private boolean editando = false;
    
    public String cadastrar(){
        this.daoContato.persist(this.contato);
        this.contato = new Contato();
        return null;
    }
    
    public String editar(Contato c){
        this.contato = c;
        this.editando = true;
        return null;
    }
    
    public String atualizar(){
        this.daoContato.edit(contato);
        this.contato = new Contato();
        this.editando = false;
        return null;
    }
    
    public String remover(Contato c){
        System.out.println(c.getId());
        this.daoContato.remove(c);
        return "faces/home.xhtml";
    }
    
    public List<Contato> listar(){
        return this.daoContato.list();
    }

    public Contato getContato() {
        return this.contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Contato> getContatos() {
        this.contatos = listar();
        return this.contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

}
