package ifpb.edu.br.contato;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Amanda
 */
@Stateless
public class ContadoDao implements ContatoDaoIF {

    private EntityManager em = Persistence
            .createEntityManagerFactory("DAC")
            .createEntityManager();

    @Override
    public void persist(Contato contato) {
        em.getTransaction().begin();
        em.persist(contato);
        em.getTransaction().commit();
    }

    @Override
    public void edit(Contato contato) {
        Contato c = em.find(Contato.class, contato.getId());
        c.setNome(contato.getNome());
        c.setEmail(contato.getEmail());
        c.setTelefone(contato.getTelefone());
        c.setDataNascimento(contato.getDataNascimento());
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Contato c) {
        if (c != null) {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        }
    }

    @Override
    public List<Contato> list() {
        String sql = "SELECT c FROM Contato c";
        TypedQuery<Contato> query = em.createQuery(sql, Contato.class);
        List<Contato> lista = query.getResultList();
        return lista;
    }

}
