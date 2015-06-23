/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolica.controller;

import br.org.catolica.entity.Cidade;
import br.org.catolica.entity.Contato;
import br.org.catolica.jpa.JPAUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Junior
 */
@ManagedBean
@ViewScoped
public class ContatoBean {

    Contato contato = new Contato();

    public String salvar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.persist(contato);
        return "listar?faces-redirect=true";
    }

    public String deletar(Contato contato) {
        EntityManager em = JPAUtil.getEntityManager();
        contato = em.merge(contato);
        em.remove(contato);
         return "listar?faces-redirect=true";
    }

    public void excluir() {
        EntityManager em = JPAUtil.getEntityManager();
        em.remove(contato);
    }

    public void editar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.merge(contato);
    }

    public List<Contato> getContatos() {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("select c from Contato c");
        return query.getResultList();
    }

    public Contato getContato(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Contato.class, id);
    }

    public Contato getContato() {
        return contato;
    }
}
