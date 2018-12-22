package com.digital.education.system.ui.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import com.digital.education.system.service.impl.EmailService;

@ManagedBean
@RequestScoped
public class EmailServiceManagedBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String host = "smtp.gmail.com";
	private String port = "587"; 
	private String mailFrom = "digitalsystemstartup@gmail.com";
	private String password = "Zxcv#89zxcv";
	private String subjectRequest = "Varsha Enetrprises Mineral Water Request Received by -";
	private String subjectReponse = "Varsha Eneterprises Mineral Water Distributors .";
	private String messageReponse = "<br></br>We Received your request for Mineral water.<br></br>Our team will contact you shortly. <br></br><br></br>Thank you so much for contacting us.<br></br><br></br><b>Thanks & Regards,</b><br></br>Varsha Eneterprises,<br></br>23/ 43, Bahadur Compound, <br></br>Ground Floor,<br></br>M P City Marg Fort,<br></br>Near Andhra Bank,<br></br>Mumbai-400001<br></br><b>M: </b>+91-9152847326<br></br><b>Mail-Id: </b>help@varshaenterprises.info<br></br><b><a href=www.varshaenterprises.info>www.varshaenterprises.info</a></b>";
	private String name;
	private Long mobileNumber;
	private String emailId;
	private String messages1;
	private String address;

	public void action() {
		try {
			System.out.println("Action Called");
			System.out.println("name=" + name + getName());
			System.out.println("mobileNumber=" + mobileNumber + getMobileNumber());
			System.out.println("emailId=" + emailId);
			System.out.println("messages1=" + messages1);
			System.out.println("address=" + address);
			String details="<table><tr><b> Customer Details : </b><br></br></tr></table><table border=1><tr><td>Name: </td><td>"+name+"</td></tr><tr><td>Mobile No: </td><td>"+mobileNumber+"</td></tr><tr><td>Email: </td><td>"+emailId+"</td></tr><tr><td>Address: </td><td>"+address+"</td></tr></table>";
			subjectRequest=subjectRequest+" "+name +" ,Mobile No: "+mobileNumber;
			messageReponse="<font face=verdana>"+"Hello <b>Mr. "+name+ " ,</b><br></br>"+messageReponse+" </font>";
			messages1=messages1+"<br></br>"+details+"<br></br><b>Thanks & Regards,</b><br></br>Varsha Enterprises<br></br><a href=www.varshaenterprises.info>www.varshaenterprises.info</a> ";
			List<String> attachFiles = new ArrayList<String>();
			EmailService emailService = new EmailService();
			emailService.sendEmailWithAttachments(host, port, mailFrom, password, emailId, subjectReponse,
					messageReponse, attachFiles);
			emailService.sendEmailWithAttachments(host, port, mailFrom, password, "help@varshaenterprises.info", subjectRequest,
					messages1, attachFiles);
			messages1="";

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Your Request Submitted Successfully.", "Your Request Submitted Successfully."));

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Unable to submit your request.Please Check your Mail Id.",
							"Unable to submit your request.Please Check your Mail Id."));
			e.printStackTrace();
		} catch (MessagingException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Unable to submit your request.Please Check your Mail Id.",
							"Unable to submit your request.Please Check your Mail Id."));
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



	public Long getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getMessages1() {
		return messages1;
	}



	public void setMessages1(String messages1) {
		this.messages1 = messages1;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
