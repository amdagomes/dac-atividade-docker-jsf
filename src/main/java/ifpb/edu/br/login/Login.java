/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.login;

import javax.persistence.NoResultException;

/**
 *
 * @author Cliente
 */
public class Login {

    private final String USUARIO = "admin";
    private final String SENHA = "admin";

    public boolean autenticar(String email, String senha) {
        try {
            if (this.USUARIO.equals(email) && this.SENHA.equals(senha)) {
                return true;
            }
            return false;
        } catch (NoResultException ex) {
            return false;

        }

    }
}
