package br.org.catolica.controller;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.org.catolica.entity.Estabelecimento;
import br.org.catolica.entity.Login;
import br.org.catolica.jpa.JPAUtil;


@ManagedBean
@SessionScoped
public class LoginBean{


	
	Login login = new Login();
	
	public void validaLogin(){
		Login newLogin = new Login();
		EntityManager em = JPAUtil.getEntityManager();
		//String name = login.getLogin();
		
		try{
			
			String jpql = "select l from Login l where l.login = :tLogin";
			Query query = em.createQuery(jpql, Login.class);
			query.setParameter("tLogin", login.getLogin());
			newLogin = (Login) query.getSingleResult();
			
			System.out.println(login.getId());
			System.out.println("New = "+newLogin.getLogin());
						
			if(newLogin.getLogin().equals(login.getLogin())){
				
				System.out.println("Login ok");
				if(newLogin.getPassword().equals(login.getPassword())){
					
					System.out.println("Senha ok");
					//estabelecimento.getResponsavel().getLogin();
					jpql = "select c from Estabelecimento c where c.responsavel.login.login = :tLogin";
					query = em.createQuery(jpql, Estabelecimento.class);
					query.setParameter("tLogin", login.getLogin());
					Estabelecimento estabelecimento = new Estabelecimento();				
					
					estabelecimento = (Estabelecimento) query.getSingleResult();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println(estabelecimento.getNome());
					
				}else{
					FacesMessage msg = new FacesMessage("Senha incorreto!");
					FacesContext.getCurrentInstance().addMessage(null, msg);
					
				}
			}else{
				FacesMessage msg = new FacesMessage("Login incorreto!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				
			}
			
		}catch (NullPointerException ex){
			FacesMessage msg = new FacesMessage("Login incorretoooo!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			
		}
		
				
		
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	
	
	

}
