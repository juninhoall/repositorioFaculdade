/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolica.controller;

import br.org.catolica.entity.UsuarioOld;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Junior
 */
@ManagedBean
@ViewScoped
public class LoginManagedBeanOld {

    private UsuarioBean usuarioBean = new UsuarioBean();
    private UsuarioOld usuario = new UsuarioOld();

    public String envia() {
        usuario = usuarioBean.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
        if (usuario == null) {
            usuario = new UsuarioOld();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
            return null;
        } else {
            return "ola";
        }
    }

    public UsuarioOld getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioOld usuario) {
        this.usuario = usuario;
    }

}
