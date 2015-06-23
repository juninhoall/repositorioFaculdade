/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolica.controller;

import br.org.catolica.entity.Cidade;
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
public class CidadeBean {

    private Cidade cidade = new Cidade();

    public void salvar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.persist(cidade);
    }

    public void deletar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.remove(cidade);
    }

    public String deletar(Cidade cidade) {
        EntityManager em = JPAUtil.getEntityManager();
        cidade = em.merge(cidade);
        em.remove(cidade);
        return "listar?faces-redirect=true";
    }

    public void alterar(Cidade cidade) {
        this.cidade = cidade;
    }

    public void alterar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.merge(cidade);
    }

    public List<Cidade> getCidades() {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("select c from Cidade c");
        return query.getResultList();
    }

    public Cidade getCidade(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Cidade.class, id);
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
