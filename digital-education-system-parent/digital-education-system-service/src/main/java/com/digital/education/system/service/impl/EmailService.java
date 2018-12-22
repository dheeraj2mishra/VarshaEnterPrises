package com.digital.education.system.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.inject.Named;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.transaction.annotation.Transactional;

import com.digital.education.system.service.IEmailService;

@Named
@Transactional(readOnly = true)
public class EmailService implements IEmailService {
	 public EmailService() {
		// TODO Auto-generated constructor stub
	}

	@Transactional(readOnly = false)
	public  void sendEmailWithAttachments(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message, List<String> attachFiles)
            throws AddressException, MessagingException {
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
 
        // creates a new session with an authenticator
        System.out.println("userName="+userName);
        System.out.println("toAddress="+toAddress);
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        String[] toAddressarray=toAddress.split(";");
        //InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        InternetAddress[] toAddresses = new InternetAddress[toAddressarray.length];

        
        if(toAddressarray.length>0) {
        	int i=0;
        	for(String address:toAddressarray) {
        		InternetAddress internetAddres=new InternetAddress(address);
        		toAddresses[i]=internetAddres;
        		i++;
        		
        	}
        	
        }
       // InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
       
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        MimeBodyPart attachPart=null;
        if (attachFiles != null && attachFiles.size() > 0) {
            for (String filePath : attachFiles) {
                 attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
            }
        }
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);
        System.out.println("Mail Sent Successfully");
 
    }
		
	

}
