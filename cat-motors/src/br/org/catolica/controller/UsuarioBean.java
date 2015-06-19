/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolica.controller;

import br.org.catolica.entity.UsuarioOld;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author Junior
 */
public class UsuarioBean {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
    private EntityManager em = factory.createEntityManager();

    public UsuarioOld getUsuario(String nomeUsuario, String senha) {
        try {
            UsuarioOld usuario = (UsuarioOld) em.createQuery("SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha").setParameter("name", nomeUsuario).setParameter("senha", senha).getSingleResult();
            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean inserirUsuario(UsuarioOld usuario) {
        try {
            em.persist(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletarUsuario(UsuarioOld usuario) {
        try {
            em.remove(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
