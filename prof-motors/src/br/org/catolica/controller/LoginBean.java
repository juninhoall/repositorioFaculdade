package br.org.catolica.controller;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import br.org.catolica.entity.Login;
import br.org.catolica.jpa.JPAUtil;


@ManagedBean
@SessionScoped
public class LoginBean {

	Login login = new Login();
	
	public void validaLogin(){
		Login newLogin = new Login();
		EntityManager em = JPAUtil.getEntityManager();
		String name = login.getLogin();
		
		try{
			
			newLogin = em.find(Login.class, name);
						
			if(newLogin.getLogin().equals(login.getLogin())){
				
				System.out.println("Login ok");
				if(newLogin.getPassword().equals(login.getPassword())){
					
					System.out.println("Senha ok");
				}else{
					FacesMessage msg = new FacesMessage("Senha incorreto!");
					FacesContext.getCurrentInstance().addMessage(null, msg);
					
				}
			}else{
				FacesMessage msg = new FacesMessage("Login incorreto!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				
			}
			
		}catch (NullPointerException ex){
			FacesMessage msg = new FacesMessage("Login incorreto!");
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
