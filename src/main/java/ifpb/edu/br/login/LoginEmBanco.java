/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.login;

import ifpb.edu.br.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Cliente
 */
public class Login {

    EntityManager em = Persistence
            .createEntityManagerFactory("DAC")
            .createEntityManager();

    public boolean autenticar(String email, String senha) {
        try {

            String sql = "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha ";
            TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            Usuario u = query.getSingleResult();

            return true;
        } catch (NoResultException ex) {
            return false;

        }

    }
}
