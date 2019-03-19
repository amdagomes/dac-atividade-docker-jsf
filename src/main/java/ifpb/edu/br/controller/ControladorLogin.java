/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.controller;

import ifpb.edu.br.login.Login;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Cliente
 */
@javax.faces.bean.ManagedBean(name = "controladorLogin")
@RequestScoped
public class ControladorLogin {

    private String email;
    private String senha;

    private Login login = new Login();

    public void login() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (login.autenticar(email, senha)) {
            context.getExternalContext().getSessionMap().put("usuario", email);
            try {
                context.getExternalContext().redirect("home.xhtml");
            } catch (IOException e) {
            }
        } else {

            context.addMessage(null, new FacesMessage("Usuário não registrado. Verifique email e senha"));

        }
    }

    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
