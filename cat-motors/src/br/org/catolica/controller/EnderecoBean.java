/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolica.controller;

import br.org.catolica.entity.Cidade;
import br.org.catolica.entity.Endereco;
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
public class EnderecoBean {

    Endereco endereco = new Endereco();

    public void salvar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.persist(endereco);
    }

    public void deletar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.remove(endereco);
    }

    public void alterar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.merge(endereco);
    }

    public List<Endereco> getEnderecos() {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("select c from Endereco c");
        return query.getResultList();
    }

    public Endereco getEndereco(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Endereco.class, id);
    }

    public Endereco getEndereco() {
        return endereco;
    }

}
