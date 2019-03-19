/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.controller;

import ifpb.edu.br.contato.Contato;
import ifpb.edu.br.contato.ListaContato;
import java.util.List;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Cliente
 */
@javax.faces.bean.ManagedBean(name = "controladorcontato")
@RequestScoped
public class ContatoController {
    
    ListaContato lc = new ListaContato();
    Contato c = new Contato();
    
    
    public List<Contato> listContatoAlf(){
     
     return this.lc.ordemAlf();
    
    }

    public ListaContato getLc() {
        return lc;
    }

    public void setLc(ListaContato lc) {
        this.lc = lc;
    }

    public Contato getC() {
        return c;
    }

    public void setC(Contato c) {
        this.c = c;
    }
    
    
    
}
