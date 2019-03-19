package com.ifpb.dac;

import java.util.List;

/**
 *
 * @author Amanda
 */
public interface ContatoDaoIF {
    public void persist(Contato contato);
    public void edit(Contato contato);
    public void remove(Contato contato);
    public List<Contato> list();
}
