/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolica.controller;

import br.org.catolica.entity.Estado;
import br.org.catolica.entity.Responsavel;
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
public class ResponsavelBean {

    Responsavel responsavel = new Responsavel();

    public void salvar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.persist(responsavel);
    }

    public void deletar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.remove(responsavel);
    }

    public void alterar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.merge(responsavel);
    }

    public List<Responsavel> getResponsaveis() {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("select c from Responsavel c");
        return query.getResultList();
    }

    public Responsavel getResponsavel(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Responsavel.class, id);
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

}
