/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolica.controller;

import br.org.catolica.entity.Cidade;
import br.org.catolica.entity.Estado;
import br.org.catolica.jpa.JPAUtil;

import java.util.ArrayList;
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
public class EstadoBean {

	private Estado estado;


	
	public void salvar() {
		EntityManager em = JPAUtil.getEntityManager();
		em.persist(estado);
	}

	public void deletar() {
		EntityManager em = JPAUtil.getEntityManager();
		em.remove(estado);
	}

	public void alterar() {
		EntityManager em = JPAUtil.getEntityManager();
		em.merge(estado);
	}

	public List<Estado> getEstados() {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select c from Estado c");
		return query.getResultList();
	}

	public Estado getEstadoA(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		return em.find(Estado.class, id);
	}

	public Estado getEstado() {
		//this.estado.setCidades(new ArrayList<Cidade>());
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;	
	}
}
