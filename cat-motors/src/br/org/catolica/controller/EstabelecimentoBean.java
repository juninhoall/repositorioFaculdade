/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolica.controller;

import br.org.catolica.entity.Endereco;
import br.org.catolica.entity.Estabelecimento;
import br.org.catolica.jpa.JPAUtil;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class EstabelecimentoBean {

    Estabelecimento estabelecimento = new Estabelecimento();
    Endereco endereco ;

     @PostConstruct
     public void init(){
         this.endereco = new Endereco();
         this.estabelecimento.setEndereco(endereco);
     }
    public void salvar() {
        
        System.out.print("Bairro : ");
        System.out.println(endereco.getBairro());
        System.out.println(estabelecimento.getCnpj());
        
        
        EntityManager em = JPAUtil.getEntityManager();
        em.persist(estabelecimento);
    }

    public void deletar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.remove(estabelecimento);
    }

    public void alterar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.merge(estabelecimento);
    }

    public List<Estabelecimento> getEstabelecimentos() {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("select c from Estabelecimento c");
        return query.getResultList();
    }

    public Estabelecimento getEstablecimento(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Estabelecimento.class, id);
    }

    public Estabelecimento getEstablecimento() {
        return estabelecimento;
    }
}
