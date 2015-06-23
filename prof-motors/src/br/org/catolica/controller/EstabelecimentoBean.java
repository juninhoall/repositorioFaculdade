/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolica.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.org.catolica.entity.Cidade;
import br.org.catolica.entity.Contato;
import br.org.catolica.entity.Endereco;
import br.org.catolica.entity.Estabelecimento;
import br.org.catolica.entity.Estado;
import br.org.catolica.entity.Responsavel;
import br.org.catolica.jpa.JPAUtil;

/**
 *
 * @author Junior
 */
@ManagedBean
@ViewScoped
public class EstabelecimentoBean {

	Estabelecimento estabelecimento = new Estabelecimento();
	Endereco endereco;
	Cidade cidade;
	Contato contato;
	Responsavel responsavel;
	Estado estado;
	
	List<Estabelecimento> est = new ArrayList<Estabelecimento>();

	

	@PostConstruct
	public void init() {
		this.endereco = new Endereco();
		this.cidade = new Cidade();
		this.estado = new Estado();
		this.contato = new Contato();
		this.responsavel = new Responsavel();
		
		this.estabelecimento.setContato(contato);
		this.cidade.setEstado(estado);
		this.endereco.setCidade(cidade);	
		this.estabelecimento.setResponsavel(responsavel);
		this.estabelecimento.setEndereco(endereco);
	}

	public void salvar(){
		this.cidade.setEstado(estado);
		this.endereco.setCidade(cidade);
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
//		EntityManager em = JPAUtil.getEntityManager();
//		Query query = em.createQuery("select c from Estabelecimento c");
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select c from Estabelecimento c where c.endereco.cidade= :nomeCidade");
		query.setParameter("nomeCidade", cidade.getNome());
		
		
		return query.getResultList();
	}

	public void getEstabelecimentosUF() {
		
		System.out.println(cidade.getNome());
		if(cidade == null || cidade.getNome().equals("")){
			
			
		}else{
			
			EntityManager em = JPAUtil.getEntityManager();
	    	String jpql = "select c from Estabelecimento c where c.endereco.cidade.nome= :nomeCidade ";
	    	
			Query query = em.createQuery(jpql, Estabelecimento.class);
			query.setParameter("nomeCidade", cidade.getNome());
			
			est = query.getResultList();
		}
		
	}

	public Estabelecimento getEstablecimento(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		return em.find(Estabelecimento.class, id);
	}

	public Estabelecimento getEstablecimento() {
		return estabelecimento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estabelecimento> getEst() {
		return est;
	}

	public void setEst(List<Estabelecimento> est) {
		this.est = est;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	
	
	
}
