package com.digital.education.system.ui.managed.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class RegisterManagedBean implements Serializable {


	/**
	 * 
	 */
	String name;
	private static final long serialVersionUID = 1L;
	
	public void action() {
		try {
			FacesContext fContext = FacesContext.getCurrentInstance();
			ExternalContext extContext = fContext.getExternalContext();
			extContext.redirect(extContext.getRequestContextPath() +"/"+ "pages/register.xhtml?faces-redirect=true");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
