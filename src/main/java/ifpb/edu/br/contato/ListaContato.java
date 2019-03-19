/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.contato;

import ifpb.edu.br.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Cliente
 */
public class ListaContato {

    EntityManager em = Persistence
            .createEntityManagerFactory("DAC")
            .createEntityManager();

    public List<Contato> ordemAlf() {
        String sql = " SELECT c FROM Contato c ORDER BY nome asc";
        TypedQuery<Contato> query = em.createQuery(sql, Contato.class);
        List<Contato> resultList = query.getResultList();

        return resultList;

    }

    public Contato buscarporNome(String nome) {
        try {
            nome = nome.toUpperCase();
            String sql = " SELECT c FROM Contato c where UPPER(c.nome) = : nome";
            TypedQuery<Contato> query = em.createQuery(sql, Contato.class);
            query.setParameter("nome", nome);
            Contato c = query.getSingleResult();
            return c;
        } catch (NoResultException ex) {
            return null;

        }

    }

    public List<Contato> agruparPorLetra() {
        String sql = " SELECT c FROM Contato c ORDER BY nome asc";
        TypedQuery<Contato> query = em.createQuery(sql, Contato.class);
        List<Contato> resultList = query.getResultList();

        return resultList;
    }

}
