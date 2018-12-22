package com.digital.education.system.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface IEmailService {
	public void sendEmailWithAttachments(String host, String port, final String userName, final String password,
			String toAddress, String subject, String message, List<String> attachFiles)
			throws AddressException, MessagingException;

}
