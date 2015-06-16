/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolica.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Junior
 */
@Entity
public class Estado implements Serializable {

    @GeneratedValue
    @Id
    private Long id;

    private String nome;
    private String sigla;
    
    @OneToMany(mappedBy = "estado")
    private List <Cidade> cidades;
    
    public Estado(){
        cidades = new ArrayList<Cidade>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List <Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List <Cidade> cidades) {
        this.cidades = cidades;
    }
    
    
    
    
}
